(ns clj-forward.core
  (:require [martian.core :as martian]
            [martian.interceptors :as i]
            [martian.clj-http-lite :as martian-http]
            [clj-forward.utils :as utils]
            [clojure.pprint :as pprint]
            [clojure.string :as str]
            [taoensso.timbre :as timbre]
            [martian.interceptors :as interceptors]))

(timbre/refer-timbre)
(timbre/merge-config! {:appenders {:println {:enabled? true}}})
(timbre/set-level! :debug)

(defn add-custom-header [user password debug insecure?]
  {:name  ::add-authentication-header
   :enter (fn [ctx]
            (-> ctx
                (assoc-in [:request :headers "Authorization"] (str "Basic:" (utils/encode (str user ":" password))))
                (assoc-in [:request :debug] debug)
                (assoc-in [:request :insecure?] insecure?)
                ))})


(defn create-fwd-context [{:keys [swagger user password debug insecure?]
                           :or   {debug     false
                                  insecure? false}}]
  (let [default-interceptors (concat martian/default-interceptors [(add-custom-header user password debug insecure?)
                                                                   interceptors/default-encode-body
                                                                   interceptors/default-coerce-response
                                                                   martian-http/perform-request])]
    (martian-http/bootstrap-swagger swagger
                                    {
                                     :interceptors default-interceptors
                                     ;(concat
                                     ;                [(add-authentication-header user password)
                                     ;                 martian-http/perform-request]
                                     ;                martian/default-interceptors)
                                     ;;(perform-request  {:insecure? true})
                                     ;#(martian-http/perform-request (merge % {:insecure? true}))
                                     :http-opts    {:insecure?  true
                                                    :basic-auth (str user ":" password)}})))

(def explore martian/explore)
(def request-for martian/request-for)
(def response-for martian/response-for)

(defn get-description [k api]
  (let [api (explore api)
        api-keys (mapv first api)
        descriptions (mapv second api)]
    (get descriptions (.indexOf api-keys k))))

(defn get-commands [martian]
  (let [split1 (re-pattern #"^(\w+)-(.*)-using-(.*)")
        split2 (re-pattern #"^(\w+)-using-(.*)")
        ks (mapv first (explore martian))]
    (reduce (fn [acc m]
              (let [split (if (some? (re-find split1 (name m))) (re-find split1 (name m)) (re-find split2 (name m)))
                    sub (nth split 1)
                    command (nth split 2)
                    verb (last split)
                    [s c v] (condp = verb
                              "get" ["show" command verb]
                              "list" ["show" command verb]
                              "create" ["create" command verb]
                              "delete" ["delete" command verb]
                              "patch" ["update" command verb]
                              "set" ["set" command verb]
                              "cancel" ["cancel" command verb]
                              "deactivate" ["deactivate" command verb]
                              "put" ["put" command verb]
                              "zip" ["zip" command verb]
                              "post" ["post" command verb]
                              "add" ["add" command verb]
                              "update" ["update" command verb]
                              "run" ["run" command verb]
                              "edit" ["edit" command verb]
                              "collect" ["collect" "network" verb]
                              ["Found error" m]
                              )]
                (conj acc {:sub s :command c :verb v :base m})))
            []
            ks)))

(defn get-command [k martian]
  (let [cmds (get-commands martian)]
    (vec (for [m cmds
               :when (= (:sub m) k)
               :let [model (explore martian (:base m))
                     params (get-in model [:parameters])
                     params-ks (filterv #(not= (type %) schema.core.OptionalKey) (vec (keys params)))
                     ]]
           (assoc m :base (:base m) :param params-ks :summary (:summary model))
           ))))


;:get-device-credentials-using-get
;"Lists a network’s device credentials"]
;[:create-device-credential-using-post


;(defn get-api-version [ctx]
;  (let [api (create-fwd-context ctx)]
;    (pprint/pprint api)))


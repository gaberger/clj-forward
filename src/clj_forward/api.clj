(ns clj-forward.api
  (:require [clj-forward.core :refer [bootstrap-openapi add-custom-header]]
            [clj-forward.specs :as specs]
            [cheshire.core :refer [parse-string]]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [failjure.core :as f]))

;(defn create-fwd-context-custom [{:keys [swagger]}]
;  (martian/bootstrap swagger
;                     [{:route-name  :load-pet
;                       :path-parts  ["/pets/" :id]
;                       :method      :get
;                       :path-schema {:id s/Int}}
;
;                      {:route-name  :create-pet
;                       :produces    ["application/xml"]
;                       :consumes    ["application/xml"]
;                       :path-parts  ["/pets/"]
;                       :method      :post
;                       :body-schema {:pet {:id   s/Int
;                                           :name s/Str}}}]))

(defn create-fwd-context [{:keys [server version user password debug insecure]
                           :or   {debug false insecure false} :as args}]
  {:pre [(s/valid? ::specs/input-spec args)]}
  (let [api-spec (parse-string (slurp (io/resource (format "api-%s.json" version))))]
    (bootstrap-openapi server api-spec)
    (add-custom-header user password debug insecure)))



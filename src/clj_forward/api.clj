(ns clj-forward.api
  (:require [clj-forward.core :refer [bootstrap-openapi add-custom-header]]
            [cheshire.core :refer [parse-string]]
            [clojure.java.io :as io]))

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

(defn create-fwd-context [{:keys [server version user password debug insecure]}]
  (bootstrap-openapi server (parse-string (slurp (io/resource (format "api-%s.json" version))))
                     (add-custom-header user password debug insecure)))



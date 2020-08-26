(ns clj-forward.api
  (:require [martian.core :as martian]))

(defn create-fwd-context-custom [{:keys [swagger]}]
  (martian/bootstrap swagger
                     [{:route-name  :load-pet
                       :path-parts  ["/pets/" :id]
                       :method      :get
                       :path-schema {:id s/Int}}

                      {:route-name  :create-pet
                       :produces    ["application/xml"]
                       :consumes    ["application/xml"]
                       :path-parts  ["/pets/"]
                       :method      :post
                       :body-schema {:pet {:id   s/Int
                                           :name s/Str}}}]))

(ns clj-forward.specs
  (:require [clojure.spec.alpha :as s]))

(s/def ::server string?)
(s/def ::version string?)
(s/def ::user string?)
(s/def ::password string?)
(s/def ::debug boolean?)
(s/def ::insecure boolean?)
(s/def ::input-spec (s/keys :req-un [::server ::version ::user ::password]
                            :opt-un [::debug ::insecure]))

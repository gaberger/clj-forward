(ns clj-forward.utils
  (:import (java.util Base64)))

(defn encode [to-encode]
  (.encodeToString (Base64/getEncoder) (.getBytes to-encode)))

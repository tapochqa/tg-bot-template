(ns {{name}}.core 
  (:require
    [{{name}}.telegram :as telegram]
    [{{name}}.polling  :as polling]
    [clojure.string    :as str]
    [cheshire.core     :as json]))


(defn -main
  [my-token]
  (polling/run-polling {:telegram {:token my-token} :polling {:update-timeout 1000}}))
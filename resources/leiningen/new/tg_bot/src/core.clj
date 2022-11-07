(ns {{name}}.core 
  (:gen-class)
  (:require
    [{{name}}.polling  :as polling]
    [{{name}}.lambda   :as lambda]
    [clojure.string    :as str]
    [cheshire.core     :as json]))


(defn polling
  [my-token]
  (polling/run-polling {:telegram {:token my-token} :polling {:update-timeout 1000}}))

(defn lambda
  [my-token]
  (-> (lambda/->request)
      (lambda/handle-request! my-token)
      (lambda/response->)))

(defn -main
  [my-token]
  #_(polling/run-polling {:telegram {:token my-token} :polling {:update-timeout 1000}})
  #_(lambda my-token)
  )
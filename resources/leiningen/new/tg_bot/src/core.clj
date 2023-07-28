(ns {{name}}.core 
  (:gen-class)
  (:require
    [{{name}}.polling  :as polling]
    [{{name}}.lambda   :as lambda]
    [clojure.string    :as str]
    [cheshire.core     :as json]))


(defn polling
  [config]
  (polling/run-polling config))

(defn lambda
  [config]
  (-> (lambda/->request config)
      (lambda/handle-request! config)
      (lambda/response->)))

(defn -main
  [my-token]
  
  (let [config 
        { :test-server false
          :token my-token
          :polling {:update-timeout 1000}
          }]
  #_(polling/run-polling config)
  #_(lambda config)))


(comment
  
   (binding [*in* (-> "trigger-request.json"
                 clojure.java.io/resource
                 clojure.java.io/reader)]
     
     (-main "...:..."))
  
  
  (-main "...:...")
  
  )
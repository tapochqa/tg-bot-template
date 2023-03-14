(ns {{name}}.handling
  (:require
    [tg-bot-api.telegram :as telegram]))


(defn the-handler 
  "Bot logic here"
  [config message]
  
  (telegram/send-message config (-> message :chat :id) (:text message))
  
)
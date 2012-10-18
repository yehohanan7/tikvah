(ns com.tikvah.facts.mongostore
  "monbo db facts storage"
  (:use com.tikvah.facts.store))

(deftype MongoStore [fact-type fact-identity]
  FactStore
  (fact [subject verb object]
    (str "not implemented yet!")
    )
  )

(def mongo-store (MongoStore.))
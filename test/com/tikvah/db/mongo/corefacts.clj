(ns com.tikvah.db.mongo.corefacts
  (:use [com.tikvah.db.mongo.core])
  (:use [com.tikvah.db.store])
  (:use [midje.sweet])
  (:use [com.tikvah.commons.sugar]))

(let [store (mongo-store "tikvah" {:host "localhost" :port 1111})]
  (fact (collection store :products) => #(not-nil? %))
  )


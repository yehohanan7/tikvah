(ns com.tikvah.db.core
  (:use [com.tikvah.db.mongo.core]))


(defn store
  ([name] (store name {:host "localhost" :port 27017}))
  ([name options] (mongo-store name options))
  )





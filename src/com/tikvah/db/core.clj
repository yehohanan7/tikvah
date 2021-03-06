(ns com.tikvah.db.core
  (:use [clojure.java.shell])
  (:require [com.tikvah.db.mongo.core :as mongo]))

(def $gt mongo/$gt)
(def $eq mongo/$eq)


(defn store
  ([name] (store name {:host "localhost" :port 27017}))
  ([name options] (mongo/mongo-store name options))
  )




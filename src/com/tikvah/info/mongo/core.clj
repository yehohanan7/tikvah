(ns com.tikvah.info.mongo.core
  (:use [com.tikvah.info.store])
  (:import [com.mongodb DB DBCollection BasicDBObject DBObject DBCursor Mongo]))

(def ^{:private true} mongodb (atom nil))

(defn- connected? []
  (not (nil? @mongodb))
  )

(defn- connect! [host port db]
  (if-not (connected?)
    (do
      (println "establishing mongo db connection.....")
      (reset! mongodb (.getDB (Mongo. host port) db))
      )
    )
  )

(connect! "localhost" 27017 "tikvah")

(defn entitytypes []
  (.getCollectionNames @mongodb)
  )

(defn query [entity-type conditions]
  (let [entitystore (.getCollection @mongodb entity-type)]
    (.findOne entitystore)
    )
  )

(defrecord MongoInfoStore [entity-type conditions]
  InformationStore
  (search [self] (query entity-type conditions))
  )

(defn mongo-store [entity-type conditions]
  (MongoInfoStore. entity-type conditions)
  )


(ns com.tikvah.info.mongo.core
  "A clojure wrapper around mongo db java driver."
  (:use [com.tikvah.info.store])
  (:import [com.mongodb DB DBCollection BasicDBObject DBObject DBCursor Mongo]))

(def ^{:private true} mongodb (atom nil))

(defn- connected? []
  (not (nil? @mongodb))
  )

(defn- connect! "creates a new connection to the mongo db." [host port db]
  (if-not (connected?)
    (do
      (println "establishing mongo db connection.....")
      (reset! mongodb (.getDB (Mongo. host port) db))
      )
    )
  )

(connect! "localhost" 27017 "tikvah")

(defn entitytypes "Fetches all the entities (collections in mongo terminology) available in mongodb" []
  (.getCollectionNames @mongodb)
  )

(defn query "queries for the entity type (collection) with specific conditions " [entity-type conditions]
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


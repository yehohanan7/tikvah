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

(defn- update-query! [query [k op v]]
  (.put query (name k) v)
  )

(defn- apply-all [query conditions]
  (doseq [condition conditions] (update-query! query condition))
  )

(defn with-query [conditions]
  (doto (BasicDBObject.) (apply-all conditions))
  )


(defn- collection [entity-type]
  (.getCollection @mongodb (name entity-type))
  )

(defn- cursor [collection conditions]
  (if (nil? conditions)
    (.find collection)
    (.find collection (with-query conditions))
    )
  )

(defn entitytypes "Fetches all the entities (collections in mongo terminology) available in mongodb" []
  (.getCollectionNames @mongodb)
  )


(defn convert [dbobject]
  (.get dbobject "name")
  )

(defn parse-cursor [cursor result]
  (if (.hasNext cursor)
    (recur cursor (conj result (convert (.next cursor))))
    result
    )
  )

(defn fetch-data [collection conditions]
  (parse-cursor (cursor collection conditions) [])
  )

(defn query "queries for the entity type (collection) with specific conditions " [entity-type conditions]
  (fetch-data (collection entity-type) conditions)
  )

(defrecord MongoInfoStore [entity-type conditions]
  InformationStore
  (search [self] (query entity-type conditions))
  )

(defn mongo-store [entity-type conditions]
  (MongoInfoStore. entity-type conditions)
  )


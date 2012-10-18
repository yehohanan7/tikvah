(ns com.tikvah.info.mongo.core
  (:use [com.tikvah.info.store])
  (:import [com.mongodb DB DBCollection BasicDBObject DBObject DBCursor Mongo]))

(def ^{:private true} mongodb (atom nil))

(defn- connected? []
  (not (nil? @mongodb))
  )


(defn connect [host port db]
  (if-not (connected?)
    (do
      (println "establishing mongo db connection.....")
      (reset! mongodb (.getDB (Mongo. host port) db))
      )
    )
  )

(defn- with-connection [f]
  (let [_ (connect "localhost" 27017 "tikvah")]
    (f)
    )
  )

(defn entitytypes []
  (with-connection
    (fn []
      (.getCollectionNames @mongodb)
      )
    )
  )


(defrecord MongoInfoStore [entities conditions]
  InformationStore
  (search [self] :search-not-implemented ))

(defn mongo-store [entity-type conditions]
  (MongoInfoStore. entity-type conditions)
  )


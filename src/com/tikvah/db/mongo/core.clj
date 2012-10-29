(ns com.tikvah.db.mongo.core
  (:use com.tikvah.db.store)
  (:use com.tikvah.commons.sugar)
  (:import [com.mongodb DB DBCollection BasicDBObject DBObject DBCursor Mongo]))

;;predicates

(defn $eq [k v]
  (fn [query] (.put query (name k) v))
  )

(defn $gt [k v]
  (fn [query] (.put query (name k) (BasicDBObject. "$gt" v)))
  )

(defn $ne [k v]
  (fn [query] (.put query (name k) (BasicDBObject. "$ne" v)))
  )
;;end of predicates


(def ^{:private true} mongodb (atom nil))

(defn- connected? []
  (not (nil? @mongodb))
  )

(defn- cursor [collection predicate]
  (if (nil? predicate)
    (.find collection)
    (.find collection (doto (BasicDBObject.) (predicate))))
    )

(defn convert [dbobject]
  (.get dbobject "name")
  )

(defn mongo-collection [cursor]
  (lazy-seq
    (if (.hasNext cursor)
      (cons (convert (.next cursor)) (mongo-collection cursor))
      nil
      )
    )
   )

(deftype MongoCollection [collection-name store]
  Collection
  (scan [this predicate]
    (let [connection (connect! store)
          collection (.getCollection @connection (name collection-name))
          cursor (cursor collection predicate)]
      (mongo-collection cursor)
      )
    )
  )

(deftype MongoStore [name host port] Store
  (collection [this collection-name]
    (MongoCollection. collection-name this)
    )

  (connect! [this]
    (if-not (connected?)
      (do
        (println "establishing mongo db connection.....")
        (reset! mongodb (.getDB (Mongo. host port) name))
        mongodb
        )
      mongodb
      )
    )
  )


(defn mongo-store [name {:keys [host port]}]
  (MongoStore. name host port)
  )


(defn test-coll []
   ;(-> (mongo-store "tikvah" {:host "localhost" :port 27017}) (collection :products ) (scan ($gt :id "1")))
  )


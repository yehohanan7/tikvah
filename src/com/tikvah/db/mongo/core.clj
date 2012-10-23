(ns com.tikvah.db.mongo.core
  (:use com.tikvah.db.store)
  (:use com.tikvah.commons.sugar)
  (:import [com.mongodb DB DBCollection BasicDBObject DBObject DBCursor Mongo]))


(def ^{:private true} mongodb (atom nil))

(defn- connected? []
  (not (nil? @mongodb))
  )

(defn- update-query! [query condition]
  (let [[k _ v] condition]
    (.put query (name k) v)
    )
  )

(defn- apply-all [query conditions]
  (doseq [condition conditions] (update-query! query condition))
  )

(defn with-query [conditions]
  (doto (BasicDBObject.) (apply-all conditions))
  )

(defn- cursor [collection conditions]
  (if (nil? conditions)
    (.find collection)
    (.find collection (with-query conditions))
    )
  )

(defn convert [dbobject]
  (.get dbobject "name")
  )

(defn map-cursor
  ([cursor] (map-cursor cursor []))
  ([cursor result]
    (if (.hasNext cursor)
      (recur cursor (conj result (convert (.next cursor))))
      result
      )
    )
  )

(defn query "queries the collection for specific conditions" [collection conditions]
  (let [cursor (cursor collection conditions)]
    (map-cursor cursor)
    )
  )

(deftype MongoCollection [collection-name store]
  Collection
  (scan [this _ conditions]
    (let [connection (connect! store)
          collection (.getCollection @connection (name collection-name))]
      (query collection conditions)
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

;;(-> (store "tikvah") (collection :products ) (scan :having [:id :eq 12345]))
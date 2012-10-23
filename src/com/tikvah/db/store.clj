(ns com.tikvah.db.store)


(defprotocol Store
  (collection [this name] "queries the entity store for all entities that satisfy the conditions")
  (connect! [] "connects the store and keep it ready for scanning")
  )

(defprotocol Collection
  (scan [this _ conditions] "queries the collection based on the conditions")
  )


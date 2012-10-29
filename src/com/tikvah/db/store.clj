(ns com.tikvah.db.store)


(defprotocol Store
  (collection [this name] )
  (connect! [this])
  )

(defprotocol Collection
  (scan [this predicate])
  )


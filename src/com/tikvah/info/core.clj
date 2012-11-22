(ns com.tikvah.info.core
  (:use [com.tikvah.db.store])
  (:use [com.tikvah.db.core])
  )

(def ^{:private true} info-db "tikvah")

(defn information-of [entity-type predicate]
  (-> (store info-db) (collection entity-type) (scan predicate))
  )




 
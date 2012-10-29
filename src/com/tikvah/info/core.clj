(ns com.tikvah.info.core
  (:use [com.tikvah.db.store])
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.db.mongo.core])
  )

(def ^{:private true} info-db "tikvah")

(defn information-of [entity-type predicate]
  (-> (store info-db) (collection entity-type) (scan predicate))
  )

;(info-of :products :having [:id :eq "prod123"])
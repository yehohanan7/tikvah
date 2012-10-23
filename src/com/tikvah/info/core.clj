(ns com.tikvah.info.core
  (:use [com.tikvah.info.store])
  (:use [com.tikvah.info.mongo.core]))

(def ^{:private true :doc "type of information store"} store-type :mongo )

(defmulti store :store-type )

(defmethod store :mongo [{:keys [entity-type conditions]}]
  (mongo-store entity-type conditions))


(defn information-of [entity-type & conditions]
  (let [storespec {:store-type store-type
                   :entity-type entity-type
                   :conditions (if-not (nil? conditions) (rest conditions) conditions)}]
    (search (store storespec))
    )
  )

;;(information-of :products :having [:id :eq "prod123"])
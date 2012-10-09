(ns com.tikvah.entities.repository
  (:use [monger.core :only [connect! connect set-db! get-db]]
        [monger.collection :only [insert insert-batch]])
  (:require [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(connect!)
(set-db! (monger.core/get-db "tikvah"))

(defn get [id kind]
  (if-let [prod (first (mc/find-maps kind {:id id}))]
    (dissoc prod :_id )
    )
  )

(defn create [data kind]
  (if (not (get (:id data) kind))
    (insert kind (assoc data :_id (:id data)))
    )
  )

(defn all [kind]
  (mc/find-maps kind)
  )


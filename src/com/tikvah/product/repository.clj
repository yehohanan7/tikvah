(ns com.tikvah.product.repository
 (:use [monger.core :only [connect! connect set-db! get-db]]
       [monger.collection :only [insert insert-batch]])
 (:require [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(defn- connect-db []
  (connect!)
  (set-db! (monger.core/get-db "tikvah"))
  )
  
(defn create-product [product]
  (connect-db)
  (insert "products" product)
  true
  )

(defn get-product [id]
  (connect-db)
  (if-let [prod (first (mc/find-maps "products" {:id id}))]
    (dissoc prod :_id)
    )
  )
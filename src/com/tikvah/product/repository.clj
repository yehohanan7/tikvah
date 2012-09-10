(ns com.tikvah.product.repository
 (:use [monger.core :only [connect! connect set-db! get-db]]
       [monger.collection :only [insert insert-batch]])
 (:require [monger.collection :as mc])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(connect!)
(set-db! (monger.core/get-db "tikvah"))

(defn get-product [id]
  (println "repo: " (mc/find-maps "products" {:id id}))
  (if-let [prod (first (mc/find-maps "products" {:id id}))]
    (dissoc prod :_id)
    )
  )

(defn create-product [product]
  (println "repo::::" product)
  (if (not (get-product (:id product)))
    (insert "products" (assoc product :_id (:id product)))
    )
  )


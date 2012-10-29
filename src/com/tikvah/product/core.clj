(ns com.tikvah.product.core
  (:use [com.tikvah.info.core])
  (:use [com.tikvah.db.mongo.core])
  (:require [com.tikvah.http.json :as json]))


(defn as-json [x]
  (json/json-response x)
  )

(defn find [id]
  (as-json (information-of :products ($eq :id id)))
  )

(defn create [product]
  (println "should be implemented as a fact")
  )

(defn all []
  (as-json (information-of :products ($gt :id "1"))) ;; should correct this
  )

(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (println "should be implemented as a fact")
  )



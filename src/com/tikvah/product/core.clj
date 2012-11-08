(ns com.tikvah.product.core
  (:use [com.tikvah.info.core])
  (:use [com.tikvah.db.mongo.core])
  (:use [com.tikvah.facts.core])
  (:require [com.tikvah.http.json :as json])
  (:import [java.util Date])
  (:require [clj-time.core :as dt]))



(defn find [id]
  (information-of :products ($eq :id id))
  )

(defn create [product]
    (and (new-fact (:id product) :created-on (dt/now))
       (new-fact (:id product) :name-is (:name product)))
  )

(defn all []
  (information-of :products ($gt :id "1")) ;; should correct this
  )  



(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (println "should be implemented as a fact")
  )



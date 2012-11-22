(ns com.tikvah.product.core
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.info.core])
  (:use [com.tikvah.facts.core])
  (:import [java.util Date])
  (:require [clj-time.core :as dt]))



(defn find [id]
  (information-of :products ($eq :id id))
  )


(defn create [product]
  (and (new-fact :productfacts (:id product) :created-on (dt/now))
    (new-fact :productfacts (:id product) :name-is (:name product)))
  )

(defn all []
  (information-of :products ($gt :id "1")) ;; should correct this
  )



(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (println "should be implemented as a fact")
  )

(defn add-to-category [category product]
  (new-fact :productfacts (:id product) :added-to-category (:id category))
  )





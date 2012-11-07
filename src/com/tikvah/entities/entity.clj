(ns ^{:doc "Provides CRUD operations for a generic entity"
      :author "John"} com.tikvah.entities.entity
      (:use [com.tikvah.info.core])
      (:use [com.tikvah.db.mongo.core])
      (:use [com.tikvah.facts.core])
      (:require [clj-time.core :as dt])
      (:import [java.util Date]))

(defn find [id kind]
  (information-of kind ($eq :id id))
  )

(defn create [data kind]
  (and (new-fact (:id data) :created-on (from-long (.time (Date.))))
       (new-fact (:id data) :name-is (:name data)))
  )

(defn all [kind]
  (information-of kind ($gt :id "1"))
  )



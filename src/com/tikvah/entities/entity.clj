(ns ^{:doc "Provides CRUD operations for a generic entity"
      :author "John"} com.tikvah.entities.entity
  (:use [com.tikvah.info.core])
  (:require [com.tikvah.http.json :as json])
  )

(defn find [id kind]
  (as-json (information-of kind ($eq :id id)))
  )

(defn create [data kind]
  (if (repo/create data kind)
    "success"
    "error")
  )

(defn all [kind]
  (as-json (information-of kind ($gt :id "1")))
  )



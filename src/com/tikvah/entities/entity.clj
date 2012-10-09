(ns ^{:doc "Provides CRUD operations for a generic entity"
      :author "John"} com.tikvah.entities.entity
  (:require [com.tikvah.http.json :as json]
            [com.tikvah.entities.repository :as repo])
  )

(defn find [id kind]
  (as-json (repo/get id kind))
  )

(defn create [data kind]
  (if (repo/create data kind)
    "success"
    "error")
  )

(defn all [kind]
  (as-json (repo/all kind))
  )



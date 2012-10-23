(ns com.tikvah.product.core
  (:use [com.tikvah.info.core])
  (:require [com.tikvah.http.json :as json]
            [com.tikvah.info.core :as info]))


(defn as-json [x]
  (json/json-response x)
  )

(defn find [id]
  (as-json (information-of :products :having [:id :eq id]))
  )

(defn create [product]
  (println "should be implemented as a fact")
  )

(defn all []
  ;;(as-json (repo/all))
  )

(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (println "should be implemented as a fact")
  )



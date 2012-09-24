(ns com.tikvah.product.products
  (:require [com.tikvah.product.repository :as repo]
            [com.tikvah.http.json :as json]))


(defn as-json [x]
  (json/json-response x)
  )

(defn find [id]
  (as-json (repo/get-product id))
  )

(defn create [product]
  (if (repo/create-product product)
    "success"
    "error")
  )

(defn all []
  (as-json (repo/all))
  )

(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (str "product with id " id "is updated with name " name "and price " price)
  )

(defn find-products [& ids]
  (map #(hash-map "id" % "name" "test product" "price" "$25") ids)
  )


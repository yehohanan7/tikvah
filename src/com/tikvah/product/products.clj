(ns com.tikvah.product.products
  (:use com.tikvah.http.json))



(defn find-product [id]
   {"id" id "name" "test product" "price" "$25"}
  )

(defn create-product [{:keys [id name price]}]
  (str "product inserted into the DB")
  )

(defn update-product [{:keys [id name price] :or {name "" price 0}}]
  (str "product with id " id "is updated with name " name "and price " price)
  )

(defn find-products [& ids]
  (map #(hash-map "id" % "name" "test product" "price" "$25") ids)
  )


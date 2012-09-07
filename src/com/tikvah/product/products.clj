(ns com.tikvah.product.products
  (:use com.tikvah.http.json))


(defn find [id]
  (json-response {"id" "12345" "name" "test product" "price" "$25"})
  )

(defn create [{:keys [id name price]}]
  (str "product inserted into the DB")
  )

(defn update [{:keys [id name price] :or {name "" price 0}}]
  (str "product with id " id "is updated with name " name "and price " price)
  )

(defn find [& ids]
  (json-response (map #(hash-map "id" % "name" "test product" "price" "$25") ids))
  )


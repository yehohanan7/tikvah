(ns com.tikvah.product.productstest
  (:use [com.tikvah.product.products])
  (:use [clojure.test])
  (:use [midje.sweet]))


(fact "should find a product by product id"
  ((find-product "1234") "id") => "1234")

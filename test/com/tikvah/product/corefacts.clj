(ns com.tikvah.product.corefacts
  (:use [clojure.test])
  (:use [midje.sweet])
  (:require [com.tikvah.product.core :as products])
  (:require [clj-time.core :as dt]))


(fact (products/create {:id "testprod" :name "test product name" :price "255"}) => true
  (provided (new-fact "testprod" :created-on anything) => true)
  (provided (new-fact "testprod" :name-is "test product name") => true))




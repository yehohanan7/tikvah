(ns com.tikvah.product.corefacts
  (:use [clojure.test])
  (:use [midje.sweet])
  (:use [com.tikvah.facts.core])
  (:require [com.tikvah.product.core :as products])
  (:require [clj-time.core :as dt]))


(fact (products/create {:id "testprod" :name "test product name" :price "255"}) => true
  (provided (new-fact :productfacts "testprod" :created-on anything) => true)p
  (provided (new-fact :productfacts "testprod" :name-is "test product name") => true))


(fact (products/add-to-category {:id "electronics"} {:id "1"}) => true
      (provided (new-fact :productfacts "1" :added-to-category "electronics") => true)
      )




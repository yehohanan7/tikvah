(ns com.tikvah.category.categoryfacts
  (:use [clojure.test])
  (:use [midje.sweet])
  (:use [com.tikvah.facts.core])
  (:require [com.tikvah.category.core :as categories])
  (:require [clj-time.core :as dt]))


(fact (categories/create {:id "electronics" :name "electronic products"}) => true
      (provided (new-fact :categoryfacts "electronics" :created-on anything) => true))







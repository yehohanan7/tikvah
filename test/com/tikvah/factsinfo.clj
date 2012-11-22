(ns com.tikvah.factsinfo
  (:use [clojure.test])
  (:use [midje.sweet])
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.db.store])
  (:use [com.tikvah.info.core])
  (:require [com.tikvah.facts.core :as factdb])
  (:require [clj-time.core :as dt]))

(let [_ (factdb/new-fact :productfacts "testProduct1" :added-on (dt/date-time 2012 10 1))
      _ (factdb/new-fact :productfacts "testProduct1" :name-is "test product 1")
      _ (factdb/new-fact :productfacts "testproduct1" :price-is "255")]
  (fact (information-of :products ($eq :id "testProduct1")) => {:id "testProduct1" :name "test product 1" :price "255"})
  )

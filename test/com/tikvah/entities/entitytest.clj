(ns com.tikvah.entities.entitytest
  (:use [clojure.test])
  (:use [midje.sweet])
  (:require [com.tikvah.entities.entity :as entity])
  (:use [com.tikvah.facts.core]))



;.;. One of the symptoms of an approaching nervous breakdown is the belief
;.;. that one's work is terribly important. -- Russell
(fact (entity/create {:id "testprod" :name "test product name"} :products) => true
  (provided (new-fact "testprod" :created-on anything) => true)
  (provided (new-fact "testprod" :name-is "test product name") => true))



(ns com.tikvah.entities.entitytest
  (:use [clojure.test])
  (:use [midje.sweet])
  (:require [com.tikvah.entities.entity :as entity])
  (:use [com.tikvah.facts.core]))



;.;. [31mFAIL[0m at (NO_SOURCE_FILE:1)
;.;. You never said new-fact would be needed with these arguments:
;.;.     ("testprod" :name-is "test product name")
;.;. 
;.;. [31mFAIL[0m at (NO_SOURCE_FILE:1)
;.;.     Expected: :success
;.;.       Actual: (nil nil nil)
(fact (entity/create {:id "testprod" :name "test product name"} :products) => true
  (provided (new-fact "testprod" :created-on anything) => true)
  (provided (new-fact "testprod" :name-is "test product name") => true))



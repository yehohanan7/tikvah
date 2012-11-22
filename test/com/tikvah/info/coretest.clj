(ns com.tikvah.info.coretest
  (:use [com.tikvah.info.core])
  (:use [com.tikvah.db.core])
  (:use [clojure.test])
  (:use [midje.sweet]))


(fact (information-of :products ($gt :id "1")) => #(not (nil? %)))







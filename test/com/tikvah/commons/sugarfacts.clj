(ns com.tikvah.commons.sugarfacts
  (:use [com.tikvah.commons.sugar])
  (:use [midje.sweet]))


(fact (not-nil? "xyz") => true)

(fact (not-nil? nil) => false)

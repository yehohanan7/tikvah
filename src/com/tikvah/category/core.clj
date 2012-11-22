(ns com.tikvah.category.core
  (:use [com.tikvah.info.core])
  (:use [com.tikvah.facts.core])
  (:require [clj-time.core :as dt]))


(defn create [category]
  (new-fact :categoryfacts (:id category) :created-on (dt/now))
  )




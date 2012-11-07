(ns com.tikvah.facts.coretest
  (:use [clojure.test])
  (:use [midje.sweet])
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.db.store])
  (:require [com.tikvah.facts.core :as factdb])
  (:require [clj-time.core :as dt]))

(deftype MockCollection [collection-name store] Collection
  (add [this data] true)
  )

(deftype MockStore [name] Store
  (collection [this collection-name] (MockCollection. collection-name this))
  )

(def mockedstore (MockStore. "dummy"))


(fact (factdb/new-fact "prod1" :added-on (dt/date-time 2012 10 1)) => true
  (provided (store "tikvah") => mockedstore))

(fact (factdb/new-fact "prod1" :name-is "Bose speakers") => true
  (provided (store "tikvah") => mockedstore))

;.;. Without work, all life goes rotten. -- Camus
(fact (factdb/new-fact "prod1" :price-is "25 GBP") => true
  (provided (store "tikvah") => mockedstore))


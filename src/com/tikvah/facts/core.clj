(ns com.tikvah.facts.core
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.db.store]))


(defn new-fact [type subject verb object]
  (-> (store "tikvah") (collection type) (add {:id subject :type (name verb) :value object}))
  )
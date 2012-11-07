(ns com.tikvah.facts.core
  (:use [com.tikvah.db.core])
  (:use [com.tikvah.db.store]))

(defn new-fact [subject verb object]
  (-> (store "tikvah") (collection :productfacts) (add {:id subject :type verb :value object}))
  )








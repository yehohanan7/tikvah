(ns com.tikvah.db.corefacts
  (:use [com.tikvah.db.core])
  (:use [midje.sweet]))


(fact (str (class (store "tikvah"))) => "class com.tikvah.db.mongo.core.MongoStore")

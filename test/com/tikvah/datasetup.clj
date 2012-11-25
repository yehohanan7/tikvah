(ns com.tikvah.datasetup
  (:use [com.tikvah.facts.core])
  (:require [com.tikvah.product.core :as products])
  (:require [clj-time.core :as dt]))


(def productfacts {:type :productfacts :facts [
                      ["1" :created-on (dt/now)]
                      ["1" :name-is "Mac Book pro"]
                      ["1" :price "2115"]

                      ["2" :created-on (dt/now)]
                      ["2" :name-is "XBOX 360"]
                      ["2" :price "1115"]

                      ["3" :created-on (dt/now)]
                      ["3" :name-is "Programming clojure"]
                      ["3" :price "215"]

                      ["4" :created-on (dt/now)]
                      ["4" :name-is "Joy of clojure"]
                      ["4" :price "311"]

                      ["1" :category-is "electronics"]
                      ["2" :category-is "electronics"]
                      ["2" :category-is "games"]
                      ["3" :category-is "books"]
                      ["4" :category-is "books"]
                      
                      ]} )

(def categoryfacts {:type :categoryfacts :facts [
                                                  ["electronics" :created-on (dt/now)]
                                                  ["books" :created-on (dt/now)]
                                                  ["games" :created-on (dt/now)]
                                                  ]
                    }
  )


(defn fire-facts [data]
  (for [[subject verb object] (:facts data)]
    (new-fact (:type data) subject verb object)
    )
  )

(defn setup-products []
  (fire-facts productfacts)
  )

(defn setup-categories []
  (fire-facts categoryfacts)
  )
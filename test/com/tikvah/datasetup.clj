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
                      ]} )

(def categoryfacts {:type :categoryfacts :facts [
                                                  ["electronics" :created-on (dt/now)]
                                                  ["electronics" :has-product "1"]
                                                  ["electronics" :has-product "2"]

                                                  ["books" :created-on (dt/now)]
                                                  ["books" :has-product "3"]
                                                  ["books" :has-product "4"]
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
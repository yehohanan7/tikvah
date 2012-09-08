(ns com.tikvah.product.repositorytest
  (:use [com.tikvah.product.repository])
  (:use [clojure.test])
  (:use [midje.sweet]))

(deftest should-insert-produc-into-DB
  (if-let [_ (create-product {:id "prod1234" :name "Bose Quite Comfort 15"})]
    
    (is (= (get-product "prod1234") {:id  "prod1234" :name  "Bose Quite Comfort 15"}))
    
    (is false)
    )
  )
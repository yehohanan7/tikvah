(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        com.tikvah.product.products
        com.tikvah.http.json
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (str "welcome to tikvah"))

  (GET "/products/:id" [id]  (json-response (find-product id)))
  

  (GET "/products" []  (json-response (find-products "123" "234" "555")))

  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
    (wrap-base-url)))

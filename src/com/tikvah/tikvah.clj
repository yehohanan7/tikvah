(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        com.tikvah.product.products
        com.tikvah.http.json
        [hiccup.middleware :only (wrap-base-url)])
  (:use ring.middleware.json-params)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (str "welcome to tikvah"))

  (GET "/products/:id" [id] (json-response (find-product id)))

  (POST "/products" request (create-product (parse-string
                                              (slurp (:body request)))))


  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
    wrap-json-params
    wrap-base-url))

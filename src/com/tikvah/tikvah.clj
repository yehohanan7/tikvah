(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        com.tikvah.product.products
        com.tikvah.http.json
        [hiccup.middleware :only (wrap-base-url)])
  (:use ring.middleware.json-params)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.util.response :as response]))

(defroutes main-routes
  (GET "/" [] (response/redirect "/html/home.html"))

  (GET "/products/:id" [id] (json-response (find-product id)))

  (PUT "/products" [data] (create-product  data))


  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
    wrap-json-params
    wrap-base-url))



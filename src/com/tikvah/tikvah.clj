(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        com.tikvah.http.json
        [hiccup.middleware :only (wrap-base-url)])
  (:require [com.tikvah.product.products :as products])
  (:use ring.middleware.json-params)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.util.response :as response]))

(defroutes main-routes

  (GET "/" [] (response/redirect "/html/home.html"))

  (GET "/products/" [] (products/all))

  (GET "/products/:id" [id] (products/find id))


  (PUT "/products" [data] (products/create data))

  ;;(GET "/entities/:kind/:id" [kind id] ())

  (route/resources "/")
  (route/not-found "Page not found"))


(def app
  (-> (handler/site main-routes)
    wrap-json-params
    wrap-base-url))



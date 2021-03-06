(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        [hiccup.middleware :only (wrap-base-url)])
  (:require [com.tikvah.product.core :as products])
  (:use ring.middleware.json-params) 
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.util.response :as response]
            [com.tikvah.http.json :as json]))

(defn as-json [x]
  (json/json-response x)
  )



(defroutes main-routes

  (GET "/" [] (response/redirect "/html/home.html"))

  (GET "/products/" [] (as-json (products/all)))

  (GET "/products/:id" [id] (as-json (products/find id)))

  (PUT "/products" [data] (products/create data))

  (route/resources "/")
  (route/not-found "Page not found"))


(def app
  (-> (handler/site main-routes)
    wrap-json-params
    wrap-base-url))



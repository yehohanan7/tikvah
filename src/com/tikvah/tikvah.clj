(ns com.tikvah.tikvah
  (:use compojure.core
        com.tikvah.index
        com.tikvah.http.json
        [hiccup.middleware :only (wrap-base-url)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [com.tikvah.product.products :as products]))

(defroutes main-routes
  (GET "/" [] (str "welcome to tikvah"))

  (GET "/products/:id" [id] (products/find id))
  (PUT)

  (GET "/products" [] (products/find "123" "234" "555"))

  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
    (wrap-base-url)))

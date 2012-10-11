(ns com.tikvah.sandbox.ringer
  (:use [ring.adapter.jetty :only [run-jetty]]))

(defn app [{:keys [uri]}]
  {:body (format "you reqested %s" uri)}
  )

(def server (run-jetty app {:port 8080 :join? false}))



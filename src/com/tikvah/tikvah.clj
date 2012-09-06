(ns com.tikvah.tikvah
  (:use [ring.adapter.jetty :only [run-jetty]]))


(defn- app [{:keys [uri]}]
  "Default handler"
  {:body (format "you reqested %s" uri)}
  )

(def ^{:private true, :doc "server"} server (atom {}))

(defn start "Starts the server on port 8080" []
  (swap! server (fn [_] (run-jetty app {:port 8080 :join? false})))
  )

(defn stop "Stops the currently running server" []
  (.stop @server)
  )

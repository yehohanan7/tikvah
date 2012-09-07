(defproject tikvah "1.0.0-SNAPSHOT"
  :description "Ecommerce platform"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring-server "0.2.5"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.1"]
                 [clj-json "0.3.2"]
                 [ring/ring-jetty-adapter "0.3.8"]]

  :dev-dependencies [[lein-ring "0.6.7"]]
  :ring {:handler com.tikvah.tikvah/app})



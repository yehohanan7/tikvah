(defproject tikvah "1.0.0-SNAPSHOT"
  :description "Ecommerce platform"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/tools.logging "0.2.3"]
                 [ring-server "0.2.5"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.1"]
                 [clj-json "0.3.2"]
                 [ring/ring-jetty-adapter "0.3.8"]
                 [com.novemberain/monger "1.1.2"]
                 [ring-json-params "0.1.0"]
                 [org.apache.hbase/hbase "0.94.1"]
                 [org.apache.hadoop/hadoop-core "0.20.2"]
                 [org.codehaus.jackson/jackson-mapper-asl "1.5.0"]]

  :dev-dependencies [[lein-ring "0.6.7"]
                     [midje "1.4.0"]]

  :ring {:handler com.tikvah.tikvah/app})


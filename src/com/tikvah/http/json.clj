(ns com.tikvah.http.json
  (:require [clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defn parse-string [data]
  (let [x (json/parse-string data)]
    x
    )
  )

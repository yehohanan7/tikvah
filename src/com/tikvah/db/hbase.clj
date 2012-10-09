(ns com.tikvah.db.hbase)

(import '(org.apache.hadoop.hbase.client HTable Result ResultScanner Scan Put))
(import '(org.apache.hadoop.hbase.util Bytes))
(import '(org.apache.hadoop.hbase HBaseConfiguration))


(defmacro row [name & columns]
  `(do
     (println "row : " ~name)
     (map (fn [x#] (println "col: " x#)) (vector ~@columns))
    )
  )

(defmacro table [name & rows]
  `(do
     (println "table name: " ~name)
     ~@rows
     )
  )

(defn test-table []
  (let [config (HBaseConfiguration/create) productevents (HTable. config "test")]
    (let [prod1 (Put. (Bytes/toBytes "prod123"))]
      (.add prod1 (Bytes/toBytes "cf") (Bytes/toBytes "name") (Bytes/toBytes "clojure t-shirt"))
      (.put productevents prod1)
      (println "put complete")
    )
  )
)
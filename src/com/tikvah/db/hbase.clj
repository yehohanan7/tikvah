(ns com.tikvah.db.hbase
  (:use [com.tikvah.commons.sugar]))

(import '(org.apache.hadoop.hbase.client HTable Result ResultScanner Scan Put))
(import '(org.apache.hadoop.hbase.util Bytes))
(import '(org.apache.hadoop.hbase HBaseConfiguration))


(defn- hbytes [& xs]
  (vec (map #(hbyte %) xs))
  )

(defn- hbyte [x]
  (Bytes/toBytes x)
  )

(defn- addcolumn [^Put row cf label value]
  (.add row (hbyte cf) (hbyte label) (hbyte value))
   row
  )

(defn- insert-to [^Put row ^HTable table]
  (.put table row)
  )


(defn htable [tablename operation & rows]
  (let [config (HBaseConfiguration/create) table (HTable. config tablename)]
    (for [r rows :let [id (fkey r) [cf label value] (fvalue r) row (Put. (hbyte id))]]
        (-> row (addcolumn cf label value) (insert-to table)) 
      )
   )
 )



(defn test-me []
  (htable "test" :put {"rr" ["cf" "name" "value"]})
  )


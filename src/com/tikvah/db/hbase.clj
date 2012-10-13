(ns com.tikvah.db.hbase
  (:use [com.tikvah.commons.sugar]))


(import '(org.apache.hadoop.hbase.client HTable Result ResultScanner Scan Put))
(import '(org.apache.hadoop.hbase.util Bytes))
(import '(org.apache.hadoop.hbase HBaseConfiguration))


(def ^:dynamic *autoflush* true)

(defn- tobyte [x]
  (Bytes/toBytes x)
  )


(defn- tobytes [& xs]
  (vec (map #(tobyte %) xs))
  )

(defn- rowid [x]
  (fkey x)
  )

(defn- columndata [x]
  (fvalue x)
  )

(defn- addcolumn [^Put row cf label value]
  (.add row (tobyte cf) (tobyte label) (tobyte value))
   row
  )

(defn- insert-to [^Put row ^HTable table]
  (.put table row)
  )

(defn- findtable [config tablename]
  (let [table (HTable. config tablename)]
    (.setAutoFlush table *autoflush*)
    table
    )
  )


(defn- toput [row]
  (let [id (rowid row) [cf label value] (columndata row) put (Put. (tobyte id))]
     (addcolumn put cf label value)
    )
  )

(defn operation? [tablename operation &rows]
  operation
  )

(defmulti table operation?)

(defmethod table :put [tablename operation &rows]
  (try
    (let [config (HBaseConfiguration/create) table (findtable config tablename) puts (map #(toput %) rows) ]
      (.put table puts)
      )
    (catch Exception e (println e (str tablename operation rows))))
  )


(defmethod table :atomic [tablename oeration &rows]
  )

(defn table
  "updates the hbase table with all the rows, prefer to use batch update if you want to do multuple updates"
  [tablename operation & rows]
  (try
    (let [config (HBaseConfiguration/create) table (findtable config tablename) puts (map #(toput %) rows) ]
      (.put table puts)
      )
    (catch Exception e (println e (str tablename operation rows))))
 )


(defn batch
  "does a batch update to hbase"
  [& xs]
  (binding [*autoflush* false]
    (map #(apply table %) xs)
    )
  )



(defn test-me []
  ;;(htable "test" :put {"rr" ["cf" "name" "value"]})
  )




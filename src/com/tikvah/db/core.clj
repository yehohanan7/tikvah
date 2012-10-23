(ns com.tikvah.db.core)


(defn store
  ([name] (store name :host "localhost" :port 21027))
  ([name & options] (mongo-store name options))
  )





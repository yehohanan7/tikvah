(ns com.tikvah.commons.sugar)

(defmacro ? "macro to simplify if/else block"
  [predicate x y]
  `(if ~predicate ~x ~y)
  )


(defn mapreduce
  ([mapper reducer data] (reduce reducer (map mapper data)))
  ([mapper reducer initial data] (reduce reducer initial (map mapper data)))
  )

(defmacro -- [x]
  (dec x)
  )

(defmacro ++ [x]
  (inc x)
  )

(defn fkey "gets the first key in the map" [map]
  (first (keys map))
  )

(defn fvalue "gets the first value in the map" [map]
  (first (vals map))
  )

(def car first)

(def cdr rest)



;;(defmacro *times [n f input]
;; `(((apply comp (take ~n (repeat ~f)))) ~input)
;;  )

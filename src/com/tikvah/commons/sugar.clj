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


;;(defmacro *times [n f input]
;; `(((apply comp (take ~n (repeat ~f)))) ~input)
;;  )

(ns com.tikvah.commons.sugar)

(defmacro ? "macro to simplify if/else block"
  [predicate x y]
  `(if ~predicate ~x ~y)
  )



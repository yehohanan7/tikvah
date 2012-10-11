(ns com.tikvah.commons.log
  (:use [clojure.tools.logging :as logger]))


(defn error [e message]
  (logger/error message)
  )
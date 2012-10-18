(ns com.tikvah.facts.core
  (:use com.tikvah.facts.logstore))


(defn- string-format [& xs]
  (apply str (interpose " " (map #(if (keyword? %) (name %) %) xs)))
  )

(defn fact-store [fact-type]
  log-store
  )

;;(defn fact [fact-type fact-identity [subject verb object]]
;;  (string-format fact-identity "'s " subject verb object)
;;  )









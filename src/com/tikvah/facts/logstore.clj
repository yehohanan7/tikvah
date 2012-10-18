(ns com.tikvah.facts.logstore
  "logs the facts to the standard output"
  (:use com.tikvah.facts.store))

(deftype LogStore [fact-type fact-identity]
  FactStore
  (fact [subject verb object]
    (string-format fact-identity "'s " subject verb object)
    )
  )


(defn log-store [fact-type fact-identity]
  (LogStore. fact-type fact-identity)
  )


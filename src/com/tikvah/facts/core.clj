(ns com.tikvah.facts.core)


(defn- string-format [& xs]
  (apply str (interpose " " (map #(if (keyword? %) (name %) %) xs)))
  )

(defn fact [fact-type fact-identity [subject verb object]]
  (string-format fact-identity "'s " subject verb object)
  )









(ns com.tikvah.facts.core)

(defn fact [fact-type fact-identity [subject verb object]]
  (apply str (interpose " " ["recording fact.." fact-identity "'s " subject verb object]))
  )









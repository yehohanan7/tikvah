(ns com.tikvah.facts.store
  "Centeral store to persist facts.")

(defprotocol FactStore
  (fact [subject verb object]
    "captures the fact into the fact store."
    )
  )

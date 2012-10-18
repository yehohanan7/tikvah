(ns com.tikvah.facts.entityfact
  :require [com.tikvah.facts.listener :as listener])


(defn newentity [id attributes]
  (listener/listen id :new attributes)
  )

(defn updated [id attributes]
  (listener/listen id :updated attributes)
  )


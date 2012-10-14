(ns com.tikvah.fact.entityfact
  :require [com.tikvah.fact.listener :as listener])



(defn newentity [id attributes]
  (listener/listen id :new attributes)
  )

(defn updated [id attributes]
  (listener/listen id :updated attributes)
  )


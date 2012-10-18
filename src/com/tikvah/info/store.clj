(ns com.tikvah.info.store)

(defprotocol InformationStore
  (search [self] "queries the entity store for all entities that satisfy the conditions")
  )

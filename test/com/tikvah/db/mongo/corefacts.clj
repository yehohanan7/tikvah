(ns com.tikvah.db.mongo.corefacts
  (:use [com.tikvah.db.mongo.core])
  (:use [com.tikvah.db.store])
  (:use [midje.sweet])
  (:use [com.tikvah.commons.sugar]))

;.;. establishing mongo db connection.....
;.;. 
;.;. [31mFAIL[0m at (NO_SOURCE_FILE:1)
;.;. These calls were not made the right number of times:
;.;.     (connect!) [expected at least once, actually never called]
(let [store (mongo-store "tikvah" {:host "localhost" :port 1111})]
  (fact (collection store :products) => #(not-nil? %)
    (provided (connect! store) => (atom {})))
  )


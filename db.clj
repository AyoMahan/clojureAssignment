(ns db)

(defn add [x y]
  (+ x y))

;;(def custDB (db/loadData "cust.txt"))
(defn read []
  (def string1 (slurp "cust.txt"))
  (println string1))

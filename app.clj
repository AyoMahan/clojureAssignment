(ns app
  (:require [db]))

(println (db/add 2 3)
);; (db/test)
(defn add [x y]
  (+ x y))
(db/read)
(apply + 1 [1 2 3 4])

(defn recursive_print_i
  [n]
  (if (= n 0)
    (do)
    (do (println n) (recur (dec n)))))

;;alt enter to excceute
(defn main_menu []

  (println "*** Sales Menu ***")
  (println "-------------------------------------")
  (println "1. Display Custumer Table")
  (println "2. Display Product Table")
  (println "3. Display Sales Table")
  (println "4. Total Sales for Customer")
  (println "5. Total count for Product")
  (println "6. Exit"))

(main_menu)

(defn can-vote []
  (println "Enter age: ")
  (let [age (read-line);;prompting user input
        new-age (read-string age)]
    (if (< new-age 18)
      (println "Not old enough")
      (println "Yay! You can vote"))))


(can-vote)
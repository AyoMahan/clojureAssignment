(ns app
  (:require [db]))

(println (db/add 2 3));; (db/test)
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
  (println "6. Exit")
  (println "Enter one of the options above: ")
  (let [selection (read-line)
        new-selection (read-string selection)]
    (if (== new-selection 1)
          (println "you have selected 1"))
    (if (== new-selection 2)
      (println "you have selected 2"))
    (if (== new-selection 3)
      (println "you have selected 3"))
    (if (== new-selection 4)
      (println "you have selected 4"))
    (if (== new-selection 5)
      (println "you have selected 5"))
    (if (== new-selection 6)
      (println "you have succesfully exited the program"))
    
    
    )
    )
  
  
  
(main_menu)




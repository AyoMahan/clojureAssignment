(ns app
  (:require [db])
  (:require [menu])
  (:require clojure.string));;to import some useful functions
;;main application to run 


(def customers (db/loadData "cust.txt"));;calling load data function, slurps the files and stores them to vectors wehre they will be mapped
(def products (db/loadData "prod.txt"))
(def sales (db/loadData "sales.txt"))

(loop []
  
  
  (menu/menu);;calls the menu function defined in menu
  (let [select (read-line)]
    (cond
      (= select "1")
      (do
        (println "Customer record:")
        (flush)
        (doseq [customer customers]
          (println (str customer)))
        (recur))

      (= select "2")
      (do
        (println "Product record:")
        (flush)
        (doseq [product products]
          (println (str product)))
        (recur))

      (= select "3")
      (do
        (println "Sales record:")
        (flush)
        (doseq [sale sales]
          (println (str (first sale) ": " (db/customerName customers (second sale)) " :: " (db/item-description products (nth sale 2)) " :: " (nth sale 3))))
        (recur))

      (= select "sales")
      (do
        (println "Sales Table:")
        (flush)
        (doseq [sale sales]
          (println sale))
        (recur))

      (= select "4")
      (do
        (print "Enter customer name: ");;note everything is case sensitive and no error checking is done
        (flush)
        (let [cust-name (clojure.string/join (read-line))]
          (println (str "Total sales for customer " cust-name "= " (db/customerPurchases sales customers products (str cust-name)) "$")))
        (recur))

      (= select "5")
      (do
        (print "Enter product name: ")
        (flush)
        (let [prod-name (read-line)]
          (println (str "\nTotal count for product " prod-name "= " (db/productCount sales products (read-string prod-name)))))
        (recur))

      (= select "6")
      (do
        (println "\nGood bye and thank you for using Mahanaim's sales application")
        (System/exit 0))

      
      :else
      (do
        (println "not a valid selection. Please try again.")
        (recur)))))





(ns db
  (:require clojure.string))

; Loads data from a file into a nested vecotr
(defn loadData [filename]
  (map #(clojure.string/split % #"\|") (clojure.string/split (slurp filename) #"\n")));;reading from file

(defn customerName [customers cust-id]
  (nth (first (filter #(= (first %) cust-id) customers)) 1))
;;assigning name


(defn item-description [products prod-id]
  (nth (first (filter #(= (first %) prod-id) products)) 1));;item name

; Functions after prompting the user for name

(defn customerID_byname [customers cust-name]
  (first (first (filter #(= (nth % 1) (str cust-name)) customers))))
;;requires customer name first

(defn customerPurchasesid [sales products cust-id]
  (let [sales-for-cust (filter #(= (second %) (str cust-id)) sales)]
    (reduce + (map (fn [[_, _, prod-id, count]]
                     (* (Double/parseDouble count) (Double/parseDouble (nth (first (filter #(= (first %) prod-id) products)) 2))))
                   sales-for-cust))))



(defn customerPurchases [sales customers products cust-id]
  (let [cust-id (customerID_byname customers cust-id)]
    (customerPurchasesid sales products cust-id)))

; Functions to calculate sales after inputting name of item

(defn getProductFromName [products prod-name]
  (first (first (filter #(= (nth % 1) (str prod-name)) products))))

(defn productCountid [sales prod-id]
  (let [sales-for-prod (filter #(= (nth % 2) (str prod-id)) sales)]
    (reduce + (map read-string (map (fn [[_, _, _, count]] count) sales-for-prod)))))




(defn productCount [sales products prod-name];;how many products were sold
  (let [prod-id (getProductFromName products prod-name)]
    (productCountid sales prod-id)))
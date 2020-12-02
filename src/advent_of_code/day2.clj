(ns advent-of-code.day2
  (:gen-class))


(def regex #"(?<min>\d+)-(?<max>\d+)\s+(?<letter>\w):\s+(?<password>.*)")
(def input-file-path (str (.getCanonicalPath (clojure.java.io/file ".")) "/resources/day2-input.txt"))


(defn parse-line [line]
  "Parse each line and return a vector containing
  [min max char password] or nil"

  (let [[_ min max letter password]
        (re-matches regex line)]

    (if (and min max letter password)
      [(Integer/parseInt min)
       (Integer/parseInt max)
       (first (char-array letter))
       password])))


(defn is-valid?
  "Predicate. Checks if a given password string
  adheres to the given password policy."

  [line]

  (let [[min max char password :as parsed] (parse-line line)
        lcount (get (frequencies password) char 0)]

    (boolean
     (and
      parsed
      (<= lcount max)
      (>= lcount min)))))


(defn part1 []
   (count
    (filter
     is-valid?
     (line-seq (clojure.java.io/reader input-file-path)))))


(defn is-valid-two?
  [line]
  (let [[x y char password :as parsed] (parse-line line)
        password-arr (char-array password)
        x-exists (= (get password-arr (- x 1)) char)
        y-exists (= (get password-arr (- y 1)) char)]
    (and (or x-exists y-exists)
         (not (and x-exists y-exists)))))


(defn part2 []
  (count
   (filter
    is-valid-two?
    (line-seq (clojure.java.io/reader input-file-path)))))


(defn solution []
  (str "\nDay 2: " (part1) " and " (part2)))

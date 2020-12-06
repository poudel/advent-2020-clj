(ns advent-of-code.day3
  (:gen-class)
  (:use [clojure.string :only [split-lines]]))


(defn read-input [] (split-lines (slurp  "./resources/day3-input.txt")))

(defn traverse-x
  "Traverse on the x axis and return the value of the point.

  Also:
  The pattern of a line repeats itself infinitely towards the x
  axis however the input file only has one instance of the pattern'
  which can be a problem when the position on the x axis reaches a
  number that is higher than the length of the given x axis. The
  modulus operation solves that without having to repeat the
  pattern in memory."

  [line x]

  (if (< x 0)
    nil
    (get line (mod x (count line)))))


(defn is-a-tree?
  "Traverses to the given coordinate and returns 
  whether or not the coordinate is a tree"
  [lines x y]
  (let [line (get lines y)
        point-chr (if (nil? line) nil (traverse-x line x))]
    (= point-chr \#)))


;; not the best out there but... it's honest work
(defn count-trees [[right down]]
  (let [lines (read-input)
        total-lines (count lines)]

    (loop [x 0
           y 0
           treecount 0]

      (if (> y total-lines)
        ;; we've exhausted the tree line; return
        treecount

        ;; traverse and see there's a tree exists
        (let [is-tree (is-a-tree? lines x y)
              treecount (if is-tree (+ 1 treecount) treecount)
              x (+ x right)
              y (+ y down)]

          (recur x y treecount))))))


(defn part1 []
  (count-trees [3 1]))


(defn part2 []
  (let [slopes [[1 1] [3 1] [5 1] [7 1] [1 2]]]
    (reduce * (map count-trees slopes))))


(defn solution []
  (str "\nDay 3: " (part1) " & " (part2)))

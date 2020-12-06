(ns advent-of-code.core
  (:gen-class)
  (:require [advent-of-code.day1 :as day1]
            [advent-of-code.day2 :as day2]
            [advent-of-code.day3 :as day3]))


(defn -main
  "Advent of Code"
  [& args]
  (println
   (day1/solution)
   (day2/solution)
   (day3/solution)))

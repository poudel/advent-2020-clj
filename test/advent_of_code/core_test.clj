(ns advent-of-code.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code.core :refer :all]))


(deftest test-day1-part1
  (testing "Testing day1 part1"
    (is (= (day1-part1) 1016131))))


(deftest test-day1-part2
  (testing "Testing day1 part2"
    (is (= (day1-part2) 276432018))))

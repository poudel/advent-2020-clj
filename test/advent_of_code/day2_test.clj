(ns advent-of-code.day2-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day2 :refer :all]))


(deftest test-parse-line-happypath
  (testing "Testing parse-line happy path"
    (is (= (parse-line "16-18 h: hhhhhhhhhhhhhhhhhh")
           [16 18 \h "hhhhhhhhhhhhhhhhhh"]))))


(deftest test-parse-line-invalid-input
  (testing "When the input doesn't match regex"
    (is (= (parse-line "hawa")
           nil))))


(deftest test-is-valid?
  (testing "Testing is-valid?"
    (is (= (is-valid?  "16-18 h: hhhhhhhhhhhhhhhhhh") true))))


(deftest test-is-valid?-when-invalid
  (testing "Testing is-valid? when invalid"
    (is (= (is-valid? "16xx-18 h: hhhhhhhhhhhhhhhhhh") false))))


(deftest test-part1
  (testing "Part one result should be 465"
    (is (= (part1) 465))))


(deftest test-part2
  (testing "Part two result should be 294"
    (is (= (part2) 294))))

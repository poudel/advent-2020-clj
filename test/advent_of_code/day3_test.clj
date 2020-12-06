(ns advent-of-code.day3-test
  (:require [clojure.test :refer :all]
            [advent-of-code.day3 :refer :all]))


(def tree-line-0 "..#...#...")
(def tree-line-1 ".#...#...#")
(def tree-lines [tree-line-0 tree-line-1])


(deftest test-traverse-x
  (testing "traverse x"
    (is (= (traverse-x tree-line-0 22) \#))
    (is (= (traverse-x tree-line-0 -1) nil))
    (is (= (traverse-x tree-line-0 0) \.))))


(deftest test-is-a-tree?
  (testing "is a tree"
    (is (= (is-a-tree? tree-lines 22 0) true))
    (is (= (is-a-tree? tree-lines 1 31) false))))


(deftest test-solutions
  (testing "test solutions"
    (is (= (part1) 257))
    (is (= (part2) 1744787392))))

(ns cheque.core-test
  (:require [clojure.test :refer :all]
            [cheque.core :refer :all]))

(deftest a-test
  (testing "Convert number to string"
    (is (= "123" (num->str 123))))
  (testing "Base map conversion"
    (is (= "Zero" (num->word 0))))
  (testing "Zero"
    (is (= "Zero" (generate 0))))
  (testing "Less than 20"
    (is (= "Five" (generate 5))))
  (testing "More than 20"
    (is (= "Twenty One" (generate 21))))
  (testing "More than 20"
    (is (= "Thirty Two" (generate 32))))
  (testing "More than 20"
    (is (= "Seventy Six" (generate 76))))
  (testing "More than 20"
    (is (= "Fifty Four" (generate 54)))))

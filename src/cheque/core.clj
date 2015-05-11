(ns cheque.core
  (:require [clojure.string :as s]))

; 1 -> "One"
; 2 -> "Two"
; 3 -> "Three"
; 10 -> "Ten"
; 11 -> "Eleven"
; 99
(def num->word
  {0 "Zero"
   1 "One"
   2 "Two"
   3 "Three"
   4 "Four"
   5 "Five"
   6 "Six"
   7 "Seven"
   8 "Eight"
   9 "Nine"
   10 "Ten"
   20 "Twenty"
   30 "Thirty"
   40 "Forty"
   50 "Fifty"
   60 "Sixty"
   70 "Seventy"
   80 "Eighty"
   90 "Ninety"})

(def powers-of-ten
  ["" "" "Hundred" "Thousand"])

(defn num->str
  [number]
  (str number))

(defn power-of-tens
  [index value]
  (int (* value (Math/pow 10 index))))

(defn tens-component
  [number]
  (->> number
       (num->str)
       (map identity)
       (map str)
       (map (fn [x] (Integer. x)))
       (reverse)
       (map-indexed power-of-tens)
       (map num->word)
       (reverse)
       (s/join " ")))

(defn generate-word-unit
  [number]
  (num->word number))

(defn generate
  [number]
  (if (< (rem number 100) 20)
    (num->word number)
    (if (< number 100)
      (tens-component number)
      ()
      )
    ))

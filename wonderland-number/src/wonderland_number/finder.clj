(ns wonderland-number.finder)

(defn hasAllTheSameDigits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn wonderland-number []
  (first (->> (iterate inc 1)
              (filter #(> % 99999))
              (filter #(< % 1000000))
              (filter #(hasAllTheSameDigits? % (* 2 %)))
              (filter #(hasAllTheSameDigits? % (* 3 %)))
              (filter #(hasAllTheSameDigits? % (* 4 %)))
              (filter #(hasAllTheSameDigits? % (* 5 %)))
              (filter #(hasAllTheSameDigits? % (* 6 %))))))

(defn digits [n]
  (list (unchecked-divide-int n 1000)
        (mod (unchecked-divide-int n 100) 10)
        (mod (unchecked-divide-int n 10) 10)
        (mod n 10)))

(defn wonderland-numbers []
  (filter (fn [n]
            (= n
               (reduce +
                       (map #(* % % %)
                            (digits n)))))
          (range 1000)))

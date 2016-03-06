(ns alphabet-cipher.coder)

(defn char->index [c]
  (- (int c) (int \a)))

(defn rotate [n xs]
  (concat (drop n xs) (take n xs)))

(def alphabet
  (iterate #(rotate 1 %) (seq "abcdefghijklmnopqrstuvwxyz")))

(defn encode [keyword message]
  (let [key (take (count message) (cycle keyword))
        msg (seq message)]
    (apply str (map #(nth (nth alphabet (char->index %1)) (char->index %2))
                    msg key))))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")


(ns alphabet-cipher.coder)

(defn char->index [c]
  (- (int c) (int \a)))

(def alphabet (seq "abcdefghijklmnopqrstuvwxyz"))

(defn encode [keyword message]
  (let [key (take (count message) (cycle keyword))
        msg (seq message)]
    (apply str (map #(nth alphabet
                          (mod (+ (char->index %2)
                                  (char->index %1))
                               (count alphabet)))
                    msg key))))

(defn decode [keyword message]
  (let [key (take (count message) (cycle keyword))
        msg (seq message)]
    (apply str (map #(nth alphabet
                          (mod (- (char->index %1)
                                  (char->index %2))
                               (count alphabet)))
                    msg key))))

(defn decipher [cipher message]
  "decypherme")

(ns alphabet-cipher.coder)

(defn coder [keyword message f]
  (let [key (take (count message) (cycle keyword))
        msg (seq message)
        alphabet (seq "abcdefghijklmnopqrstuvwxyz")
        char->index (fn [c] (- (int c) (int \a)))]
    (apply str (map #(nth alphabet
                          (mod (f (char->index %1)
                                  (char->index %2))
                               (count alphabet)))
                    msg key))))

(defn encode [keyword message]
  (coder keyword message +))

(defn decode [keyword message]
  (coder keyword message -))

(defn decipher [cipher message]
  "decypherme")

(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn hamming
  [word1 word2]
  (when (= (count word1)
           (count word2))
    (count (remove #(= (first %) (second %))
                   (partition 2 (interleave word1 word2))))))

(defn children
  [word dictionary]
  (filter #(= 1 (hamming word %)) dictionary))

(defn build-tree
  [word dict]
  (let [dict  (remove #(= word %) dict)
        nodes (children word dict)]
    (concat (list word)
            (map #(build-tree % (clojure.set/difference (set dict) (set nodes))) nodes))))

(defn doublets [word1 word2]
  (map first
       (filter #(some #{word2} (flatten %))
               (tree-seq next rest (build-tree word1 words)))))





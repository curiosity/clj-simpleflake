(ns clj-simpleflake.core
  (:require crypto.random)
  (:import java.nio.ByteBuffer))

(def >> bit-shift-right)
(def << bit-shift-left)
(def & bit-and)

(defn extract-bits
  [data shift length]
  (>> (& data 
         (<< (dec (<< 1 length)) 
             shift)) 
      shift))

(defn get-random-bits 
  [n]
  (let [q (quot n 8)
        r (rem n 8)
        rz (= r 0)]
    (-> (crypto.random/bytes (if rz
                               (inc q)
                               (+ q 2)))
        (ByteBuffer/wrap)
        .getInt
        (extract-bits (if rz
                        0
                        (- 8 r)) 
                      n))))

(defn ts
  ([]
   (ts (System/currentTimeMillis)))
  ([ms]
   (- ms 946702800000)))  

(defn simpleflake 
  "41 bits of timestamp, 23 bits of randomness"
  ([]
   (simpleflake (ts) (get-random-bits 23)))
  ([ms twenty-three-random-bits] 
   (+ (<< ms 23) 
      twenty-three-random-bits)))

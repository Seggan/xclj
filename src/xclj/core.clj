(ns xclj.core
  (:gen-class :main true)
  (:require [clojure.xml]
            [clojure.string])
  (:import (java.io ByteArrayInputStream)))

(defn- convertToClojure [xml]
  (if (string? xml)
    (map read-string (clojure.string/split xml #"\s+"))
    (let [tag (:tag xml)
          attrs (:attrs xml)
          children (:content xml)]
      (list (if (empty? children)
              (list (resolve (symbol tag)))
              (if (= :q tag)
                (if-let [name (:tag attrs)]
                  (cons (resolve (symbol name)) (mapcat convertToClojure children))
                  (read-string (first children)))
                (cons (resolve (symbol tag)) (mapcat convertToClojure children))))))))

(defn -main [file & args]
  (let [input (ByteArrayInputStream. (.getBytes (slurp file)))
        xml (clojure.xml/parse input)]
    (when (not= :xclj (:tag xml))
      (throw (IllegalArgumentException. "Must have xclj root tag")))
    (doseq [form (:content xml)]
      (eval (first (convertToClojure form))))
    (apply (resolve 'main) (map read-string args))))

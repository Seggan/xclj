(ns xclj.core
  (:import (java.io ByteArrayInputStream))
  (:require [clojure.xml :as xml]
            [clojure.string :as string]
            [clojure.pprint :refer [pprint]]))

(defn- convertToClojure [xml]
  (if (string? xml)
    (map read-string (string/split xml #"\s+"))
    (let [tag (:tag xml)
          attrs (:attrs xml)
          children (:content xml)]
      (if (empty? children)
        (list (resolve (symbol tag)))
        (if (= :q tag)
          (if-let [name (:tag attrs)]
            (cons (resolve (symbol name)) (mapcat convertToClojure children))
            (read-string (first children)))
          (cons (resolve (symbol tag)) (mapcat convertToClojure children)))))))

(defn -main [file]
  (let [input (ByteArrayInputStream. (.getBytes (slurp file)))
        xml (xml/parse input)
        clj (convertToClojure xml)]
    (println (eval clj))))

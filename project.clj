(defproject xclj "0.1.0-SNAPSHOT"
  :description "Clojure, XML edition"
  :url "https://github.com/Seggan/xclj"
  :license {:name "Apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :jar-name "xclj.jar"
  :uberjar-name "xclj-uber.jar"
  :main xclj.core
  :aot [xclj.core]
  :repl-options {:init-ns xclj.core})

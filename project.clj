(defproject yggdrasil-playground "0.1.0-SNAPSHOT"
  :description "Example code for the Yggdrasil library"
  :url "https://github.com/kwrooijen/yggdrasil-playground"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [metosin/reitit "0.5.5"]
                 [ring "1.8.1"]
                 [ring/ring-defaults "0.3.2"]
                 [kwrooijen/yggdrasil "0.0.1-SNAPSHOT"]
                 [g7s/module.shadow-cljs "0.1.2"]
                 [aleph "0.4.7-alpha5"]]
  :source-paths ["src/clj" "src/cljs" "src/cljc"]
  :main ^:skip-aot yggdrasil-playground.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})

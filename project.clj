(defproject brutus "0.1.0-SNAPSHOT"
            :description "A simple and lightweight Entity Component System library based on markmandel/brute"
            :url "http://www.github.com/atamis/brutus"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.10.0"]
                           [org.clojure/math.numeric-tower "0.0.4"]
                           [im.chit/purnam.test "0.4.3"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  )

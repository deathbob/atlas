(ns atlas.core
  (:require [clojurewerkz.titanium.graph    :as tg]
            [clojurewerkz.titanium.edges    :as te]
            [clojurewerkz.titanium.vertices :as tv]
            [clojurewerkz.titanium.types    :as tt]
            [clojurewerkz.titanium.query    :as tq]
            [ogre.core :as oq]
            ;; [clojurewerkz.ogre.io :as io]
            ;; [ogre.io :as io]
  ))

(defn- main
  [& args]
  (tg/open (System/getProperty "java.io.tmpdir"))
  (tg/transact!
 (let [p1 (tv/create! {:title "ClojureWerkz" :url "http://clojurewerkz.org"})
       p2 (tv/create! {:title "Titanium"     :url "http://titanium.clojurewerkz.org"})]
   (te/connect! p1 :meaningless p2)
   (te/connect! p1 :meaningful  p2 {:verified-on "February 11th, 2013"})))
  (prn "export to JSON goes here ... ")
  )

(main)

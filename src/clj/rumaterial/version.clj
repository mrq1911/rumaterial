(ns rumaterial.version
  (:require [clojure.java.io :as io]
            [clojure.walk :refer [keywordize-keys]])
  (:import (java.util Properties)))

(def pom-properties
  (doto (Properties.)
    (.load (-> "META-INF/maven/rumaterial/rumaterial/pom.properties"
               (io/resource)
               (io/reader)))))

(defn info
  []
  {:name        "rumaterial"
   :version     (get pom-properties "version")
   :revision    (get pom-properties "revision")})

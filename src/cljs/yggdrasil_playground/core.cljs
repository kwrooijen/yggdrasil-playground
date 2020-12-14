(ns yggdrasil-playground.core
  (:require
   [yggdrasil-playground.html]
   [yggdrasil.core]))

(def pages
  {::page-home yggdrasil-playground.html/page-home})

(yggdrasil.core/mount-root
 "app"
 (fn []
   [(:body/html yggdrasil-playground.html/body-main)
    (:page/html (get pages (yggdrasil.core/get-page-key)))])
 (fn []
   (println "Yggdrasil sprouted 🌱")
   ,,,))

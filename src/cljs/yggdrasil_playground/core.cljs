(ns yggdrasil-playground.core
  (:require
   [yggdrasil-playground.html]
   [yggdrasil.core]))

(yggdrasil.core/mount-root
 "app"
 (fn [] [(:body/html yggdrasil-playground.html/body-main)
         (:page/html yggdrasil-playground.html/page-home)])
 (fn []
   (println "Yggdrasil sprouted 🌱")
   ,,,))

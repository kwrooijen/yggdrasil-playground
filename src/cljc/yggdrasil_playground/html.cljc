(ns yggdrasil-playground.html
  (:require
   [yggdrasil.db :refer [db]]))

(defn template-main-html [body]
  [:html
   [:head
    [:script {:src "/js/compiled/main.js"}]]
   [:body
    [:div#app
     [body]]]])

(defn body-main-html [page]
  [:div
   [:div "Main body"]
   [page]])

(defn page-home-html []
  [:div#page "Home Page" @(:counter db)
   [:div {:on-click #(swap! (:counter db) inc)}
    "Increment"]])

(def template-main
  {:template/html template-main-html
   :template/atoms {:counter 123}
   :template/values {}})

(def body-main
  {:body/html body-main-html
   :body/atoms {}
   :body/values {}})

(def page-home
  {:page/html page-home-html
   :page/atoms {}
   :page/values {}})

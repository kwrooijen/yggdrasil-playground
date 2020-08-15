(ns yggdrasil-playground.core
  (:require
   [aleph.http :as http]
   [buddy.core.hash :refer [md5]]
   [reitit.ring :as ring]
   [ring.middleware.defaults :refer [wrap-defaults]]
   [ring.middleware.session.cookie]
   [yggdrasil-playground.html]
   [yggdrasil.handler]
   [yggdrasil.sente])
  (:gen-class))

(defn default-template [page]
  {:template yggdrasil-playground.html/template-main
   :body yggdrasil-playground.html/body-main
   :page page})

(defn home-handler [request]
  (yggdrasil.handler/handler
   request ::some-key
   (default-template yggdrasil-playground.html/page-home)))

(def routes
  [["/"
    {:get {:handler home-handler}}]
   ["/chsk"
    {:get {:handler yggdrasil.sente/handler-get}
     :post {:handler yggdrasil.sente/handler-post}}]

   ["/js/compiled/main.js" (ring/create-resource-handler)]
   ["/favicon.ico" (ring/create-resource-handler)]])

(def cookie-session-store
  (ring.middleware.session.cookie/cookie-store
   {:key (md5 "Some Secret Key")}))

(def site-defaults
  (-> ring.middleware.defaults/site-defaults
      (assoc-in [:session :cookie-attrs :same-site] :lax)
      (assoc-in [:session :store] cookie-session-store)))

(def route-opts
  {:data {:middleware [#(wrap-defaults % site-defaults)]}})

(def app
  (ring/ring-handler
   (ring/router routes route-opts)))

(defn -main [& args]
  (http/start-server #'app {:port 3000})
  (yggdrasil.sente/start-router))

(comment
  (-main)
  ,,,
  )

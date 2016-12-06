(ns cljs-ex-navigation.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [cljs-ex-navigation.handlers]
            [cljs-ex-navigation.subs]
            [cljs-exponent.core]
            [cljs-exponent.reagent :refer [text view image touchable-highlight] :as rn]
            [cljs-ex-navigation.rn-elements :as rne]
            [cljs-ex-navigation.navigation.router :as router]))


(defn app-root []
  [rne/navigation-provider {:router router/router}
   [rne/stack-navigation {:id "root"
                          :initialRoute "tabs"}]])

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent rn/app-registry "main" #(r/reactify-component app-root)))

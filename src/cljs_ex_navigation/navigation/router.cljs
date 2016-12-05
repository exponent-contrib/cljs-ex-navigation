(ns cljs-ex-navigation.navigation.router
  (:require [cljs-ex-navigation.rn-elements :as rne]
            [cljs-ex-navigation.navigation.tab :as tab]
            [cljs-ex-navigation.scenes.first :as first]
            [cljs-ex-navigation.scenes.second :as second]
            [cljs-ex-navigation.scenes.third :as third]
            ))

(def router (rne/create-router
             (fn []
               #js {:tabs tab/navigation-tab
                    :first first/first-scene
                    :second second/second-scene
                    :third third/third-scene})))

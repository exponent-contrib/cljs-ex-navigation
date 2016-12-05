(ns cljs-ex-navigation.navigation.tab
  (:require [cljs-ex-navigation.rn-elements :as rne]
            [reagent.core :as r]
            [cljs-exponent.reagent :refer [view]]))

(defn icon-cp
  [icon-name selected?]
  [view {:style {:align-items "center"
                 :justify-content "center"}}
   [rne/material-icon {:name icon-name
                       :size 24
                       :color (if selected? "#65bc54" "#888")}]])

(defn tab-item-cp
  [id icon-name badge]
  (r/create-element
   rne/TabNavigationItem
   #js{:className "cljs-tab-item"
       :id id
       :badgeText badge
       :badge {:backgroundColor "red"}
       :renderIcon (fn [selected?]
                     (r/as-element [icon-cp icon-name selected?]))}
   (r/as-element
    [rne/stack-navigation
     {:defaultRouteConfig {:navigationBar
                           {:tintColor "#666"
                            :backgroundColor "#efefef"}}
      :initialRoute id}])))

(defn navigation-tab
  []
  [rne/tab-navigation
   {:tabBarColor "#fefefe"
    :tabBarHeight 56
    :initialTab "first"}
   (tab-item-cp "first" "chat-bubble-outline" nil)
   (tab-item-cp "second" "notifications-none" nil)
   (tab-item-cp "third" "group-work" nil)])

(ns cljs-ex-navigation.rn-elements
  (:require [reagent.core :as r]))

;; ex-navigation
(def ExNavigation (js/require "@exponent/ex-navigation"))
(def create-router (aget ExNavigation "createRouter"))
(def NavigationProvider (aget ExNavigation "NavigationProvider"))
(def navigation-provider (r/adapt-react-class NavigationProvider))
(def StackNavigation (aget ExNavigation "StackNavigation"))
(def stack-navigation (r/adapt-react-class StackNavigation))
(def TabNavigation (aget ExNavigation "TabNavigation"))
(def tab-navigation (r/adapt-react-class TabNavigation))
(def TabNavigationItem (aget ExNavigation "TabNavigationItem"))
(def tab-navigation-item (r/adapt-react-class TabNavigationItem))

;; vector-icons
(def FontAwesome (js/require "@exponent/vector-icons/FontAwesome"))

(def icon (r/adapt-react-class (aget FontAwesome "default")))
(def FontAwesomeButton (aget FontAwesome "default" "Button"))
(def icon-button (r/adapt-react-class FontAwesomeButton))

(def MaterialIcons (js/require "@exponent/vector-icons/MaterialIcons"))
(def material-icon (r/adapt-react-class (aget MaterialIcons "default")))
(def MaterialIconButton (aget MaterialIcons "default" "Button"))
(def material-icon-button (r/adapt-react-class MaterialIconButton))

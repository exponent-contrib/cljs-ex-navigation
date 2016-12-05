(ns cljs-ex-navigation.navigation.util
  (:require [reagent.core :as r]
            [re-frame.core :refer [dispatch]]))

(defn set-nav
  [this]
  (let [props (r/props this)
        root-nav (when-let [navigation (:navigation props)]
                   (.getNavigator navigation "root"))
        nav (:navigator props)]
    (when nav
      (dispatch [:nav/set-nav (cond->
                                {:nav nav}
                                root-nav
                                (assoc :root-nav root-nav))]))))

(defn wrap-route
  [component route-opts]
  (let [c (r/create-class {:component-will-mount set-nav
                           :reagent-render (fn [] component)})]
    (aset c "route" (clj->js route-opts))
    c))

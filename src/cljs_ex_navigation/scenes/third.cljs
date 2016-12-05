(ns cljs-ex-navigation.scenes.third
  (:require [cljs-exponent.reagent :refer [view text]]
            [cljs-ex-navigation.navigation.util :as util]))

(defn third-cp
  []
  [view {:style {:flex 1
                 :background-color "red"
                 :justify-content "center"
                 :align-items "center"}}
   [text {:style {:font-size 24
                  :font-weight "bold"}}
    "Third Scene"]])

(defn third-scene
  [props]
  (util/wrap-route third-cp {:navigationBar {:title "Third Scene"
                                              :titleStyle {:color "#333"}
                                              :backgroundColor "rgba(255,255,255,0.5)"}}))

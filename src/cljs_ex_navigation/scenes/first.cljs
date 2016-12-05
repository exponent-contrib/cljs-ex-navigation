(ns cljs-ex-navigation.scenes.first
  (:require [cljs-exponent.reagent :refer [view text]]
            [cljs-ex-navigation.navigation.util :as util]))

(defn first-cp
  []
  [view {:style {:flex 1
                 :background-color "red"
                 :justify-content "center"
                 :align-items "center"}}
   [text {:style {:font-size 24
                  :font-weight "bold"
                  :color "white"}}
    "First Scene"]])

(defn first-scene
  [props]
  (util/wrap-route first-cp {:navigationBar {:title "First Scene"
                                             :titleStyle {:color "white"}
                                             :backgroundColor "red"}}))

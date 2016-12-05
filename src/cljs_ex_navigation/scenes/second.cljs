(ns cljs-ex-navigation.scenes.second
  (:require [cljs-exponent.reagent :refer [view text]]
            [cljs-ex-navigation.navigation.util :as util]))

(defn second-cp
  []
  [view {:style {:flex 1
                 :background-color "red"
                 :justify-content "center"
                 :align-items "center"}}
   [text {:style {:font-size 24
                  :font-weight "bold"}}
    "Second Scene"]])

(defn second-scene
  [props]
  (util/wrap-route second-cp {:navigationBar {:title "Second Scene"
                                             :titleStyle {:color "#333"}
                                             :backgroundColor "rgba(255,255,255,0.5)"}}))

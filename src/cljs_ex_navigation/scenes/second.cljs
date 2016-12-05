(ns cljs-ex-navigation.scenes.second
  (:require [cljs-exponent.reagent :refer [view text]]
            [cljs-ex-navigation.navigation.util :as util]))

(defn second-cp
  []
  [view {:style {:flex 1
                 :background-color "green"
                 :justify-content "center"
                 :align-items "center"}}
   [text {:style {:font-size 24
                  :font-weight "bold"
                  :color "white"}}
    "Second Scene"]])

(defn second-scene
  [props]
  (util/wrap-route second-cp {:navigationBar {:title "Second Scene"
                                              :titleStyle {:color "white"}
                                              :backgroundColor "green"}}))

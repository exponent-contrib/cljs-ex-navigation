(ns cljs-ex-navigation.scenes.third
  (:require [cljs-exponent.reagent :refer [view text]]
            [cljs-ex-navigation.navigation.util :as util]))

(defn third-cp
  []
  [view {:style {:flex 1
                 :background-color "blue"
                 :justify-content "center"
                 :align-items "center"}}
   [text {:style {:font-size 24
                  :font-weight "bold"
                  :color "white"}}
    "Third Scene"]])

(defn third-scene
  [props]
  (util/wrap-route third-cp {:navigationBar {:title "Third Scene"
                                             :titleStyle {:color "white"}
                                             :backgroundColor "blue"}}))

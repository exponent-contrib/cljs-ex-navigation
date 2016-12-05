(ns cljs-ex-navigation.handlers
  (:require
    [re-frame.core :refer [register-handler after]]
    [clojure.spec :as s]
    [cljs-ex-navigation.db :as db :refer [app-db]]))

;; -- Middleware ------------------------------------------------------------
;;
;; See https://github.com/Day8/re-frame/wiki/Using-Handler-Middleware
;;
(defn check-and-throw
  "Throw an exception if db doesn't have a valid spec."
  [spec db]
  (when-not (s/valid? spec db)
    (let [explain-data (s/explain-data spec db)]
      (throw (ex-info (str "Spec check failed: " explain-data) explain-data)))))

(def validate-spec-mw
  (if goog.DEBUG
    (after (partial check-and-throw ::db/app-db))
    []))

;; -- Handlers --------------------------------------------------------------

(register-handler
  :initialize-db
  (fn [_ _]
    app-db))

(register-handler
 :nav/set-nav
 (fn [db [_ value]]
   (merge db value)))

(register-handler
 :nav/push
 (fn [db [_ {:keys [key]
             :as route}]]
   (when-let [nav (:nav db)]
     (.push nav
            (name key)
            (clj->js (dissoc route :key))))
   db))

(register-handler
 :nav/root-push
 (fn [db [_ {:keys [key]
             :as route}]]
   (when-let [root-nav (:root-nav db)]
     (.push root-nav
            (name key)
            (clj->js (dissoc route :key))))
   db))

(register-handler
 :nav/pop
 (fn [db _]
   (when-let [nav (:nav db)]
     (.pop nav))
   db))

(register-handler
 :nav/show-local-alert
 (fn [db [_ text style]]
   (when-let [nav (:nav db)]
     (.showLocalAlert (:navigator nav) text (clj->js style)))
   db))

(ns cljs.components.validated-input
  (:require
    [cljs.utils.helpers :refer [<sub >dis]]
    [cljs.events :as shared-events]
    [cljs.subs :as shared-subs]))

(defn text [{:keys [label route form field]}]
  (let [{:keys [has-error? error-message value]} (<sub [::shared-subs/form-field route form field])]
    [:div.field
     [:label.label label]
     [:input.input {:type "text"
                    :class (when has-error? "is-danger")
                    :value value
                    :placeholder label
                    :on-change #(>dis [::shared-events/set-form-field-value route form field (-> % .-target .-value)])
                    :on-blur #(>dis [::shared-events/set-form-field-dirty route form field])}]
     (when has-error? [:span.error-message error-message])]))
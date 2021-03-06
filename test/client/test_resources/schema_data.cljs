(ns client.test-resources.schema-data)

(def schema {:idents {:db.schema.ident.namespace/cone-type {:namespace :db.schema.ident.namespace/cone-type
                                                            :doc "Ice cream cone options currently available in store."
                                                            :referenced-by [:db.schema.entity.namespace/sale]
                                                            :ns-idents [{:ident :cone-type/sugar
                                                                         :attribute? false
                                                                         :namespace :db.schema.ident.namespace/cone-type}
                                                                        {:ident :cone-type/cake
                                                                         :attribute? false
                                                                         :namespace :db.schema.ident.namespace/cone-type}
                                                                        {:ident :cone-type/gravy
                                                                         :attribute? false
                                                                         :namespace :db.schema.ident.namespace/cone-type
                                                                         :deprecated? true
                                                                         :replaced-by [:cone-type/cake]}
                                                                        {:ident :cone-type/waffle
                                                                         :attribute? false
                                                                         :namespace :db.schema.ident.namespace/cone-type}]}
                      :db.schema.ident.namespace/ice-cream-flavor {:namespace :db.schema.ident.namespace/ice-cream-flavor
                                                                   :doc "Ice cream flavor options currently available in store."
                                                                   :referenced-by [:db.schema.entity.namespace/sale]
                                                                   :ns-idents [{:ident :ice-cream-flavor/vanilla
                                                                                :attribute? false
                                                                                :namespace :db.schema.ident.namespace/ice-cream-flavor}
                                                                               {:ident :ice-cream-flavor/strawberry
                                                                                :attribute? false
                                                                                :namespace :db.schema.ident.namespace/ice-cream-flavor}
                                                                               {:ident :ice-cream-flavor/chocolate
                                                                                :attribute? false
                                                                                :namespace :db.schema.ident.namespace/ice-cream-flavor}]}}
             :entities {:db.schema.entity.namespace/licensed-retailer {:namespace :db.schema.entity.namespace/licensed-retailer
                                                                       :doc "An business who is licensed to sell our branded ice cream cones"
                                                                       :referenced-by [:db.schema.entity.namespace/sale]
                                                                       :ns-entities [{:ident :licensed-retailer/employees
                                                                                      :attribute? true
                                                                                      :doc "Employees who may work at a given licensed retailer location"
                                                                                      :cardinality :db.cardinality/many
                                                                                      :value-type :db.type/ref
                                                                                      :namespace :db.schema.entity.namespace/licensed-retailer
                                                                                      :references-namespaces [:db.schema.entity.namespace/employee]}
                                                                                     {:ident :licensed-retailer/id
                                                                                      :attribute? true
                                                                                      :doc "Unique id assigned to each licensed retailer"
                                                                                      :cardinality :db.cardinality/one
                                                                                      :value-type :db.type/uuid
                                                                                      :namespace :db.schema.entity.namespace/licensed-retailer
                                                                                      :unique :db.unique/identity}
                                                                                     {:ident :licensed-retailer/address
                                                                                      :attribute? true
                                                                                      :doc "Street address of a specific licensed retailer location"
                                                                                      :cardinality :db.cardinality/one
                                                                                      :value-type :db.type/string
                                                                                      :namespace :db.schema.entity.namespace/licensed-retailer}]}
                        :db.schema.entity.namespace/sale {:namespace :db.schema.entity.namespace/sale
                                                          :doc "An entity representing a single ice cream cone sale"
                                                          :referenced-by nil
                                                          :ns-entities [{:ident :sale/flavor
                                                                         :attribute? true
                                                                         :doc "A reference to ice-cream-flavor ident"
                                                                         :cardinality :db.cardinality/one
                                                                         :value-type :db.type/ref
                                                                         :namespace :db.schema.entity.namespace/sale
                                                                         :references-namespaces [:db.schema.ident.namespace/ice-cream-flavor]}
                                                                        {:ident :sale/cone
                                                                         :attribute? true
                                                                         :doc "A reference to cone ident"
                                                                         :cardinality :db.cardinality/one
                                                                         :value-type :db.type/ref
                                                                         :namespace :db.schema.entity.namespace/sale
                                                                         :references-namespaces [:db.schema.ident.namespace/cone-type]}
                                                                        {:ident :sale/id
                                                                         :attribute? true
                                                                         :doc "Unique id assigned to each sale"
                                                                         :cardinality :db.cardinality/one
                                                                         :value-type :db.type/uuid
                                                                         :namespace :db.schema.entity.namespace/sale
                                                                         :unique :db.unique/identity}
                                                                        {:ident :sale/location
                                                                         :attribute? true
                                                                         :doc "A reference to a store or licensed retailer entity"
                                                                         :cardinality :db.cardinality/one
                                                                         :value-type :db.type/ref
                                                                         :namespace :db.schema.entity.namespace/sale
                                                                         :references-namespaces [:db.schema.entity.namespace/licensed-retailer :db.schema.entity.namespace/store]}]}
                        :db.schema.entity.namespace/store {:namespace :db.schema.entity.namespace/store
                                                           :doc "An entity representing an individual ice cream store"
                                                           :referenced-by [:db.schema.entity.namespace/sale]
                                                           :ns-entities [{:ident :store/capricious-accounting-department-id
                                                                          :attribute? true
                                                                          :doc "An id that is subject to change based on the whims of the accounting department. No history is retained."
                                                                          :cardinality :db.cardinality/one
                                                                          :value-type :db.type/string
                                                                          :namespace :db.schema.entity.namespace/store
                                                                          :no-history? true}
                                                                         {:ident :store/address
                                                                          :attribute? true
                                                                          :doc "Street address of a specific store location"
                                                                          :cardinality :db.cardinality/one
                                                                          :value-type :db.type/string
                                                                          :namespace :db.schema.entity.namespace/store}
                                                                         {:ident :store/id
                                                                          :attribute? true
                                                                          :doc "Unique id assigned to each store"
                                                                          :cardinality :db.cardinality/one
                                                                          :value-type :db.type/uuid
                                                                          :namespace :db.schema.entity.namespace/store
                                                                          :unique :db.unique/identity}
                                                                         {:ident :store/employees
                                                                          :attribute? true
                                                                          :doc "Employees who may work at a given store"
                                                                          :cardinality :db.cardinality/many
                                                                          :value-type :db.type/ref
                                                                          :namespace :db.schema.entity.namespace/store
                                                                          :references-namespaces [:db.schema.entity.namespace/employee]
                                                                          :is-component? true}]}
                        :db.schema.entity.namespace/employee {:namespace :db.schema.entity.namespace/employee
                                                              :doc "An entity representing an individual employee"
                                                              :referenced-by [:db.schema.entity.namespace/store :db.schema.entity.namespace/licensed-retailer]
                                                              :ns-entities [{:ident :employee/name
                                                                             :attribute? true
                                                                             :doc "Employee's must have a unique combination of first and last names."
                                                                             :cardinality :db.cardinality/one
                                                                             :value-type :db.type/tuple
                                                                             :namespace :db.schema.entity.namespace/employee
                                                                             :unique :db.unique/identity
                                                                             :tuple-attrs [:employee/first-name :employee/last-name]}
                                                                            {:ident :employee/last-name
                                                                             :attribute? true
                                                                             :doc "Employee's last name"
                                                                             :cardinality :db.cardinality/one
                                                                             :value-type :db.type/string
                                                                             :namespace :db.schema.entity.namespace/employee
                                                                             :attr-preds ['i-am-not-real.attr-preds/user-name? 'i-am-not-real.attr-preds/valid-last-name?]
                                                                             }
                                                                            {:ident :employee/first-name
                                                                             :attribute? true
                                                                             :doc "Employee's first name"
                                                                             :cardinality :db.cardinality/one
                                                                             :value-type :db.type/string
                                                                             :namespace :db.schema.entity.namespace/employee}]
                                                              :attrs [:employee/first-name :employee/last-name]
                                                              :preds ['i-am-not-real.entity-preds/valid-employee-name?]}}})
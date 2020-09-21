(ns clj-forward.core-test
  (:require [clojure.test :refer :all]
            [clj-forward.core :refer :all]
            [schema.core :refer :all :exclude [atom fn Inst defn defmethod letfn defrecord]]
            [clojure.pprint :as pprint]
            [cheshire.core :refer [parse-string]]
            [taoensso.timbre :as timbre]
            [clojure.java.io :as io]
            [martian.core :as martian]
            [martian.interceptors :as interceptors]
            [martian.clj-http-lite :as martian-http]))


(deftest explore-test-1
  (is (= [[:get-device-credentials-using-get
           "Lists a network’s device credentials"]
          [:create-device-credential-using-post
           "Creates or replaces a network device credential"]
          [:delete-device-credential-using-delete
           "Deletes a network device credential"]
          [:patch-device-credential-using-patch
           "Updates a network device credential"]
          [:collect-using-post
           "Triggers a network collection"]
          [:get-network-layout-using-get
           "Gets the network layout"]
          [:set-network-layout-using-post
           "Updates the network layout"]
          [:get-l-3-vpn-using-get
           "Gets an L3VPN"]
          [:put-l-3-vpn-using-put
           "Adds or replaces an L3VPN"]
          [:delete-l-3-vpn-using-delete
           "Removes an L3VPN"]
          [:patch-l-3-vpn-using-patch
           "Updates an L3VPN"]
          [:delete-l-2-vpn-connection-using-delete
           "Removes a connection from an L2VPN"]
          [:get-device-sources-using-get
           "Gets a network’s device sources"]
          [:add-or-update-device-sources-using-post
           "Creates or updates network device sources"]
          [:cancel-collect-using-post
           "Cancels an in-progress network collection"]
          [:get-single-check-using-get
           "Gets a check (with status)"]
          [:deactivate-check-using-delete
           "Deactivates a check"]
          [:add-l-2-vpn-connection-using-post
           "Adds a connection to an L2VPN"]
          [:delete-network-using-delete
           "Deletes a network"]
          [:update-network-using-patch
           "Renames a network"]
          [:get-l-3-vpns-using-get
           "Gets a network’s L3VPNs"]
          [:put-l-3-vpns-using-put
           "Replaces all of a network’s L3VPNs"]
          [:get-device-file-content-using-get
           "Gets device data file content"]
          [:get-networks-using-get
           "Lists all networks"]
          [:create-network-using-post
           "Creates a network"]
          [:update-device-source-using-put
           "Creates or replaces a network device source"]
          [:delete-device-source-using-delete
           "Deletes a network device source"]
          [:get-collector-state-using-get
           "Gets the status of a network’s collector"]
          [:get-checks-using-get
           "Gets checks (with status)"]
          [:add-check-using-post
           "Adds a check"]
          [:deactivate-checks-using-delete
           "Deactivates all checks"]
          [:get-jump-servers-using-get
           "Lists a network’s jump servers"]
          [:create-jump-server-using-post
           "Creates or replaces a jump server"]
          [:get-latest-processed-snapshot-using-get
           "Returns the latest processed Snapshot"]
          [:list-network-snapshots-using-get
           "Lists all Snapshots"]
          [:create-snapshot-using-post
           "Imports a Snapshot"]
          [:get-l-2-vpn-using-get
           "Gets an L2VPN"]
          [:put-l-2-vpn-using-put
           "Adds or replaces an L2VPN"]
          [:delete-l-2-vpn-using-delete
           "Removes an L2VPN"]
          [:patch-l-2-vpn-using-patch
           "Updates an L2VPN"]
          [:delete-l-3-vpn-edge-port-using-delete
           "Removes a connection from an L3VPN"]
          [:get-paths-bulk-using-post
           "Searches for paths by tracing sets of packets through the network"]
          [:zip-snapshot-using-get
           "Exports a Snapshot"]
          [:delete-snapshot-using-delete
           "Deletes a Snapshot"]
          [:get-snapshot-metrics-using-get
           "Returns the metrics of a Snapshot"]
          [:get-device-files-using-get
           "Lists a device’s data files"]
          [:get-paths-using-get
           "Searches for paths by tracing packets through the network"]
          [:set-network-topo-list-using-put
           "Sets the topology overrides"]
          [:run-nqe-query-using-post
           "Runs an NQE query on a Snapshot."]
          [:get-snapshot-topo-overrides-using-get
           "Gets the topology overrides"]
          [:post-snapshot-topo-overrides-using-post
           "Edits the topology overrides"]
          [:put-snapshot-topo-overrides-using-put
           "Sets the topology overrides"]
          [:get-trace-paths-bulk-seq-using-post
           "Searches for paths by tracing sets of packets through the network"]
          [:get-single-alias-using-get
           "Gets an Alias"]
          [:create-snapshot-alias-using-put
           "Creates an Alias"]
          [:deactivate-alias-using-delete
           "Deletes an Alias"]
          [:get-topology-using-get
           "Gets the network topology"]
          [:get-l-2-vpns-using-get
           "Gets a network’s L2VPNs"]
          [:put-l-2-vpns-using-put
           "Replaces all of a network’s L2VPNs"]
          [:get-all-aliases-using-get
           "Gets all Aliases"]
          [:get-available-predefined-checks-using-get
           "Gets available Predefined checks"]
          [:delete-jump-server-using-delete
           "Deletes a jump server"]
          [:edit-jump-server-using-patch
           "Updates a jump server"]
          [:add-l-3-vpn-connection-using-post
           "Adds a connection to an L3VPN"]]
         (->
           (clj-forward.core/bootstrap-openapi "https://scale605:8443" (parse-string (slurp (io/resource "api.json"))))
           explore))))

(deftest explore-test-2
  (let [api (bootstrap-openapi "https://scale605:8443" (parse-string (slurp (io/resource "api.json"))))]
    (is (= ["Lists a network’s device credentials"
            "Creates or replaces a network device credential"
            "Deletes a network device credential"
            "Updates a network device credential"
            "Triggers a network collection"
            "Gets the network layout"
            "Updates the network layout"
            "Gets an L3VPN"
            "Adds or replaces an L3VPN"
            "Removes an L3VPN"
            "Updates an L3VPN"
            "Removes a connection from an L2VPN"
            "Gets a network’s device sources"
            "Creates or updates network device sources"
            "Cancels an in-progress network collection"
            "Gets a check (with status)"
            "Deactivates a check"
            "Adds a connection to an L2VPN"
            "Deletes a network"
            "Renames a network"
            "Gets a network’s L3VPNs"
            "Replaces all of a network’s L3VPNs"
            "Gets device data file content"
            "Lists all networks"
            "Creates a network"
            "Creates or replaces a network device source"
            "Deletes a network device source"
            "Gets the status of a network’s collector"
            "Gets checks (with status)"
            "Adds a check"
            "Deactivates all checks"
            "Lists a network’s jump servers"
            "Creates or replaces a jump server"
            "Returns the latest processed Snapshot"
            "Lists all Snapshots"
            "Imports a Snapshot"
            "Gets an L2VPN"
            "Adds or replaces an L2VPN"
            "Removes an L2VPN"
            "Updates an L2VPN"
            "Removes a connection from an L3VPN"
            "Searches for paths by tracing sets of packets through the network"
            "Exports a Snapshot"
            "Deletes a Snapshot"
            "Returns the metrics of a Snapshot"
            "Lists a device’s data files"
            "Searches for paths by tracing packets through the network"
            "Sets the topology overrides"
            "Runs an NQE query on a Snapshot."
            "Gets the topology overrides"
            "Edits the topology overrides"
            "Sets the topology overrides"
            "Searches for paths by tracing sets of packets through the network"
            "Gets an Alias"
            "Creates an Alias"
            "Deletes an Alias"
            "Gets the network topology"
            "Gets a network’s L2VPNs"
            "Replaces all of a network’s L2VPNs"
            "Gets all Aliases"
            "Gets available Predefined checks"
            "Deletes a jump server"
            "Updates a jump server"
            "Adds a connection to an L3VPN"]
           (mapv second (explore api))))))



(deftest explore-test-2
  (let [martian (bootstrap-openapi "https://scale605:8443" (parse-string (slurp (io/resource "api.json"))))
        api (mapv first (explore martian))]
    (is (= [{:parameters {:network-id java.lang.String}
             :returns    {200 [{#schema.core.OptionalKey{:k :content}  (maybe
                                                                         Str)
                                #schema.core.OptionalKey{:k :id}       (maybe
                                                                         Str)
                                #schema.core.OptionalKey{:k :name}     (maybe
                                                                         Str)
                                #schema.core.OptionalKey{:k :password} (maybe
                                                                         Str)
                                #schema.core.OptionalKey{:k :type}     (maybe
                                                                         (enum
                                                                           "LOGIN"
                                                                           "SHELL"
                                                                           "KEY_STORE"
                                                                           "PRIVILEGED_MODE"
                                                                           "OPENFLOW_TRUST_STORE"
                                                                           "OPENFLOW_KEY_STORE"))
                                #schema.core.OptionalKey{:k :username} (maybe
                                                                         Str)}]}
             :summary    "Lists a network’s device credentials"}
            {:parameters {:device-credential {#schema.core.OptionalKey{:k :content}  (maybe
                                                                                       Str)
                                              #schema.core.OptionalKey{:k :id}       (maybe
                                                                                       Str)
                                              #schema.core.OptionalKey{:k :name}     (maybe
                                                                                       Str)
                                              #schema.core.OptionalKey{:k :password} (maybe
                                                                                       Str)
                                              #schema.core.OptionalKey{:k :type}     (maybe
                                                                                       (enum
                                                                                         "LOGIN"
                                                                                         "SHELL"
                                                                                         "KEY_STORE"
                                                                                         "PRIVILEGED_MODE"
                                                                                         "OPENFLOW_TRUST_STORE"
                                                                                         "OPENFLOW_KEY_STORE"))
                                              #schema.core.OptionalKey{:k :username} (maybe
                                                                                       Str)}
                          :network-id        java.lang.String}
             :returns    {200 {#schema.core.OptionalKey{:k :content}  (maybe
                                                                        Str)
                               #schema.core.OptionalKey{:k :id}       (maybe
                                                                        Str)
                               #schema.core.OptionalKey{:k :name}     (maybe
                                                                        Str)
                               #schema.core.OptionalKey{:k :password} (maybe
                                                                        Str)
                               #schema.core.OptionalKey{:k :type}     (maybe
                                                                        (enum
                                                                          "LOGIN"
                                                                          "SHELL"
                                                                          "KEY_STORE"
                                                                          "PRIVILEGED_MODE"
                                                                          "OPENFLOW_TRUST_STORE"
                                                                          "OPENFLOW_KEY_STORE"))
                               #schema.core.OptionalKey{:k :username} (maybe
                                                                        Str)}}
             :summary    "Creates or replaces a network device credential"}]
           (take 2 (mapv #(explore martian %) api))))))




(deftest explore-test-3
  (let [martian (bootstrap-openapi "FOOBAR" (parse-string (slurp (io/resource "api.json"))))]
    (is (= [{:base      :get-device-credentials-using-get
             :command   "device-credentials"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Lists a network’s device credentials"
             :verb      "get"}
            {:base      :get-network-layout-using-get
             :command   "network-layout"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Gets the network layout"
             :verb      "get"}
            {:base      :get-l-3-vpn-using-get
             :command   "l-3-vpn"
             :param-opt []
             :param-req [:snapshot-id
                         :l-3-vpn-name]
             :sub       "show"
             :summary   "Gets an L3VPN"
             :verb      "get"}
            {:base      :get-device-sources-using-get
             :command   "device-sources"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Gets a network’s device sources"
             :verb      "get"}
            {:base      :get-single-check-using-get
             :command   "single-check"
             :param-opt []
             :param-req [:snapshot-id
                         :check-id]
             :sub       "show"
             :summary   "Gets a check (with status)"
             :verb      "get"}
            {:base      :get-l-3-vpns-using-get
             :command   "l-3-vpns"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Gets a network’s L3VPNs"
             :verb      "get"}
            {:base      :get-device-file-content-using-get
             :command   "device-file-content"
             :param-opt []
             :param-req [:snapshot-id
                         :device-name
                         :file-name]
             :sub       "show"
             :summary   "Gets device data file content"
             :verb      "get"}
            {:base      :get-networks-using-get
             :command   "networks"
             :param-opt []
             :param-req []
             :sub       "show"
             :summary   "Lists all networks"
             :verb      "get"}
            {:base      :get-collector-state-using-get
             :command   "collector-state"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Gets the status of a network’s collector"
             :verb      "get"}
            {:base      :get-checks-using-get
             :command   "checks"
             :param-opt []
             :param-req [:snapshot-id
                         :type]
             :sub       "show"
             :summary   "Gets checks (with status)"
             :verb      "get"}
            {:base      :get-jump-servers-using-get
             :command   "jump-servers"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Lists a network’s jump servers"
             :verb      "get"}
            {:base      :get-latest-processed-snapshot-using-get
             :command   "latest-processed-snapshot"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Returns the latest processed Snapshot"
             :verb      "get"}
            {:base      :list-network-snapshots-using-get
             :command   "network-snapshots"
             :param-opt []
             :param-req [:network-id]
             :sub       "show"
             :summary   "Lists all Snapshots"
             :verb      "get"}
            {:base      :get-l-2-vpn-using-get
             :command   "l-2-vpn"
             :param-opt []
             :param-req [:snapshot-id
                         :l-2-vpn-name]
             :sub       "show"
             :summary   "Gets an L2VPN"
             :verb      "get"}
            {:base      :zip-snapshot-using-get
             :command   "snapshot"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Exports a Snapshot"
             :verb      "get"}
            {:base      :get-snapshot-metrics-using-get
             :command   "snapshot-metrics"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Returns the metrics of a Snapshot"
             :verb      "get"}
            {:base      :get-device-files-using-get
             :command   "device-files"
             :param-opt []
             :param-req [:snapshot-id
                         :device-name]
             :sub       "show"
             :summary   "Lists a device’s data files"
             :verb      "get"}
            {:base      :get-paths-using-get
             :command   "paths"
             :param-opt [:max-seconds
                         :max-return-path-results
                         :dst-port
                         :include-network-functions
                         :intent
                         :max-candidates
                         :src-port
                         :ip-proto
                         :max-results
                         :icmp-type]
             :param-req [:snapshot-id
                         :src-ip
                         :dst-ip]
             :sub       "show"
             :summary   "Searches for paths by tracing packets through the network"
             :verb      "get"}
            {:base      :get-snapshot-topo-overrides-using-get
             :command   "snapshot-topo-overrides"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Gets the topology overrides"
             :verb      "get"}
            {:base      :get-single-alias-using-get
             :command   "single-alias"
             :param-opt []
             :param-req [:snapshot-id
                         :alias-name]
             :sub       "show"
             :summary   "Gets an Alias"
             :verb      "get"}
            {:base      :get-topology-using-get
             :command   "topology"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Gets the network topology"
             :verb      "get"}
            {:base      :get-l-2-vpns-using-get
             :command   "l-2-vpns"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Gets a network’s L2VPNs"
             :verb      "get"}
            {:base      :get-all-aliases-using-get
             :command   "all-aliases"
             :param-opt []
             :param-req [:snapshot-id]
             :sub       "show"
             :summary   "Gets all Aliases"
             :verb      "get"}
            {:base      :get-available-predefined-checks-using-get
             :command   "available-predefined-checks"
             :param-opt []
             :param-req []
             :sub       "show"
             :summary   "Gets available Predefined checks"
             :verb      "get"}]
           (get-command "show" martian)))))

(deftest explore-test-4
  (let [martian (bootstrap-openapi "FOOBAR" (parse-string (slurp (io/resource "api.json"))))
        ]
    (is (= "Lists all networks"
           (get-description :get-networks-using-get martian)))))

#_(deftest explore-test-5
  (let [martian (create-fwd-context {:target "https://scaling605" :user "forward" :password "forward"})]
    (is (=
          [{:base    :get-device-credentials-using-get
            :command "device-credentials"
            :param   [:network-id]
            :sub     "show"
            :summary "Lists a network’s device credentials"
            :verb    "get"}
           {:base    :get-network-layout-using-get
            :command "network-layout"
            :param   [:network-id]
            :sub     "show"
            :summary "Gets the network layout"
            :verb    "get"}
           {:base    :get-l-3-vpn-using-get
            :command "l-3-vpn"
            :param   [:snapshot-id
                      :l-3-vpn-name]
            :sub     "show"
            :summary "Gets an L3VPN"
            :verb    "get"}
           {:base    :get-device-sources-using-get
            :command "device-sources"
            :param   [:network-id]
            :sub     "show"
            :summary "Gets a network’s device sources"
            :verb    "get"}
           {:base    :get-single-check-using-get
            :command "single-check"
            :param   [:snapshot-id
                      :check-id]
            :sub     "show"
            :summary "Gets a check (with status)"
            :verb    "get"}
           {:base    :get-l-3-vpns-using-get
            :command "l-3-vpns"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Gets a network’s L3VPNs"
            :verb    "get"}
           {:base    :get-device-file-content-using-get
            :command "device-file-content"
            :param   [:snapshot-id
                      :device-name
                      :file-name]
            :sub     "show"
            :summary "Gets device data file content"
            :verb    "get"}
           {:base    :get-networks-using-get
            :command "networks"
            :param   []
            :sub     "show"
            :summary "Lists all networks"
            :verb    "get"}
           {:base    :get-collector-state-using-get
            :command "collector-state"
            :param   [:network-id]
            :sub     "show"
            :summary "Gets the status of a network’s collector"
            :verb    "get"}
           {:base    :get-checks-using-get
            :command "checks"
            :param   [:snapshot-id
                      :type]
            :sub     "show"
            :summary "Gets checks (with status)"
            :verb    "get"}
           {:base    :get-jump-servers-using-get
            :command "jump-servers"
            :param   [:network-id]
            :sub     "show"
            :summary "Lists a network’s jump servers"
            :verb    "get"}
           {:base    :get-latest-processed-snapshot-using-get
            :command "latest-processed-snapshot"
            :param   [:network-id]
            :sub     "show"
            :summary "Returns the latest processed Snapshot"
            :verb    "get"}
           {:base    :list-network-snapshots-using-get
            :command "network-snapshots"
            :param   [:network-id]
            :sub     "show"
            :summary "Lists all Snapshots"
            :verb    "get"}
           {:base    :get-l-2-vpn-using-get
            :command "l-2-vpn"
            :param   [:snapshot-id
                      :l-2-vpn-name]
            :sub     "show"
            :summary "Gets an L2VPN"
            :verb    "get"}
           {:base    :zip-snapshot-using-get
            :command "snapshot"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Exports a Snapshot"
            :verb    "get"}
           {:base    :get-snapshot-metrics-using-get
            :command "snapshot-metrics"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Returns the metrics of a Snapshot"
            :verb    "get"}
           {:base    :get-device-files-using-get
            :command "device-files"
            :param   [:snapshot-id
                      :device-name]
            :sub     "show"
            :summary "Lists a device’s data files"
            :verb    "get"}
           {:base    :get-paths-using-get
            :command "paths"
            :param   [:snapshot-id
                      :src-ip
                      :dst-ip]
            :sub     "show"
            :summary "Searches for paths by tracing packets through the network"
            :verb    "get"}
           {:base    :get-snapshot-topo-overrides-using-get
            :command "snapshot-topo-overrides"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Gets the topology overrides"
            :verb    "get"}
           {:base    :get-single-alias-using-get
            :command "single-alias"
            :param   [:snapshot-id
                      :alias-name]
            :sub     "show"
            :summary "Gets an Alias"
            :verb    "get"}
           {:base    :get-topology-using-get
            :command "topology"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Gets the network topology"
            :verb    "get"}
           {:base    :get-l-2-vpns-using-get
            :command "l-2-vpns"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Gets a network’s L2VPNs"
            :verb    "get"}
           {:base    :get-all-aliases-using-get
            :command "all-aliases"
            :param   [:snapshot-id]
            :sub     "show"
            :summary "Gets all Aliases"
            :verb    "get"}
           {:base    :get-available-predefined-checks-using-get
            :command "available-predefined-checks"
            :param   []
            :sub     "show"
            :summary "Gets available Predefined checks"
            :verb    "get"}]
          (get-command "show" martian)))))

#_(deftest explore-test-6
  (let [api (create-fwd-context {:target "https://scaling605:8443" :user "forward" :password "forward"})]
    (is (= [{:base    :get-device-credentials-using-get
             :command "device-credentials"
             :sub     "show"
             :verb    "get"}
            {:base    :create-device-credential-using-post
             :command "device-credential"
             :sub     "post"
             :verb    "post"}
            {:base    :delete-device-credential-using-delete
             :command "device-credential"
             :sub     "delete"
             :verb    "delete"}
            {:base    :patch-device-credential-using-patch
             :command "device-credential"
             :sub     "update"
             :verb    "patch"}
            {:base    :collect-using-post
             :command "post"
             :sub     "post"
             :verb    "post"}
            {:base    :get-network-layout-using-get
             :command "network-layout"
             :sub     "show"
             :verb    "get"}
            {:base    :set-network-layout-using-post
             :command "network-layout"
             :sub     "post"
             :verb    "post"}
            {:base    :get-l-3-vpn-using-get
             :command "l-3-vpn"
             :sub     "show"
             :verb    "get"}
            {:base    :put-l-3-vpn-using-put
             :command "l-3-vpn"
             :sub     "put"
             :verb    "put"}
            {:base    :delete-l-3-vpn-using-delete
             :command "l-3-vpn"
             :sub     "delete"
             :verb    "delete"}
            {:base    :patch-l-3-vpn-using-patch
             :command "l-3-vpn"
             :sub     "update"
             :verb    "patch"}
            {:base    :delete-l-2-vpn-connection-using-delete
             :command "l-2-vpn-connection"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-device-sources-using-get
             :command "device-sources"
             :sub     "show"
             :verb    "get"}
            {:base    :add-or-update-device-sources-using-post
             :command "or-update-device-sources"
             :sub     "post"
             :verb    "post"}
            {:base    :cancel-collect-using-post
             :command "collect"
             :sub     "post"
             :verb    "post"}
            {:base    :get-single-check-using-get
             :command "single-check"
             :sub     "show"
             :verb    "get"}
            {:base    :deactivate-check-using-delete
             :command "check"
             :sub     "delete"
             :verb    "delete"}
            {:base    :add-l-2-vpn-connection-using-post
             :command "l-2-vpn-connection"
             :sub     "post"
             :verb    "post"}
            {:base    :delete-network-using-delete
             :command "network"
             :sub     "delete"
             :verb    "delete"}
            {:base    :update-network-using-patch
             :command "network"
             :sub     "update"
             :verb    "patch"}
            {:base    :get-l-3-vpns-using-get
             :command "l-3-vpns"
             :sub     "show"
             :verb    "get"}
            {:base    :put-l-3-vpns-using-put
             :command "l-3-vpns"
             :sub     "put"
             :verb    "put"}
            {:base    :get-device-file-content-using-get
             :command "device-file-content"
             :sub     "show"
             :verb    "get"}
            {:base    :get-networks-using-get
             :command "networks"
             :sub     "show"
             :verb    "get"}
            {:base    :create-network-using-post
             :command "network"
             :sub     "post"
             :verb    "post"}
            {:base    :update-device-source-using-put
             :command "device-source"
             :sub     "put"
             :verb    "put"}
            {:base    :delete-device-source-using-delete
             :command "device-source"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-collector-state-using-get
             :command "collector-state"
             :sub     "show"
             :verb    "get"}
            {:base    :get-checks-using-get
             :command "checks"
             :sub     "show"
             :verb    "get"}
            {:base    :add-check-using-post
             :command "check"
             :sub     "post"
             :verb    "post"}
            {:base    :deactivate-checks-using-delete
             :command "checks"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-jump-servers-using-get
             :command "jump-servers"
             :sub     "show"
             :verb    "get"}
            {:base    :create-jump-server-using-post
             :command "jump-server"
             :sub     "post"
             :verb    "post"}
            {:base    :get-latest-processed-snapshot-using-get
             :command "latest-processed-snapshot"
             :sub     "show"
             :verb    "get"}
            {:base    :list-network-snapshots-using-get
             :command "network-snapshots"
             :sub     "show"
             :verb    "get"}
            {:base    :create-snapshot-using-post
             :command "snapshot"
             :sub     "post"
             :verb    "post"}
            {:base    :get-l-2-vpn-using-get
             :command "l-2-vpn"
             :sub     "show"
             :verb    "get"}
            {:base    :put-l-2-vpn-using-put
             :command "l-2-vpn"
             :sub     "put"
             :verb    "put"}
            {:base    :delete-l-2-vpn-using-delete
             :command "l-2-vpn"
             :sub     "delete"
             :verb    "delete"}
            {:base    :patch-l-2-vpn-using-patch
             :command "l-2-vpn"
             :sub     "update"
             :verb    "patch"}
            {:base    :delete-l-3-vpn-edge-port-using-delete
             :command "l-3-vpn-edge-port"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-paths-bulk-using-post
             :command "paths-bulk"
             :sub     "post"
             :verb    "post"}
            {:base    :zip-snapshot-using-get
             :command "snapshot"
             :sub     "show"
             :verb    "get"}
            {:base    :delete-snapshot-using-delete
             :command "snapshot"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-snapshot-metrics-using-get
             :command "snapshot-metrics"
             :sub     "show"
             :verb    "get"}
            {:base    :get-device-files-using-get
             :command "device-files"
             :sub     "show"
             :verb    "get"}
            {:base    :get-paths-using-get
             :command "paths"
             :sub     "show"
             :verb    "get"}
            {:base    :set-network-topo-list-using-put
             :command "network-topo-list"
             :sub     "put"
             :verb    "put"}
            {:base    :run-nqe-query-using-post
             :command "nqe-query"
             :sub     "post"
             :verb    "post"}
            {:base    :get-snapshot-topo-overrides-using-get
             :command "snapshot-topo-overrides"
             :sub     "show"
             :verb    "get"}
            {:base    :post-snapshot-topo-overrides-using-post
             :command "snapshot-topo-overrides"
             :sub     "post"
             :verb    "post"}
            {:base    :put-snapshot-topo-overrides-using-put
             :command "snapshot-topo-overrides"
             :sub     "put"
             :verb    "put"}
            {:base    :get-trace-paths-bulk-seq-using-post
             :command "trace-paths-bulk-seq"
             :sub     "post"
             :verb    "post"}
            {:base    :get-single-alias-using-get
             :command "single-alias"
             :sub     "show"
             :verb    "get"}
            {:base    :create-snapshot-alias-using-put
             :command "snapshot-alias"
             :sub     "put"
             :verb    "put"}
            {:base    :deactivate-alias-using-delete
             :command "alias"
             :sub     "delete"
             :verb    "delete"}
            {:base    :get-topology-using-get
             :command "topology"
             :sub     "show"
             :verb    "get"}
            {:base    :get-l-2-vpns-using-get
             :command "l-2-vpns"
             :sub     "show"
             :verb    "get"}
            {:base    :put-l-2-vpns-using-put
             :command "l-2-vpns"
             :sub     "put"
             :verb    "put"}
            {:base    :get-all-aliases-using-get
             :command "all-aliases"
             :sub     "show"
             :verb    "get"}
            {:base    :get-available-predefined-checks-using-get
             :command "available-predefined-checks"
             :sub     "show"
             :verb    "get"}
            {:base    :delete-jump-server-using-delete
             :command "jump-server"
             :sub     "delete"
             :verb    "delete"}
            {:base    :edit-jump-server-using-patch
             :command "jump-server"
             :sub     "update"
             :verb    "patch"}
            {:base    :add-l-3-vpn-connection-using-post
             :command "l-3-vpn-connection"
             :sub     "post"
             :verb    "post"}]
           (get-commands api)))))


#_(deftest explore-test-7
  (let [api (create-fwd-context {:target "https://scaling605:8443" :user "forward" :password "forward"})]
    (is (= [[:get-device-credentials-using-get
             "Lists a network’s device credentials"]
            [:create-device-credential-using-post
             "Creates or replaces a network device credential"]
            [:delete-device-credential-using-delete
             "Deletes a network device credential"]
            [:patch-device-credential-using-patch
             "Updates a network device credential"]
            [:collect-using-post
             "Triggers a network collection"]
            [:get-network-layout-using-get
             "Gets the network layout"]
            [:set-network-layout-using-post
             "Updates the network layout"]
            [:get-l-3-vpn-using-get
             "Gets an L3VPN"]
            [:put-l-3-vpn-using-put
             "Adds or replaces an L3VPN"]
            [:delete-l-3-vpn-using-delete
             "Removes an L3VPN"]
            [:patch-l-3-vpn-using-patch
             "Updates an L3VPN"]
            [:delete-l-2-vpn-connection-using-delete
             "Removes a connection from an L2VPN"]
            [:get-device-sources-using-get
             "Gets a network’s device sources"]
            [:add-or-update-device-sources-using-post
             "Creates or updates network device sources"]
            [:cancel-collect-using-post
             "Cancels an in-progress network collection"]
            [:get-single-check-using-get
             "Gets a check (with status)"]
            [:deactivate-check-using-delete
             "Deactivates a check"]
            [:add-l-2-vpn-connection-using-post
             "Adds a connection to an L2VPN"]
            [:delete-network-using-delete
             "Deletes a network"]
            [:update-network-using-patch
             "Renames a network"]
            [:get-l-3-vpns-using-get
             "Gets a network’s L3VPNs"]
            [:put-l-3-vpns-using-put
             "Replaces all of a network’s L3VPNs"]
            [:get-device-file-content-using-get
             "Gets device data file content"]
            [:get-networks-using-get
             "Lists all networks"]
            [:create-network-using-post
             "Creates a network"]
            [:update-device-source-using-put
             "Creates or replaces a network device source"]
            [:delete-device-source-using-delete
             "Deletes a network device source"]
            [:get-collector-state-using-get
             "Gets the status of a network’s collector"]
            [:get-checks-using-get
             "Gets checks (with status)"]
            [:add-check-using-post
             "Adds a check"]
            [:deactivate-checks-using-delete
             "Deactivates all checks"]
            [:get-jump-servers-using-get
             "Lists a network’s jump servers"]
            [:create-jump-server-using-post
             "Creates or replaces a jump server"]
            [:get-latest-processed-snapshot-using-get
             "Returns the latest processed Snapshot"]
            [:list-network-snapshots-using-get
             "Lists all Snapshots"]
            [:create-snapshot-using-post
             "Imports a Snapshot"]
            [:get-l-2-vpn-using-get
             "Gets an L2VPN"]
            [:put-l-2-vpn-using-put
             "Adds or replaces an L2VPN"]
            [:delete-l-2-vpn-using-delete
             "Removes an L2VPN"]
            [:patch-l-2-vpn-using-patch
             "Updates an L2VPN"]
            [:delete-l-3-vpn-edge-port-using-delete
             "Removes a connection from an L3VPN"]
            [:get-paths-bulk-using-post
             "Searches for paths by tracing sets of packets through the network"]
            [:zip-snapshot-using-get
             "Exports a Snapshot"]
            [:delete-snapshot-using-delete
             "Deletes a Snapshot"]
            [:get-snapshot-metrics-using-get
             "Returns the metrics of a Snapshot"]
            [:get-device-files-using-get
             "Lists a device’s data files"]
            [:get-paths-using-get
             "Searches for paths by tracing packets through the network"]
            [:set-network-topo-list-using-put
             "Sets the topology overrides"]
            [:run-nqe-query-using-post
             "Runs an NQE query on a Snapshot."]
            [:get-snapshot-topo-overrides-using-get
             "Gets the topology overrides"]
            [:post-snapshot-topo-overrides-using-post
             "Edits the topology overrides"]
            [:put-snapshot-topo-overrides-using-put
             "Sets the topology overrides"]
            [:get-trace-paths-bulk-seq-using-post
             "Searches for paths by tracing sets of packets through the network"]
            [:get-single-alias-using-get
             "Gets an Alias"]
            [:create-snapshot-alias-using-put
             "Creates an Alias"]
            [:deactivate-alias-using-delete
             "Deletes an Alias"]
            [:get-topology-using-get
             "Gets the network topology"]
            [:get-l-2-vpns-using-get
             "Gets a network’s L2VPNs"]
            [:put-l-2-vpns-using-put
             "Replaces all of a network’s L2VPNs"]
            [:get-all-aliases-using-get
             "Gets all Aliases"]
            [:get-available-predefined-checks-using-get
             "Gets available Predefined checks"]
            [:delete-jump-server-using-delete
             "Deletes a jump server"]
            [:edit-jump-server-using-patch
             "Updates a jump server"]
            [:add-l-3-vpn-connection-using-post
             "Adds a connection to an L3VPN"]]
           (explore api)))
    ))

;(deftest get-version-test
;  (is (= []
;         (get-api-version {:swagger "https://scaling605:8443/swagger/api.json"
;                           :user "forward"
;                           :password "forward"}))))

#_(deftest explore-test-8
  (let [api (create-fwd-context {:target "https://scaling605:8443" :user "forward" :password "forward"})]
    (is (= {:as        :text
            :debug     false
            :headers   {"Accept"        "application/json"
                        "Authorization" "Basic:Zm9yd2FyZDpmb3J3YXJk"}
            :insecure? false
            :method    :get
            :url       "https://scaling605:8443/api/snapshots/549/topology"}
           (request-for api :get-topology-using-get {:snapshotId "549"})))))

;(deftest explore-test-9
;  (let [api (create-fwd-context {:swagger "https://scaling605:8443/swagger/api.json" :user "forward" :password "forward"})]
;    (is (= []
;           (response-for api :get-networks-using-get)))))



;(deftest explore-test-10
;  (let [martian (bootstrap-openapi "https://scaling605:8443" (parse-string (slurp (io/resource "api.json"))))]
;    (is (= {:creatorId "100"
;            :id        "129"
;            :name      "Obuscation+"
;            :orgId     "100"}
;           (first (:body (response-for martian :get-networks-using-get)))))))

#_(deftest explore-test-11
  (let [default-interceptors (concat martian/default-interceptors [(add-custom-header "forward" "forward" true true)
                                                                   interceptors/default-encode-body
                                                                   interceptors/default-coerce-response
                                                                   martian-http/perform-request])]
    (is (= "https://foobar:8443"
           (-> (bootstrap-openapi "https://foobar:8443" (parse-string (slurp (io/resource "api.json")))
                              {:interceptors default-interceptors})
               #_:api-root)))))

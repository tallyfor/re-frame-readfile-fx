(defproject tallyfor/re-frame-readfile-fx "2.0.3-SNAPSHOT"
  :description
  "A re-frame effects handler for reading files via FileReader-Object"

  :url
  "https://github.com/jtkDvlp/re-frame-readfile-fx"

  :license
  {:name "MIT"}

  :min-lein-version
  "2.5.3"

  :source-paths
  ["src"]

  :clean-targets
  ^{:protect false}
  [:target-path]

  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  ;; run lein install with LEIN_SNAPSHOTS_IN_RELEASE=true lein install

  :lein-tools-deps/config {:config-files [:install :user :project]}

  :profiles
  {:provided
   {:dependencies
    [[org.clojure/clojure "1.10.1"]
     [org.clojure/clojurescript "1.10.773"]

     [org.clojure/core.async "1.3.610"]

     [re-frame "1.1.1"]
     [clj-stacktrace "0.2.8"]
     [binaryage/devtools "0.9.10"]
     [org.clojure/tools.namespace "1.1.0"]]}

   :dev
   {:source-paths
    ["src" "test"]
  ;; Change your environment variables (maybe editing .zshrc or .bashrc) to have:
  ;; export LEIN_USERNAME="pdelfino"
  ;; export LEIN_PASSWORD="your-personal-access-token-the-same-used-on-.npmrc"
  ;; LEIN_PASSWORD should use the same Token used by .npmrc
  ;; Also, do "LEIN_SNAPSHOTS_IN_RELEASE=true lein install" or edit your .zshrc:
  ;; export LEIN_SNAPSHOTS_IN_RELEASE=true
  :repositories {"releases"  {:url           "https://maven.pkg.github.com/tallyfor/*"
                              :username      :env/LEIN_USERNAME ;; change your env
                              :password      :env/LEIN_PASSWORD}}

  :pom-addition [:distribution-management [:repository [:id "github"]
                                           [:name "GitHub Packages"]
                                           [:url "https://maven.pkg.github.com/tallyfor/re-frame-readfile-fx"]]]

    :target-path
    "target/dev"

    :resource-paths
    ["resources" "target/dev"]

    :dependencies
    [[com.bhauman/figwheel-main "0.2.11"]
     [cider/piggieback "0.4.0"]]

    :repl-options
    {:nrepl-middleware
     [cider.piggieback/wrap-cljs-repl]}}})

(ns lambda-cd.steps
  (:require [lambdacd.steps.shell :as shell]
            [lambdacd.steps.git :as git]))

(def repo-uri "https://github.com/noiter/lambdacd")
(def repo-branch "master")

(defn wait-for-repo [args ctx]
  (git/wait-for-git ctx repo-uri repo-branch))

(defn with-repo [& steps]
  (git/with-git repo-uri steps))

(defn run-some-tests [args ctx]
  (shell/bash ctx (:cwd args) "./go test-clj"))

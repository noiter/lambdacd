(ns lambda-cd.pipeline
  (:use [lambdacd.steps.control-flow]
        [lambda-cd.steps])
  (:require
        [lambdacd.steps.manualtrigger :as manualtrigger]))

(def pipeline-def
  `(
     (either
       manualtrigger/wait-for-manual-trigger
       wait-for-repo)
     (with-repo
       run-some-tests)))

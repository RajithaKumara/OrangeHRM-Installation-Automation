#!/bin/bash

pathToArtifacts=build/dist/travis/$TRAVIS_BUILD_NUMBER/$TRAVIS_JOB_NUMBER
mkdir -p $pathToArtifacts

# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" -X
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" >>  $pathToArtifacts/buildLog.txt

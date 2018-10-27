#!/bin/bash

# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" -X
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless"

pathToArtifacts=build/dist/travis/$TRAVIS_BUILD_NUMBER/$TRAVIS_JOB_NUMBER
mkdir -p $pathToArtifacts
cp screenshot_orangehrm.png $pathToArtifacts
echo "$TRAVIS_JOB_WEB_URL" | tee $pathToArtifacts/buildResults.txt

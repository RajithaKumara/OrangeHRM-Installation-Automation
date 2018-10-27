#!/bin/bash

# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" -X
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless"

mkdir -p build/dist/travis/$TRAVIS_JOB_NUMBER
cp screenshot_orangehrm.png build/dist/travis/$TRAVIS_JOB_NUMBER

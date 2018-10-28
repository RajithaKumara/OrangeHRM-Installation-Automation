#!/bin/bash

mkdir -p $PATH_TO_ARTIFACTS

# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" -X
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" >>  $PATH_TO_ARTIFACTS/buildLog.txt

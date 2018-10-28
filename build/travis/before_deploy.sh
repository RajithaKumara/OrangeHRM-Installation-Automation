#!/bin/bash

# cp screenshot_orangehrm.png $PATH_TO_ARTIFACTS
echo -e "\n$TRAVIS_JOB_WEB_URL" | tee -a $PATH_TO_ARTIFACTS/buildResults.txt

#!/bin/bash

echo "Build Fail" | tee $PATH_TO_ARTIFACTS/buildResults.txt
echo $TRAVIS_TEST_RESULT

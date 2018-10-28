#!/bin/bash

echo "Build Success" | tee $PATH_TO_ARTIFACTS/buildResults.txt
echo $TRAVIS_TEST_RESULT

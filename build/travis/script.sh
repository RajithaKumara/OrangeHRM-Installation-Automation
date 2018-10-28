#!/bin/bash

mkdir -p $PATH_TO_ARTIFACTS

# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" -X
# mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" >>  $PATH_TO_ARTIFACTS/buildLog.txt

# `Internal Field Separator` need to split $MYSQL_CONTAINERS string into array
IFS='|';set -f

for dbHost in $MYSQL_CONTAINERS;do

echo "+--------------------------------------------+"
echo "  Test started on $dbHost MySQL container     "
echo "+--------------------------------------------+"

sed -i "s~databaseHostName.*~databaseHostName=$dbHost~g" $PATH_TO_CONFIG
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" >>  $PATH_TO_ARTIFACTS/$dbHost/buildLog.txt
cp screenshot_orangehrm.png $PATH_TO_ARTIFACTS/$dbHost

done

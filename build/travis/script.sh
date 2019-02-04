#!/bin/bash

set -e

# `Internal Field Separator` need to split $MYSQL_CONTAINERS string into array
IFS='|';set -f

for dbHost in $MYSQL_CONTAINERS;do

echo "+--------------------------------------------+"
echo "  Test started on $dbHost MySQL container     "
echo "+--------------------------------------------+"

mkdir -p $PATH_TO_ARTIFACTS/$dbHost
sed -i "s~databaseHostName.*~databaseHostName=$dbHost~g" $PATH_TO_CONFIG

# Run headless testing
mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless" >>  $PATH_TO_ARTIFACTS/$dbHost/buildLog.txt

# Copy testing artifacts
cp $PATH_TO_SCREENSHOT $PATH_TO_ARTIFACTS/$dbHost

# Reset installation
cmd1="cd symfony && php symfony orangehrm:publish-assets && php symfony doctrine:build-model && php symfony cc"
cmd2="cd ../devTools/general && php reset-installation.php"
docker exec -it os_dev_$PHP_CONTAINER sh -c "${cmd1} && ${cmd2}"

done

#!/bin/bash

git clone --single-branch -b $GIT_APP_BRANCH --depth $GIT_DEPTH $GIT_APP_URL $APP_DIR

git clone --single-branch -b $GIT_ENV_BRANCH --depth $GIT_ENV_DEPTH $GIT_ENV_URL $ENV_DIR

sudo chmod 777 -R .
cd $ENV_DIR

expression="s~LOCAL_SRC.*~LOCAL_SRC=$TRAVIS_BUILD_DIR/$APP_DIR~g"
sed "${expression}" .env-dist > .env

docker-compose up -d

sleep 10
cd ..

# Edit Configuration.properties
expression="s~driverPath.*~driverPath=/usr/bin/chromedriver~g; s~pathToInstaller.*~pathToInstaller=http://127.0.0.1/~g; s~databasePassword.*~databasePassword=root~g; s~databaseHostName.*~databaseHostName=mysql55~g; s~databasePort.*~databasePort=3324~g;"
sed "${expression}" configs/Configuration.properties > Configuration.properties
mv Configuration.properties configs

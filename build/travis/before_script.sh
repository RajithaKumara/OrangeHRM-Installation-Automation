#!/bin/bash

git clone --single-branch -b $GIT_APP_BRANCH --depth $GIT_DEPTH $GIT_APP_URL $APP_DIR

git clone --single-branch -b $GIT_ENV_BRANCH --depth $GIT_ENV_DEPTH $GIT_ENV_URL $ENV_DIR

sudo chmod 777 -R .
cd $ENV_DIR

expression="s~LOCAL_SRC.*~LOCAL_SRC=$TRAVIS_BUILD_DIR/$APP_DIR~g"
echo "${expression}"
sed "${expression}" .env-dist > .env
cat .env

docker-compose up -d
docker ps

sleep 10
cd ..

echo "127.0.0.1    php56 php70 php71 php72" | sudo tee -a /etc/hosts
cat /etc/hosts

# Edit Configuration.properties
expression="s~driverPath.*~driverPath=/usr/bin/chromedriver~g; s~pathToInstaller.*~pathToInstaller=http://php56/~g; s~databasePassword.*~databasePassword=root~g; s~databaseHostName.*~databaseHostName=mysql55~g; s~databasePort.*~databasePort=3324~g;"
echo "${expression}"
sed "${expression}" configs/Configuration.properties > Configuration.properties
cat Configuration.properties
mv Configuration.properties configs

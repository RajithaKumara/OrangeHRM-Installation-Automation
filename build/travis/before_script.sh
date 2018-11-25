#!/bin/bash

set -e

# Clone orangehrm open source git repository
git clone --single-branch -b $GIT_APP_BRANCH --depth $GIT_DEPTH $GIT_APP_URL $APP_DIR

# Clone open source deveopment environment repository
git clone --single-branch -b $GIT_ENV_BRANCH --depth $GIT_ENV_DEPTH $GIT_ENV_URL $ENV_DIR

# Give full permissions to cloned directories
sudo chmod 777 -R .

# Copy composer.phar to project directory
cp composer.phar $APP_DIR
sudo chmod 777 $APP_DIR/composer.phar

# Modify .env and start docker development environment
cd $ENV_DIR
expression="s~LOCAL_SRC.*~LOCAL_SRC=$TRAVIS_BUILD_DIR/$APP_DIR~g"
sed "${expression}" .env-dist > .env

docker pull samanthajayasinghe/php-dev-env-nginx
docker pull samanthajayasinghe/php-dev-env-php56
docker pull samanthajayasinghe/php-dev-env-php70
docker pull samanthajayasinghe/php-dev-env-php71
docker pull samanthajayasinghe/php-dev-env-php72
docker pull mysql:5.7
docker pull mysql:5.6
docker pull mysql:5.5
docker pull mariadb:5.5
docker pull mariadb:10.0
docker pull mariadb:10.1
docker pull mariadb:10.2
docker pull mariadb:10.3
docker pull phpmyadmin/phpmyadmin

docker-compose up -d

cmd1="php composer.phar install -d symfony/lib && php composer.phar dump-autoload -o -d symfony/lib"
cmd2="cd symfony && php symfony orangehrm:publish-assets && php symfony cc"

docker exec -it os_dev_$PHP_CONTAINER sh -c "${cmd1} && ${cmd2}"
cd ..

# Edit hosts file
echo -e "\n127.0.0.1 php56 php70 php71 php72" | sudo tee -a /etc/hosts

# Edit Configuration.properties
sed -i "s~driverPath.*~driverPath=/usr/bin/chromedriver~g" $PATH_TO_CONFIG
sed -i "s~pathToInstaller.*~pathToInstaller=http://$PHP_CONTAINER/~g" $PATH_TO_CONFIG
sed -i "s~databasePassword.*~databasePassword=$MYSQL_ROOT_PASSWORD~g" $PATH_TO_CONFIG
sed -i "s~whindowMaximize.*~whindowMaximize=false~g" $PATH_TO_CONFIG

#!/bin/bash

docker exec -it os_dev_$PHP_CONTAINER sh -c "cd devTools/general && php reset-installation.php"

# OrangeHRM OS -Installation-Automation



## Introduction
This project facilitates to run orangehrm automation suite.

## Technology stack
 * Java
 * Maven
 * Chrome driver
 
 ## Set up OrangeHRM Open Source Web Environment 
 * Download at https://sourceforge.net/projects/orangehrm/
 * Set up Web server 
  
  
## How to set up the automation environment in Ubuntu
 * Clone the project 
  ```bash
  git clone git@github.com:yashikajayasinghe/OrangeHRM-Installation-Automation.git
  ```
  * Install java 
  ```bash
  sudo apt-get install default-jdk 
  ```
  * Install chrome driver 
  ```bash
  // get latest chrome driver
  
  wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
  
  //unzip the file
  
  unzip chromedriver_linux64.zip
  
  // make executable
  
  sudo mv chromedriver /usr/bin/chromedriver
  sudo chown root:root /usr/bin/chromedriver
  sudo chmod +x /usr/bin/chromedriver
  ```
  * Build the project
  ```bash
  mvn install
  ```

  * Change config file
  
  Edit {project-root}/configs/Configuration.properties
  ```java
whindowMaximize=true
driverPath=/usr/bin/chromedriver
implicitlyWait=10
pathToInstaller=http://orangehrm71
databasePort=3306
databaseName=orangehrm_mysqlHLess
databaseUsername=root
databasePassword=root
databaseSameDatabaseUser=true
organizationName=PepperCorn Inc
organizationCountry=LK
organizationLanguage=en_US
organizationTimeZone=Asia/Colombo
adminFirstName=Nicole
adminLastName=Kanneh
adminEmail=nic.kan@peppercorn.com
adminContact=022222222
adminUsername=nicolekan
adminPassword=Welin234_@tax
saveScreenShotPath=screenshot_orangehrm.png

  ```
  * Run Automation
  ```bash
  mvn exec:java -D"exec.mainClass"="orangeHrm.RunHeadless"
  ``` 
##  Reset the environment
 * Delete the database
 ```sql
 DROP DATABASE {databaseName};
 ```
 * Delete the following files
 1. {project-root}/lib/confs/Conf.php
 2. {project-root}/symfony/cache/*
 3. {project-root}symfony/config/databases.yml
  

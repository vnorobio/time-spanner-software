# Time spanner software
The following technologies were used in this project:
* Spring Boot 
  * Web 
  * JPA 
  * Actuator
* Liquibase 
* PostgreSQL

## Pre Installation
To have installed Java 8 in the testing machine here I add the installation links

## Windows

#### * Install JDK 8
Please download the one that does not use demos and samples

https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

#### * Create environment variables
Please follow the steps

https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=389:configurar-java-en-windows-variables-de-entorno-javahome-y-path-cu00610b&catid=68&Itemid=188


##Linux/MAC

#### * Install JDK 8
Please download the one that does not use demos and samples

https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

#### * Create environment variables
Please follow the steps

##### - Mac
https://hecthormedina.wordpress.com/2013/10/27/como-configurar-la-variable-de-entorno-java_home-en-mac-os-x-y-no-morir-en-el-intento/

##### - Linux
https://angelsw.wordpress.com/2011/03/29/variable-de-entorno-e-java-en-linux/

## Installation, Execute Project and Test in Intellij IDEA 

You can use the Intellij IDE that performs the auto import of the dependencies of the project and that facilitates the execution of the project by right clicking the MarketplaceApplication.java class and then running.

You can also use the IDE to run the tests in the src / test / java route and each class you can give right click and then run

## Installation Command Line

The project uses gradle to automate the construction of the project, please download the dependencies and then execute the following commands

Windows

```bash
gradlew clean build
``` 
Linux/MAC

```bash
./gradlew clean build
``` 

## Paths

##### Get all Users
##### GET
```bash
/api/catalogs/v1/user/all
```

##### Get user by id
##### GET
```bash
/api/catalogs/v1/user/2
```

##### Add user
##### POST
```bash
/api/catalogs/v1/user
```

##### Example Json Body
```javascript
[
    {
        "id": 1,
        "login": "user2",
        "password": "secret",
        "name": "Other user",
        "email": "other@server.com",
        "active": true
    }
]
 ```


## Health
The health was added to be able to verify the status of the api

##### Check the status of the api
##### GET
```bash
/api/actuator/health
```

## PostMan

It shares the path of the api by postman to generate ease at the time of testing

https://www.getpostman.com/collections/5bf1427269f90deb4062


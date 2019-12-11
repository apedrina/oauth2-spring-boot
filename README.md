# Oauth2 with Springboot

Here you will find an example of an Oauth2 Application using: SpringBoot, MongoDB, Docker, etc.

# How to docker

First of all, we need start up the docker's container, therefore go to the root directory and run:

```bash
docker-compose up -d

```

Inside liquibase's module run:

```bash

mvn clean install
```

Go to the oauth-authorization-server directory and run:

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

Go to the oauth-resource-server directory and run:

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

To get the token-access:

```bash
curl -X POST -i --user userBuildClientIdPassword:secret http://localhost:8081/oauth-server/oauth/token -d 'grant_type=password' -d 'username=tom' -d 'password=111';

```

To insert a building:

```bash
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"coords": [[ 0 ]],"floorHeight": 0, "floors": 0, "height": 0, "name": "string", "ownerId": 0 }' 'http://localhost:8082/oauth-resource/building?access_token=<access_token>'
```

To list all buildings:

```bash
curl -X GET http://localhost:8082/oauth-resource/building/list?access_token=<access_token>

```

To refresh one token:

```bash
curl -X POST -i --user userBuildClientIdPassword:secret http://localhost:8081/oauth-server/oauth/token -d 'grant_type=refresh_token' -d 'username=tom' -d 'password=111' -d 'refresh_token=<refresh_token>';

```

If you get a error on liquibase module run on database:

UPDATE DATABASECHANGELOGLOCK SET LOCKED=FALSE, LOCKGRANTED=null, LOCKEDBY=null where ID=1;

# TLS connection

The application use TLS connection, therefore we'll create a sign-self certificate.

There is two formats:

PKCS12: it's an industry-wide used format
JKS (Java KeyStore): it's a format limited to the Java Environment 

Command to generate our PKCS12 keystore format:

```bash
keytool -genkeypair -alias alissonpedrina -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore pedrina.p12 -validity 3650
```
Bellow the properties configurations to ssl in application-dev.yml file:

```yml
security:
  require-ssl: true
server:
  port: 8081
  servlet:
    context-path: /oauth-server
  ssl:
    key-alias: alisson
    key-store: classpath:keystore/pedrina.p12
    key-store-password: 123456
    key-store-type: PKCS12
```







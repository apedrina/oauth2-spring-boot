FROM adoptopenjdk/openjdk11 AS liquibaseapp

WORKDIR /app

COPY target/liquibaseapp.jar /app

ENTRYPOINT ["java", "-jar", "liquibaseapp.jar"]


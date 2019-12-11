FROM adoptopenjdk/openjdk11

WORKDIR /app

COPY target/authorization-server.jar /app

EXPOSE 8081:8081

ENTRYPOINT ["java","-Dspring.profiles.active=dev", "-jar", "authorization-server.jar"]


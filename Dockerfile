#
## Stage 1 : Build
#
FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn

# Resolve dependencies (pre-fetches dependencies to improve build speed)
RUN ./mvnw dependency:resolve
COPY src src
RUN ./mvnw package

#
## Stage 2 : Package and Run
#
FROM openjdk:17-alpine
ENV TZ Asia/Riyadh
COPY --from=build /target/*SNAPSHOT.jar opt/vrc-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/opt/vrc-0.0.1-SNAPSHOT.jar"]
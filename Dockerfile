FROM openjdk:8-jdk-alpine
MAINTAINER breno
COPY target/deteccaoqueda-0.0.1-SNAPSHOT.jar deteccaoqueda-1.0.0.jar
ENTRYPOINT ["java","-jar","/deteccaoqueda-1.0.0.jar"]
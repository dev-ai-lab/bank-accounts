#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim as build

#Information around who maintains the image
MAINTAINER bank.com

# Add the application's jar to the container
COPY target/bank-account-0.0.1-SNAPSHOT.jar bank-account-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/bank-account-0.0.1-SNAPSHOT.jar"]
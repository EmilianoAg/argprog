FROM amazoncorretto:17-alpine-jdk
MAINTAINER emilianoag
COPY target/ap.jar ap.jar
ENTRYPOINT ["java","-jar","/ap.jar"]
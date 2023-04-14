FROM alpine:latest
MAINTAINER maria
COPY target/backend-0.0.1-SNAPSHOT.jar portfolio-backend.jar
ENTRYPOINT ["java", "-jar", "/portfolio-backend.jar"]

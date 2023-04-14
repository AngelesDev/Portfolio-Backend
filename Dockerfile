FROM amazoncorretto:11-alpine-jdk
MAINTAINER Maria
COPY target/backend-0.0.1-SNAPSHOT.jar portfolio-backend.jar
ENTRYPOINT ["java", "-jar", "/portfolio-backend.jar"]
EXPOSE 8080
CMD ["/bin/sh"]
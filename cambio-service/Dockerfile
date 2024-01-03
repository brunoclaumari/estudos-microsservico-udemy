FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
ARG JAR_FILE=cambio-service/target/*.jar
COPY ${JAR_FILE} cambio_service.jar
RUN bash -c 'touch /cambio_service.jar'
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/cambio_service.jar"]
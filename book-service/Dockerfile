FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
ARG JAR_FILE=book-service/target/*.jar
COPY ${JAR_FILE} book_service.jar
RUN bash -c 'touch /book_service.jar'
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/book_service.jar"]
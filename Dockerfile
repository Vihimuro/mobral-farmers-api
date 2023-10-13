FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/mobralAPI-0.0.1-SNAPSHOT.jar
ADD target/mobralAPI-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
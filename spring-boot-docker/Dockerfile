FROM openjdk:8-jre-alpine

ADD ./target/spring-boot-docker-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
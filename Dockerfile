FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} card-service.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/card-service.jar"]

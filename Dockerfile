FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} card-service-v1.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/card-service-v1.jar"]

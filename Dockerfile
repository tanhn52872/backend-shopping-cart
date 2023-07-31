#Start with a base image
FROM openjdk:11


#VOLUME /tmp
#
##Add the application's jar to the container
#ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
#
#COPY target/*.jar /backend-shopping-cart/demo-0.0.1-SNAPSHOT.jar
##COPY ${JAR_FIE} pring_basic-2.7.5.jar
#
##execute the application
#ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
#####################33



FROM maven:3.8.6-jdk-11-slim AS build

FROM openjdk:11

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]




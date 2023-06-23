#Start with a base image
FROM openjdk:11


VOLUME /tmp

#Add the application's jar to the container
ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

COPY target/*.jar /backend-shopping-cart/demo-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FIE} pring_basic-2.7.5.jar

#execute the application
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
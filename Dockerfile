FROM openjdk:11
VOLUME /tmp
ADD ./target/resource-0.0.1-SNAPSHOT.jar resource.jar
ENTRYPOINT ["java", "-jar","/resource.jar"]
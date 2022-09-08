FROM maven:3.8.6-amazoncorretto-17

COPY target/apiRestChallenge-0.0.1-SNAPSHOT.jar apiRestChallenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/apiRestChallenge-0.0.1-SNAPSHOT.jar"]
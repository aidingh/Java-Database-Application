FROM openjdk:17
ADD target/Java-Database-Project-0.0.1-SNAPSHOT.jar jdp.jar
ENTRYPOINT ["java","-jar","jdp.jar"]

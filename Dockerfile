FROM openjdk:17
ADD target/Java-Database-Project-0.0.1-SNAPSHOT.jar Java-Database-Project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Java-Database-Project-0.0.1-SNAPSHOT.jar"]
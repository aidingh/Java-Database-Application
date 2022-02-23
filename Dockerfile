FROM openjdk:17
ADD target/Java-Database-Project-0.0.1-SNAPSHOT.jar jdp.jar
CMD java -Dserver.port=$PORT $JAVA_OPTS -jar /software/x-x-1.1.1.jar
ENTRYPOINT ["java","-jar","jdp.jar"]
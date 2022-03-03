FROM openjdk:17 AS maven
WORKDIR /app
COPY . .
RUN maven bootJar


FROM openjdk:17 as runtime
WORKDIR /app
ENV PORT 8080
ENV SPRING_PROFILE production
COPY --from=maven target/Java-Database-Project-0.0.1-SNAPSHOT.jar /app/app.jar
RUN chown -R 1000:1000 /app
USER 1000:1000
ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "app.jar"]
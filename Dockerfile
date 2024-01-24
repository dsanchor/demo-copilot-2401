# Start with a base image containing Java runtime (OpenJDK 17)
FROM openjdk:17-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the application's jar to the container
COPY target/*.jar /app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
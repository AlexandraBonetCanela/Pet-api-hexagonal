# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar into the container
COPY target/*.jar app.jar

# Expose the port the Spring Boot app runs on
EXPOSE 8080

LABEL authors="Alexandra Bonet"

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
# Use a lightweight Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/SmartFarm.jar app.jar

# Expose port (Render sets a dynamic port, we will bind to it later)
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "app.jar"]

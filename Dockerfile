# Use a base image with Java pre-installed
FROM openjdk:17-oracle

# Set a working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
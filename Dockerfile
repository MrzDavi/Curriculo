FROM ubuntu:latest AS build

# Update the package list and install JDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Install Maven
RUN apt-get install -y maven

# Set the working directory for the project files
WORKDIR /app

# Copy the project files into the container
COPY . .

# Clean the project and build it using Maven, skipping tests
RUN mvn clean install -DskipTests

# Run Stage: Use a slimmer JDK 17 image for the runtime environment
FROM openjdk:17-jdk-slim

# Expose port 8080 for the application
EXPOSE 8080

# Copy the built JAR file from the build stage to the runtime stage
# Note: Change 'target/demo-0.0.1-SNAPSHOT.jar' to your actual JAR file path if it differs
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to start the application
ENTRYPOINT ["java", "-jar", "app.jar"]

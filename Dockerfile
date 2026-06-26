# Step 1: Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre-jammy

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the compiled JAR file from your target folder into the container
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose port 8080 to the outside world
EXPOSE 8080

# Step 5: Command to execute the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
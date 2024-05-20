FROM amazoncorretto:17.0.7-alpine

WORKDIR /app
# Working directory for the application

# Use an argument to specify the location of the JAR file (more flexible)
ARG JAR_FILE=./build/libs/Monolith-0.0.1-SNAPSHOT.jar

# Copy the JAR file from the build location to the working directory in the image
COPY $JAR_FILE app.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
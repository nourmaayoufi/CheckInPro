# Stage 1: Build the Angular frontend
FROM node:16 As frontend-build
WORKDIR /app
COPY chekin/ .
RUN npm install
RUN npm run build

# Stage 2: Build the Spring Boot backend
FROM maven:3.9.0-eclipse-temurin-17 As backend-build
WORKDIR /app
COPY edu.iset.atelierspringboot/ .
RUN mvn clean package

# Stage 3: Create the final image
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the Spring Boot JAR from the backend build stage
COPY --from=backend-build /app/target/edu.iset.atelierspringboot-0.0.1-SNAPSHOT.jar app.jar
# Copy the Angular frontend build files
COPY --from=frontend-build /app/dist/chekin /app/public
# Expose the port for the backend application
EXPOSE 8080
# Run the backend Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

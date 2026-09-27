FROM maven:latest
WORKDIR /app
COPY pom.xml .
COPY . /app
RUN mvn package
CMD ["java", "-jar", "Docker/target/Docker-1.0-SHAPSHOT.jar"]
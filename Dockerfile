
FROM maven:3.8-openjdk-17 AS build


WORKDIR /app


COPY pom.xml .


RUN mvn dependency:go-offline


COPY src /app/src


RUN mvn clean package -DskipTests -X


FROM openjdk:17-slim


WORKDIR /app


COPY --from=build /app/target/*.jar app.jar


EXPOSE 8081


CMD ["java", "-jar", "app.jar"]

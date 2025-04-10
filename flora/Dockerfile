FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY valoresJeF/pom.xml .
COPY valoresJeF/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
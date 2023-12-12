# build stage
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /usr/src/app

COPY . .

RUN ./mvnw clean package

EXPOSE 8080
CMD [ "java", "-jar", "target/customers_services_api-0.0.1-SNAPSHOT.jar" ]
# Product Stock Service API

- API with products CRUD and store stock control;

- It was made with Java and Spring.

## Executing (with Docker)

### 0. Running MySQL with Docker

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=docker-d mysql:latest
```

### 1. Building the API image

```sh
docker build -t product-stock-service-api .
```

### 2. Running container

```sh
docker run -d --port "8080:8080" --name product-stock-service-api product-stock-service-api
```

## Technologies

- Java
- Spring
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)
- MySQL
- Lombok
- Dockerfile

## API Docs

### SpringDoc API (Swagger)

- You only have to access the endpoint/path below to access the API documentation through Swagger.

- If you are executing all services together with docker-compose, use http://localhost:8001. However, if you are executing only this service, use http://localhost:8080.

```sh
http://localhost:8001/swagger-ui/index.html#/

# ou

http://localhost:8080/swagger-ui/index.html#/
```

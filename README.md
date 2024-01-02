# Store Software With SOA

- A SOA (Services Oriented Archtecture) made using RESTful APIs and API Gateway design pattern;

- The archtecture is made with 3 services:
  - consumers-service-api;
  - product-stock-service-api;
  - sells-service-api;

## Architecture

![Arquitetura](./.github/soa-architecture-picture.jpg)

## Installing project

### 1. Cloning

```sh
git clone git@github.com:matheusdoedev/todo-list-manager-api.git
```

## Running system

### 0. Docker e Docker Compose

- You need to download and install docker and docker compose in order to run the system.

### 1. Running

```sh
cd codigo fonte

docker-compose -d --build up
```

## Documentation

### API Gateway Endpoints

#### Insomnia

- Download Insominia and import [api-gateway.json](./codigo-fonte/api-gateway/api-gateway.json).

### APIs (Services)

- [API Gateway](./codigo-fonte/api-gateway/README.md)
- [consumers-service-apicodigo-fonte/customers-service-api/README.md)
- [product-stock-service-api](./codigo-fonte/product-stock-service-api/README.md)
- [sells-service-api](./codigo-fonte/sells-service-api/README.md)

## Technologies

- Java
- Spring framework
- Spring MVC
- Spring Data JPA
- SpringDoc/Swagger
- MySQL
- Node.js
- Express
- Sequelize
- Axios
- Dockerfile
- Docker Compose

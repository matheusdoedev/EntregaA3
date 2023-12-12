# Customers Service API

- API com o CRUD de consumidores;

- Foi desenvolvido em Java com o Spring framework e o MySQL;

## Instalando o projeto

### 1. Clonando o projeto

```sh
git clone git@github.com:matheusdoedev/todo-list-manager-api.git
```

## Executando o projeto (com o Docker)

### 0. Instalação do Docker

- É preciso instalar o Docker na máquina antes de prosseguir com os próximos passos.

### 1. Iniciando o MySQL com o Docker

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=docker-d mysql:latest
```

### 2. Buildando a imagem do projeto

```sh
docker build -t customers-service-api .
```

### 3. Subindo o container

```sh
docker run -d --port "8080:8080" --name customers-service-api customers-service-api
```

## Tecnologias utilizadas

- Java
- Spring
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)
- MySQL
- Lombok
- Dockerfile

## Documentação da API

### SpringDoc API (Swagger)

- Basta acessar o endpoint/path abaixo para acessar a documentação via Swagger que está configurado no projeto.

```sh
/swagger-ui/index.html#/
```

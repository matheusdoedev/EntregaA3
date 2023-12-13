# Entrega A3

- Um SOA (Arquitetura Orientada a Serviços) desenvolvida utilizando APIs e o padrão REST com o protocolo HTTP para a comunicação entre os serviços;

- Também foi implementado o design pattern API Gateway com Node.js com a ideia de rotear o acesso do cliente aos serviços que compoem o SOA;

- A arquitetura é composta de quatro serviços (fora o API Gateway). São eles:

  - Serviço de clientes (consumers-service-api);
  - Serviço de estoque (product-stock-service-api);
  - Serviço de vendas/transacional (sells-service-api);
  - Serviço de analytics/relátorios (analytics-service-api);

- Os frameworks Spring (Java) e Express (Node.js) foram utilizados no desenvolvimento dos serviços. O critério na escolha das tecnologias foi de acordo com o que era mais confortável aos desenvolvedores, já que o conceito de SOA é agnóstico ao tipo de plataforma/tecnologia que está sendo utilizado no desenvolvimento;

- Um ponto a se destacar é que a utilização de mais de uma tecnologia no desenvolvimento dos diferentes serviços mostra a heterogeneidade em um Sistema Distribuído;

- Por fim, esse trabalho foi feito como um entregavél da avaliação A3 da cadeira de Sistemas Distríbuidos.

## Arquitetura

## Instalando projeto

## Executando o sistema

## Documentação

### Endpoints da API Gateway

#### Insomnia

- Basta instalar o Insomnia e importar o arquivo [api-gateway.json](./codigo-fonte/api-gateway/api-gateway.json).

### APIs (Serviços)

- [API Gateway](./codigo-fonte/api-gateway/README.md)
- [Serviço de clientes (consumers-service-api)](./codigo-fonte/customers-service-api/README.md)
- [Serviço de estoque (product-stock-service-api)](./codigo-fonte/product-stock-service-api/README.md)
- [Serviço de vendas/transacional (sells-service-api)](./codigo-fonte/sells-service-api/README.md)

## Tecnologias utilizadas

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

# ApiSigaBem
## Projeto Api Rest em Java <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40"/>

## IDE usada Intellij IDEA

## JAVA 11

## Spring Boot

## Banco de dados H2

## Swagger

O projeto usa banco de dados H2 que é inicializado em memoria
a consulta de todos os registros na tabela podem ser feitas via browser em *http://localhost:8080/Api*

Para realizar cálculo de frete e persistencia no banco deve-se especificar peso,cepOrigem,cepDestino, nome destinatario
**http://localhost:8080/Api/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}**

Para documentaçao via Swagger **http://localhost:8080/swagger-ui.html#/**


Aceeso ao BD **http://localhost:8080/h2-console/**

JDBC URL: **jdbc:h2:mem:testdb**

User Name: **api**

Password: sem senha **(deixe em branco)**

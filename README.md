# ApiSigaBem
###Projeto Api Rest em Java
###IDE usada Intellij IDEA
###JAVA 11
###Spring Boot
###Banco de dados H2
###Swagger

O projeto usa banco de dados H2 que é inicializado em memoria
a consulta de todos os registros na tabela podem ser feitas via browser em *http://localhost:8080/Api*

Para realizar cálculo de frete e persistencia no banco deve-se especificar peso,cepOrigem,cepDestino, nome destinatario
**http://localhost:8080/Api/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}**

Para documentaçao via Swagger **http://localhost:8080/swagger-ui.html#/**

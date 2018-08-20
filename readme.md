# REST API - Gerenciador de Pedidos 

Exemplo de API RESTful de gerenciamento de pedidos desenvolvida usando Spring Framework, Spring MVC e Spring Boot.

Embora esse sistema de gerenciamento seja simples comparado aos serviços RESTful de grande escala, ele demonstrará o processo de pensamento básico, 
as decisões de design e alguns testes de implementação necessários para criar um serviço RESTfull.

O sistema foi desenvolvido usando a técnica Test Driven Development (TDD). 
Isso resultou em um conjunto simples de classes e em um conjunto de componentes mais facilmente distinguíveis. 

Por exemplo, a lógica de persistência e a lógica de domínio não estão interligadas. 
Para simplificar, foi implementado a persistência em memória.

## REST Endpoints

	GET: http://localhost:8080/pedido -> Recupera a lista de todos os pedidos  -> 200 OK
	GET: http://localhost:8080/pedido/{id} -> Recupera um pedido de acordo com o id -> 200 OK  ou 404 Not Found
	POST: http://localhost:8080/pedido -> Adiciona um pedido de acordo com o payload da requisição -> 201 Created 
	PUT: http://localhost:8080/pedido/{id} -> Atualiza o pedido de acordo com o id e payload passados -> 200 OK ou 404 Not Found
	DELETE: http://localhost:8080/order/{id} ->  Exclui um pedido de acordo com o id passado -> 203 No Content ou 404 Not Found
	
## Referências

	- https://martinfowler.com/articles/richardsonMaturityModel.html
	- https://dzone.com/articles/creating-a-rest-api-with-java-and-spring
	- https://dzone.com/articles/creating-a-rest-web-service-with-java-and-spring-p
	- https://dzone.com/articles/creating-a-rest-web-service-with-java-and-spring-p-1
	- https://dzone.com/articles/creating-a-rest-web-service-with-java-and-spring-p-2

 


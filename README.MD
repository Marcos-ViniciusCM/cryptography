
<h1 align="center">
  cryptography Challenger
</h1>

## Sobre o projeto
É um projeto expirado no desafio criptografia do Back-end Brasil, para mais informaçoes acesse:[Criptografia Teste](https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md)

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MySQL](https://www.mysql.com/)

## Práticas adotadas

- SOLID, YAGNI
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/cryptography-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Usuario 
```
$ http POST :8080/users 
 userDocument="123" creditCardToken="987" value=100

[ ]
```

- Listar Usuarios
```
$ http GET :8080/users

[
  {
  		 "id": 1,
        "userDocument": "123",
        "creditCardToken": "987",
        "value": 100
  }
]
```

- Atualizar Valor do usuarios
```
$ http PUT :8080/users/1 
 id = 1 userDocument="123" creditCardToken="987" value=200

[ ]
```

- Remover Usuario
```
http DELETE :8080/users/1

[ ]
```

## Detalhes do Projeto

- **GroupId**: com.marcos
- **ArtifactId**: cryptography
- **Versão**: 0.0.1-SNAPSHOT

## Requisitos

- Java JDK 21 ou superior
- Maven 3.3.0 ou superior
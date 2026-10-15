# Spring Boot TDD Demo

A small Spring Boot project demonstrating Test-Driven Development using a Product REST API.

## Requirements

- Java 17+
- Maven 3.9+ (or use the Maven wrapper if you add one)
- IDE such as IntelliJ IDEA, Eclipse, or VS Code

## Project structure

src/main/java/com/example/demo/
- controller/ProductController.java
- service/ProductService.java
- repository/ProductRepository.java
- model/Product.java

src/test/java/com/example/demo/
- service/ProductServiceTest.java
- controller/ProductControllerTest.java

## Run tests

```bash
# Using Maven wrapper (recommended - works without global PATH setup):
.\mvnw test

# Or using local shortcut:
.\mvn test

# Or using global maven:
mvn test
```

## Run application

```bash
# Using Maven wrapper:
.\mvnw spring-boot:run

# Or using local shortcut:
.\mvn spring-boot:run

# Or using global maven:
mvn spring-boot:run
```

Then access:

GET http://localhost:8080/products/1

The example focuses on the TDD cycle:
1. Write a failing test.
2. Write the minimum production code.
3. Make the test pass.
4. Refactor.

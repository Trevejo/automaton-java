# Autômato de Validação de CPF

Este é um simples aplicativo Spring Boot que implementa um autômato finito determinístico (AFD) para validar o formato de CPFs.

## Funcionalidades

*   Validação de CPFs nos formatos `XXX.XXX.XXX-XX` e `XXXXXXXXXXX`.
*   Implementação do autômato usando `HashMap` e `enum` para representar estados e transições.
*   Testes unitários abrangentes para garantir a correta validação dos CPFs.

## Pré-requisitos

*   Java 11 ou superior
*   Maven ou Gradle (recomendado usar o Maven/Gradle Wrapper)

## Como executar o aplicativo

1.  Clone o repositório:

    ```bash
    git clone <seu-repositorio>
    ```

2.  Navegue até o diretório do projeto:

    ```bash
    cd <seu-projeto>
    ```

3.  Execute o aplicativo Spring Boot:

    *   **Usando Maven Wrapper:**

        ```bash
        ./mvnw spring-boot:run
        ```

    *   **Usando Gradle Wrapper:**

        ```bash
        ./gradlew bootRun
        ```

## Como executar os testes

Para executar os testes unitários e garantir que o autômato de validação de CPF esteja funcionando corretamente, siga as instruções abaixo:

*   **Usando Maven Wrapper:**

    ```bash
    ./mvnw test
    ```

*   **Usando Gradle Wrapper:**

    ```bash
    ./gradlew test
    ```

    Este comando irá compilar o código, executar os testes unitários e gerar um relatório de resultados.

## Estrutura do código

*   `src/main/java/com/example/automatodoc/CPFAutomaton.java`: Implementação do autômato de validação de CPF.
*   `src/main/java/com/example/automatodoc/AutomatonController.java`: Controller Spring Boot para receber e processar requisições de validação de CPF.
*   `src/test/java/com/example/automatodoc/AutomatodocApplicationTests.java`: Testes unitários para o autômato de validação de CPF.

## Dependências

O projeto utiliza as seguintes dependências principais:

*   `spring-boot-starter-web`: Para construir aplicações web com Spring MVC.
*   `spring-boot-starter-test`: Para testes unitários e de integração.
*   `org.assertj:assertj-core`: Para asserções mais expressivas nos testes.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).

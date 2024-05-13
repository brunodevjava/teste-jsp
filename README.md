# Projeto de Teste - Sinerji Gestão e Sistemas Ltda

Este é um projeto de teste desenvolvido para a empresa Sinerji Gestão e Sistemas Ltda por Bruno Sversutti.

## Descrição do Projeto

O objetivo deste projeto é criar um sistema de cadastro de pessoa e endereço. Ele permite adicionar, editar, excluir e listar pessoas e seus respectivos endereços.

## Funcionalidades

- Cadastro de Pessoa:
  - Inclui informações como nome, e-mail, telefone, CPF, data de nascimento, gênero, estado civil, profissão e RG.
- Cadastro de Endereço:
  - Inclui informações como rua, número, complemento, cidade, estado, pessoa e CEP.
- Operações:
  - Adicionar pessoa e endereço.
  - Editar dados de pessoa e endereço.
  - Excluir pessoa e endereço.
  - Listar todas as pessoas e endereços cadastrados.

## IDE Utilizada

- Eclipse 2024.3

## Tecnologias Utilizadas

- Java versão Java-SE 1.8
- JSF (JavaServer Faces) versão 2.3
- JPA (Java Persistence API)
- Maven versão 3.1
- JUnit versão 4.13.2
- Mockito versão 4.2.0
- PostgreSQL versão 42.2.24
- Hibernate versão 4.3.9
- CDI
- Primefaces versão 13.0.0

## Instruções de Execução

1. Certifique-se de ter o JDK e o Apache Maven instalados.
2. Clone o repositório do projeto.
3. Importe o projeto em sua IDE preferida.
4. Configure um banco de dados PostgreSQL e ajuste as configurações de conexão no arquivo `persistence.xml` dentro de `src/main/resources/META-INF`.
5. Execute `mvn clean install` para baixar as dependências e construir o projeto.
6. Execute o projeto em um servidor de aplicação (por exemplo, Apache Tomcat) configurado em sua IDE.

## Configuração do Banco de Dados e Hibernate

1. Configure um banco de dados PostgreSQL.
2. No arquivo `persistence.xml` dentro de `src/main/resources/META-INF`, ajuste as configurações de conexão para o seu banco de dados.
3. Na primeira execução do projeto, defina a propriedade `hibernate.hbm2ddl.auto` como `create`. Isso fará com que o Hibernate crie as tabelas automaticamente.
4. Após a primeira execução, altere a propriedade `hibernate.hbm2ddl.auto` para `update`. Isso fará com que o Hibernate atualize o banco de dados conforme novas alterações na estrutura das tabelas.

## Execução dos Testes Unitários

Para executar os testes unitários:

1. Navegue até a pasta `src/test/java` do projeto.
2. Entre o package `br.com.sinerji.service.test`.
3. Execute a classe `TestPessoa` e a classe `TestEndereco` utilizando JUnit.
4. Verifique os resultados dos testes no console da sua IDE ou no relatório de testes gerado.

## Contato

Se precisar de ajuda ou tiver alguma dúvida sobre o projeto, entre em contato com Bruno Sversutti em sversuttibruno@gmail.com ou (18) 99684-0820.

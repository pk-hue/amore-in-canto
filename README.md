# Amore in Canto - Reservation & Scheduling API

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
</p>

## Sobre o Projeto

O **Amore in Canto** é uma API robusta de agendamento e reservas, desenvolvida especificamente para automatizar e gerenciar a agenda de apresentações de uma banda musical. O sistema oferece uma interface de comunicação eficiente para lidar com marcações de shows, controle de disponibilidade de datas e gestão de clientes, garantindo que não haja conflitos de agenda e otimizando a organização dos eventos.

## Tecnologias Utilizadas

A API foi construída utilizando as melhores práticas de Engenharia de Software e desenvolvimento Backend:

*   **Linguagem:** Java
*   **Framework:** Spring Boot
*   **Banco de Dados:** PostgreSQL
*   **Gerenciador de Dependências:** Maven (ou Gradle)

## Funcionalidades Principais

*   **Gestão de Reservas:** Criação, consulta, atualização e cancelamento de eventos musicais e apresentações.
*   **Controle de Agenda:** Validação de disponibilidade de datas para evitar *double-booking* (conflitos de horários).
*   **Cadastro de Clientes:** Gerenciamento das informações dos contratantes.
*   **Persistência Segura:** Estruturação relacional eficiente para garantir a integridade dos dados no banco PostgreSQL.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

*   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) (Versão 17 ou superior recomendada)
*   [PostgreSQL](https://www.postgresql.org/download/)
*   [Git](https://git-scm.com/)
*   Sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code, etc.)

## ⚙️ Instalação e Execução

**1. Clone o repositório**
```bash
git clone [https://github.com/seu-usuario/amoerincantox.git](https://github.com/seu-usuario/amoerincantox.git)
cd amoerincantox
```
**2. Configure o Banco de Dados**

No arquivo src/main/resources/application.properties, ajuste as credenciais:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

**3. Execute a aplicação**

```
./mvnw spring-boot:run
```

## 📂 Estrutura do Projeto

*  **controller:** Endpoints REST da API.

*  **service:** Camada de regras de negócio.

*  **repository:** Interfaces de comunicação com o banco de dados.

*  **model:** Entidades mapeadas pelo JPA.

*  **dto:** Padrão Data Transfer Object para segurança e performance.

## Autor
**Pedro Henrique**

**Software Engineering Student & Backend Developer**

**LinkedIn:**
linkedin.com/in/pedro-hue

**GitHub:**
github.com/pk-hue

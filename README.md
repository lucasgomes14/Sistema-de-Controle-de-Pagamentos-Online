# Sistema de Gerenciamento de Clientes e Pagamentos 💳👥

Este projeto é um sistema Spring Boot completo para gerenciamento de clientes e processamento de pagamentos com diferentes estratégias e funcionalidades.

## 📋 Índice

- [Funcionalidades](#-funcionalidades)
- [Arquitetura e Padrões](#-arquitetura-e-padrões-utilizados)
- [Tecnologias e Dependências](#-tecnologias-e-dependências)
- [Requisitos de Ambiente](#-requisitos-de-ambiente)
- [Como Executar](#-passo-a-passo-para-executar-o-projeto)
- [Endpoints da API](#-endpoints-da-api)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Estratégias de Pagamento](#-estratégias-de-pagamento-implementadas)
- [Funcionalidades Decoradoras](#-funcionalidades-decoradoras)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Próximas Melhorias](#-próximos-passosmelhorias-possíveis)

## ✨ Funcionalidades

### 👥 Gestão de Clientes
- ✅ Cadastro de clientes
- ✅ Listagem de todos os clientes
- ✅ Busca de cliente específico por ID
- ✅ Atualização de dados do cliente
- ✅ Exclusão de cliente
- ✅ Consulta de pagamentos de um cliente específico

### 💳 Processamento de Pagamentos
- ✅ Processamento de pagamentos com diferentes métodos (Cartão, PIX, Boleto)
- ✅ Listagem de todos os pagamentos
- ✅ Busca de pagamento específico por ID
- ✅ Sistema de estratégias para cálculo de valores finais
- ✅ Sistema de decoradores para funcionalidades adicionais
- ✅ Notificação por e-mail após pagamento

## 🏗️ Arquitetura e Padrões Utilizados

- **Strategy Pattern**: Para diferentes cálculos de valores finais baseados no método de pagamento
- **Decorator Pattern**: Para adicionar funcionalidades como cashback e seguro
- **Observer Pattern**: Para notificações de pagamentos processados
- **Facade Pattern**: Para simplificar o processamento de pagamentos
- **REST API**: Endpoints documentados com Swagger/OpenAPI
- **DTO Pattern**: Para transferência de dados entre camadas
- **Exception Handling**: Tratamento centralizado de exceções

## 🛠️ Tecnologias e Dependências

- **Java 21+**
- **Spring Boot 3.x**
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring Mail
- Swagger/OpenAPI (Springdoc)
- Banco de dados PostgreSQL
- Maven

## 📋 Requisitos de Ambiente

- JDK 21 ou superior
- Maven 3.6+
- Email configurado (para funcionalidade de notificação - opcional)

## 🚀 Passo a Passo para Executar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/lucasgomes14/Sistema-de-Controle-de-Pagamentos-Online.git
cd payment
```

### 2. Configure as variáveis de ambiente
Edite o arquivo `src/main/resources/application.yml`:

```yml
# Configurações do Banco de Dados PostgreSQL
spring:
  application:
    name: payment
  datasource:
    url: jdbc:postgresql://ep-winter-poetry-ae10laa6-pooler.c-2.us-east-2.aws.neon.tech/neondb?sslmode=require
    username: neondb_owner
    password: npg_t1ovG5EiaMXJ
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true

# Configurações de Email (opcional - necessário para notificações)
  mail:
    host: smtp.gmail.com
    port: 587
    username: projetoaccenturesummeracademy@gmail.com
    password: rbgt gtgd zwgh fdby
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

### 3. Compile o projeto
```bash
mvn clean compile
```

### 4. Execute a aplicação
```bash
mvn spring-boot:run
```

### 5. Acesse a aplicação
- **API REST**: http://localhost:8080/api
- **Swagger UI**: http://localhost:8080/swagger-ui.html

## 📚 Endpoints da API

### 👥 Clientes
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/api/clients/client` | Cadastrar cliente |
| `GET` | `/api/clients/clients` | Listar todos os clientes |
| `GET` | `/api/clients/client/{id}` | Buscar cliente por ID |
| `GET` | `/api/clients/client/payments/{id}` | Buscar pagamentos do cliente |
| `PUT` | `/api/clients/client/{id}` | Atualizar cliente |
| `DELETE` | `/api/clients/client/{id}` | Excluir cliente |

### 💳 Pagamentos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/api/payments/pay/{idClient}` | Processar pagamento |
| `GET` | `/api/payments/payments` | Listar todos os pagamentos |
| `GET` | `/api/payments/payment/{id}` | Buscar pagamento por ID |

## 🧪 Exemplos de Uso

### Cadastrar Cliente
```bash
curl -X POST "http://localhost:8080/api/clients/client" \
-H "Content-Type: application/json" \
-d '{
  "name": "João Silva",
  "email": "joao@email.com"
}'
```

### Processar Pagamento com Cartão e Cashback
```bash
curl -X POST "http://localhost:8080/api/payments/pay/1" \
-H "Content-Type: application/json" \
-d '{
  "amount": 100.00,
  "method": "CARTAO",
  "cashback": true,
  "security": false
}'
```

### Processar Pagamento com PIX
```bash
curl -X POST "http://localhost:8080/api/payments/pay/1" \
-H "Content-Type: application/json" \
-d '{
  "amount": 150.50,
  "method": "PIX",
  "cashback": false,
  "security": false
}'
```

## 🔧 Estratégias de Pagamento Implementadas

- **Cartão (CARTAO)**: +5% de taxa
- **PIX**: Sem taxas
- **Boleto (BOLETO)**: -5% de desconto

## 🎁 Funcionalidades Decoradoras

- **Cashback**: 5% de desconto no valor final (disponível apenas para pagamentos com cartão)
- **Seguro**: +R$5,00 para proteção adicional (disponível apenas para pagamentos com cartão)

## 📧 Notificações

O sistema envia automaticamente um e-mail para o cliente quando um pagamento é processado com sucesso. Para ativar esta funcionalidade, configure as propriedades de e-mail no `application.properties`.

## 🐛 Tratamento de Exceções

O sistema inclui tratamento para:
- `ClientNotFoundException` - Cliente não encontrado (404)
- `PaymentNotFoundException` - Pagamento não encontrado (404)
- `InvalidMethodException` - Método de pagamento inválido (400)
- Erros de validação de dados (400)
- Erros inesperados do servidor (500)

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ifpb/
│   │               /payment    
│   │               ├── config/              # Configurações
│   │               │   └── OpenAPIConfig.java
│   │               ├── controller/          # Controladores REST
│   │               │   ├── ClientController.java
│   │               │   ├── ClientControllerImpl.java
│   │               │   ├── PaymentController.java
│   │               │   └── PaymentControllerImpl.java
│   │               ├── service/             # Lógica de negócio
│   │               │   ├── ClientService.java
│   │               │   ├── ClientServiceImpl.java
│   │               │   ├── PaymentService.java
│   │               │   └── PaymentServiceImpl.java
│   │               ├── repository/          # Persistência de dados
│   │               │   ├── ClientRepository.java
│   │               │   └── PaymentRepository.java
│   │               ├── entity/              # Entidades JPA
│   │               │   ├── Client.java
│   │               │   └── PaymentEntity.java
│   │               ├── dto/                 # Objetos de Transferência de Dados
│   │               │   ├── ClientRequestDTO.java
│   │               │   ├── ClientResponseDTO.java
│   │               │   ├── PaymentRequestDTO.java
│   │               │   ├── PaymentResponseDTO.java
│   │               │   └── PaymentClientResponseDTO.java
│   │               ├── strategy/            # Padrão Strategy
│   │               │   ├── PaymentStrategy.java
│   │               │   ├── PaymentCardStrategy.java
│   │               │   ├── PaymentPixStrategy.java
│   │               │   └── PaymentTicketStrategy.java
│   │               ├── decorator/           # Padrão Decorator
│   │               │   ├── Payment.java
│   │               │   ├── PaymentBasic.java
│   │               │   ├── PaymentCashback.java
│   │               │   └── PaymentSegurity.java
│   │               ├── observer/            # Padrão Observer
│   │               │   ├── PaymentObserver.java
│   │               │   └── EmailObserver.java
│   │               ├── facade/              # Padrão Facade
│   │               │   └── PaymentFacade.java
│   │               └── exception/           # Tratamento de exceções
│   │                   ├── GlobalExceptionHandler.java
│   │                   ├── ClientNotFoundException.java
│   │                   ├── PaymentNotFoundException.java
│   │                   └── InvalidMethodException.java
│   └── resources/
│       ├── application.yml       # Configurações da aplicação
```

## 🔍 Próximos Passos/Melhorias Possíveis

- [ ] Implementar autenticação e autorização (Spring Security)
- [ ] Adicionar testes unitários e de integração (JUnit, Mockito)
- [ ] Implementar logging mais detalhado (Log4j2)
- [ ] Implementar filas para processamento assíncrono de pagamentos (RabbitMQ/Kafka)
- [ ] Adicionar dashboard para monitoramento (Spring Boot Admin)
- [ ] Implementar cache para melhor performance (Redis)
- [ ] Adicionar documentação mais detalhada (JavaDoc)

## 📞 Suporte

Em caso de dúvidas ou problemas:

1. Consulte a documentação interativa do Swagger em: http://localhost:8080/swagger-ui.html
2. Verifique os logs da aplicação para detalhes de erro
3. Certifique-se de que todas as dependências estão corretamente configuradas

Para contribuir com o projeto, siga as boas práticas de desenvolvimento e documentação existentes no código.

---

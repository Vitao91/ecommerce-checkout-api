# 🛒 E-commerce Checkout API

API REST de checkout para e-commerce desenvolvida em **Java 21 e Spring Boot**, como parte do desafio de conclusão dos estudos sobre **Design Patterns** na plataforma DIO.

O projeto simula o cálculo de um pedido, considerando os valores dos produtos, o frete e a aplicação de cupons de desconto. O principal objetivo é demonstrar, na prática, o uso do padrão de projeto **Strategy**, promovendo código organizado, reutilizável e de fácil manutenção.

## 🎯 Objetivos

- Aplicar conceitos de Design Patterns em um projeto prático.
- Implementar uma API REST utilizando Spring Boot.
- Separar as responsabilidades entre controller, serviço e estratégias de desconto.
- Validar os dados recebidos pela API.
- Praticar a organização e a documentação de um projeto Java.

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.5
- Maven
- Spring Web
- Bean Validation
- JUnit e Spring Boot Test

## 🧩 Design Pattern: Strategy

O padrão **Strategy** permite definir diferentes algoritmos ou regras de negócio por meio de uma interface comum.

Neste projeto, a interface `DiscountStrategy` representa uma estratégia de cálculo de desconto. As implementações permitem aplicar um cupom ou não conceder desconto.

### Estratégias implementadas

- `CouponDiscountStrategy`: aplica descontos conforme o cupom informado.
- `NoDiscountStrategy`: mantém o pedido sem desconto.

### Cupons disponíveis

| Cupom | Desconto |
|---|---:|
| `DIO10` | 10% |
| `DIO20` | 20% |
| Sem cupom ou cupom inválido | 0% |

## ⚙️ Funcionalidades

- Recebimento de pedidos por meio de uma API REST.
- Cálculo do subtotal dos produtos.
- Aplicação de descontos por cupom.
- Inclusão do valor do frete.
- Cálculo do total do pedido.
- Validação dos dados de entrada.
- Resposta em formato JSON.

## 📋 Pré-requisitos

- JDK 21 instalado.
- Git instalado, caso deseje clonar o repositório.
- Acesso à internet na primeira execução para baixar as dependências Maven.

## ▶️ Como executar

Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd ecommerce-checkout-api
```

### Windows

Execute os testes:

```powershell
.\mvnw.cmd clean test
```

Inicie a aplicação:

```powershell
.\mvnw.cmd spring-boot:run
```

### Linux ou macOS

Execute os testes:

```bash
./mvnw clean test
```

Inicie a aplicação:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:

`http://localhost:8080`

## 🔗 Endpoint de checkout

**Método:** `POST`

**Rota:** `/api/checkout`

**URL local:** `http://localhost:8080/api/checkout`

### Exemplo de requisição

```json
{
  "items": [100.00, 49.90],
  "shipping": 12.00,
  "coupon": "DIO10"
}
```

### Exemplo de resposta

```json
{
  "subtotal": 149.90,
  "discount": 14.99,
  "shipping": 12.00,
  "total": 146.91,
  "appliedStrategy": "CUPOM"
}
```

## 📁 Organização do projeto

- `CheckoutController`: recebe as requisições HTTP.
- `CheckoutService`: coordena o cálculo do pedido.
- `DiscountStrategy`: define o contrato das estratégias de desconto.
- `CouponDiscountStrategy`: implementa os descontos por cupom.
- `NoDiscountStrategy`: implementa a estratégia sem desconto.
- `dto`: contém os objetos de entrada e saída da API.
- `ApiExceptionHandler`: centraliza o tratamento de erros de validação.

## 📚 Aprendizados

Este projeto foi desenvolvido para praticar Java, Spring Boot, construção de APIs REST, injeção de dependências, validação de dados e aplicação do padrão Strategy em regras de negócio.

## 👨‍💻 Contexto

Projeto educacional desenvolvido como parte do desafio de Design Patterns da DIO, com foco no aprendizado prático e na construção de portfólio.

---

⭐ Obrigado por visitar este repositório! Sugestões e contribuições são bem-vindas.

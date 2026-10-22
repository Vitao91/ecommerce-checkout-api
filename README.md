# E-commerce Checkout API

API de checkout em Java 21 e Spring Boot, criada como projeto de portfólio para praticar Design Patterns.

## Padrões demonstrados
- **Strategy**: `DiscountStrategy` permite variar a regra de desconto sem alterar o controller.
- **Injeção de dependências**: Spring gerencia as implementações e seus ciclos de vida.
- **DTO + validação**: o contrato da API é separado da lógica de negócio e valida entradas inválidas.

## Pré-requisitos
- JDK 21
- Acesso à internet na primeira execução para o Maven Wrapper baixar dependências.

## Executar
Linux/macOS:
```bash
./mvnw spring-boot:run
```
Windows (PowerShell ou CMD):
```bat
mvnw.cmd spring-boot:run
```

Testes:
```bash
./mvnw test
```

## Endpoint
`POST http://localhost:8080/api/checkout`

Exemplo de JSON:
```json
{
  "items": [100.00, 49.90],
  "shipping": 12.00,
  "coupon": "DIO10"
}
```

Resposta esperada:
```json
{
  "subtotal": 149.90,
  "discount": 14.99,
  "shipping": 12.00,
  "total": 146.91,
  "appliedStrategy": "CUPOM"
}
```

Cupons disponíveis: `DIO10` (10%) e `DIO20` (20%). Cupom ausente ou desconhecido não aplica desconto.

> Projeto educacional: antes de usar em produção, adicione persistência, autenticação, regras de negócio completas, testes de integração e observabilidade.

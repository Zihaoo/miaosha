# Quick Start

## Prerequisites

- JDK 8+ runtime
- Maven
- MySQL

## Database Setup

1. Create a database named `miaosha`.
2. Import [`sql/miaosha.sql`](../sql/miaosha.sql).

## Local Configuration

Use [`src/main/resources/application-local.example.properties`](../src/main/resources/application-local.example.properties) as your starting point.

Recommended local values:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

Keep secrets in local files only. Do not commit personal credentials.

## Run

Example:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.config.additional-location=src/main/resources/application-local.example.properties
```

Or run the `App` class in your IDE with a local config file.

## Verify

Request:

```bash
curl http://localhost:8080/
```

Expected response includes:

- `status: UP`
- `project: miaosha`
- `type: flash-sale-reference`

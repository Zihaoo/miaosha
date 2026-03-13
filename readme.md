# Miaosha

[English README](README_EN.md)

`miaosha` is a Spring Boot flash-sale reference implementation focused on the core workflow behind a simple seckill system: user registration, item browsing, promotion status, inventory deduction, and order creation.

This repository started as a learning project and is now being maintained as a small open-source reference project for developers who want to study a layered Java backend around flash-sale scenarios.

## Project Positioning

- Reference implementation for learning Spring Boot + MyBatis service layering
- Covers the main flash-sale flow: user, item, promo, stock, order
- Suitable for studying transaction boundaries and request validation
- Not production-ready without additional work on concurrency control, observability, security, and deployment

## Features

- User registration, login, and OTP demo flow
- Item list, item detail, and item inspection endpoint
- Promotion-aware item view model
- Inventory deduction and order creation service flow
- SQL bootstrap script for local MySQL setup
- Lightweight tests for entry metadata, item inspection, and order validation

## Tech Stack

- Java 8 source compatibility
- Spring Boot 2.0.x
- MyBatis
- MySQL
- Hibernate Validator
- Joda-Time

## Architecture

The codebase follows a simple layered design:

- `controller`: HTTP request handling and response shaping
- `service`: business interfaces and orchestration
- `service.impl`: implementation of domain workflows
- `dao`: MyBatis mapper interfaces
- `dataobject`: persistence models mapped to database tables
- `viewobject`: response models returned to clients

## Quick Start

1. Install MySQL and create a database named `miaosha`.
2. Import [`sql/miaosha.sql`](sql/miaosha.sql).
3. Copy [`src/main/resources/application-local.example.properties`](src/main/resources/application-local.example.properties) into your local runtime config and fill in your database credentials.
4. Start the app with Maven or your IDE.
5. Verify startup by requesting `/`.

Detailed setup:
- [Quick Start](docs/quick-start.md)
- [API Overview](docs/api-overview.md)

## Useful Endpoints

- `GET /` - application metadata and health-style status
- `GET /item/list` - item list
- `GET /item/get?id=<id>` - item detail
- `GET /item/inspect?id=<id>` - item detail with stock and promo summary
- `POST /user/getotp` - OTP demo
- `POST /user/register` - register user
- `POST /user/login` - login
- `POST /order/createorder` - create order

## Repository Status

Current focus is to keep this repository useful as a learning-oriented reference project:

- improve onboarding
- add focused tests
- document domain flow more clearly
- keep changes incremental and easy to understand

Planned work:
- [Roadmap](ROADMAP.md)
- [Changelog](CHANGELOG.md)
- [Contributing Guide](CONTRIBUTING.md)

## Why This Project Exists

There are many high-level articles about flash-sale systems, but fewer small repositories that keep the code path readable for learners. `miaosha` aims to stay small enough to understand while still covering the main application flow from HTTP request to transactional order creation.

## License

This project is licensed under the Apache License 2.0. See [`LICENSE`](LICENSE).

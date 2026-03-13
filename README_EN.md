# Miaosha

`miaosha` is a Spring Boot flash-sale reference implementation for learning how a small seckill-style backend is structured.

It demonstrates a readable layered design around:

- user registration and login
- item listing and item detail retrieval
- promotion-aware item views
- stock deduction
- order creation

## Scope

This project is intentionally small. It is designed for learning and reference, not as a production-ready flash-sale platform.

What it is:
- a compact Spring Boot + MyBatis backend reference
- a repository for studying service layering and request flow
- a starting point for contributors interested in educational backend OSS

What it is not:
- a hardened production system
- a benchmark for extreme concurrency
- a complete commerce platform

## Highlights

- Java 8 compatible source configuration
- SQL bootstrap script for local MySQL setup
- status endpoint for quick runtime verification
- item inspection endpoint exposing stock and promo state
- focused tests around entry metadata, item inspection, and order validation
- contributor-facing docs and roadmap

## Getting Started

See:
- [Quick Start](docs/quick-start.md)
- [API Overview](docs/api-overview.md)

## Maintainer Notes

This repository began as a learning project and is being refined into a public reference implementation. The goal is to keep the code understandable, honest in scope, and useful to other developers.

## Project Links

- [Chinese README](readme.md)
- [Roadmap](ROADMAP.md)
- [Changelog](CHANGELOG.md)
- [Contributing Guide](CONTRIBUTING.md)

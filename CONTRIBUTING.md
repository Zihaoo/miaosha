# Contributing

Thanks for taking interest in `miaosha`.

## What Kind of Contributions Help

- bug fixes in current business flow
- clearer documentation
- focused tests
- small usability improvements for local setup
- improvements that keep the project readable for learners

## Contribution Rules

- Keep changes small and well scoped.
- Avoid introducing production-scale complexity unless it clearly improves the reference value of the project.
- Add or update tests when changing behavior.
- Document any new endpoint, config, or setup step.

## Development Setup

1. Import the SQL file from [`sql/miaosha.sql`](sql/miaosha.sql).
2. Create a local config based on [`src/main/resources/application-local.example.properties`](src/main/resources/application-local.example.properties).
3. Run targeted tests with `mvn test`.

## Pull Request Expectations

- explain what changed
- explain why the change is useful
- include verification notes
- keep documentation updated if behavior changed

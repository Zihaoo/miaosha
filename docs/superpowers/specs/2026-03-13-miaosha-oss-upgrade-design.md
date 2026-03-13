# Miaosha OSS Upgrade Design

## Context

`miaosha` is currently a course-derived Spring Boot flash-sale demo. It has basic domain logic for users, items, promotions, inventory, and orders, but it lacks the signals expected from a maintained open-source reference project:

- README is course-oriented and not suitable for external readers.
- There is no onboarding path for local setup beyond editing inline properties.
- Tests and governance files are missing.
- Repository contents include noisy static assets that do not strengthen the project story.
- The application entrypoint is tied to database access instead of a neutral service health signal.

The goal is not to market this as production-ready software. The goal is to turn it into a credible, honest reference implementation for learning Spring Boot flash-sale workflows.

## Goals

- Reposition the repository as a public Spring Boot flash-sale reference implementation.
- Improve first-run experience with example configuration and clearer setup docs.
- Add enough verification to demonstrate active maintenance and basic quality discipline.
- Add one or two lightweight product improvements that make the system easier to inspect and evaluate.
- Reduce repository noise that distracts from the core backend learning value.

## Non-Goals

- No large-scale architecture rewrite.
- No promise of production-grade high-concurrency readiness.
- No frontend redesign.
- No deep dependency modernization beyond safe Java 8 / Spring Boot 2.x-compatible cleanup.

## Chosen Approach

Use a medium-scope repo upgrade that combines documentation, engineering hygiene, and a small amount of productization:

1. Reframe project identity through README, English documentation, roadmap, changelog, contribution guide, and issue templates.
2. Improve project operability with example local configuration, cleaner application entry behavior, and a small status endpoint.
3. Add targeted tests around core service and controller behavior.
4. Add lightweight domain-facing endpoints that expose stock and promotion status for easier evaluation.
5. Remove obviously irrelevant static assets while preserving the basic demo flow already present.

This balances credibility gains against implementation risk. A docs-only change would still look like a course repo. A full modernization would overrun the real objective.

## Architecture Impact

The existing layered design remains in place:

- `controller` continues to expose HTTP endpoints.
- `service` and `service.impl` continue to carry orchestration and business logic.
- `dao` and MyBatis mappings remain unchanged unless minor support changes are required.

The new behavior will stay additive:

- neutral metadata / health-style endpoint at the app layer
- stock and promotion inspection endpoint in the item domain
- example configuration file for local bootstrapping
- tests added under `src/test/java`

This keeps the project familiar to current readers while making it easier for new contributors to understand and run.

## Repository and Documentation Changes

The repository will be upgraded to look like a maintained reference project:

- Rewrite `readme.md` with a clear project identity, feature list, architecture summary, quick start, API overview, and roadmap link.
- Add `README_EN.md` for English-first readers and application materials.
- Add `CONTRIBUTING.md`, `CHANGELOG.md`, and `ROADMAP.md`.
- Add docs under `docs/` for quick start and API overview.
- Add GitHub templates under `.github/` for issues and pull requests.

The writing will be explicit about current limits and learning purpose, avoiding inflated claims.

## Code Changes

The code upgrade will stay narrow and defensible:

- Move compiler target to Java 8.
- Replace the database-coupled root endpoint with a repository-neutral application endpoint.
- Add a small system metadata endpoint that can be hit after startup.
- Add a new item inspection endpoint exposing inventory and promotion status for an item.
- Add example local properties so setup does not require editing tracked files.
- Preserve existing business flow for registration, login, listing, detail, and order creation.

## Testing Strategy

Introduce a lightweight test baseline focused on confidence, not exhaustive coverage:

- unit-style service tests for order validation paths where feasible through mocks
- controller tests for item endpoints and the new metadata/status behavior
- avoid brittle full-stack integration setup in this pass

Tests should prove the repository is maintained and safe to extend.

## Cleanup Strategy

Repository cleanup will remove or de-emphasize files that make the project look like an indiscriminate dump:

- remove obviously unrelated static templates and bundled theme assets where they are not used by the main demo flow
- keep the existing minimal flash-sale demo pages if they still correspond to backend flows

The cleanup will be conservative. If usage is unclear, prefer keeping the file over deleting working behavior.

## Risks

- Some old dependencies or APIs may constrain test setup.
- Static assets may have unclear usage links, so cleanup must be verified against referenced pages.
- Existing code quality issues may surface once tests are introduced.

These are manageable because the planned changes are incremental and the repo size is small.

## Success Criteria

The work is successful if, after the upgrade:

- the repo reads like a maintained reference implementation
- a new reader can understand what it is and how to run it
- the codebase has basic tests and example configuration
- there is at least one lightweight new capability that improves evaluation
- the repository is visibly cleaner and more intentional

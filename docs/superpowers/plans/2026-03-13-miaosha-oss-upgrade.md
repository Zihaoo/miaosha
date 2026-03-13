# Miaosha OSS Upgrade Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Upgrade `miaosha` from a course-style demo into a credible Spring Boot flash-sale reference implementation with better docs, setup, tests, and a small amount of additive functionality.

**Architecture:** Keep the current controller-service-dao structure intact. Add documentation and governance files around the existing app, introduce a neutral application metadata/status surface, and add narrow item-inspection functionality plus tests without broad refactors.

**Tech Stack:** Java 8, Spring Boot 2.0.x, MyBatis, JUnit/Mockito/Spring test support, Markdown docs, GitHub templates.

---

## Chunk 1: Foundation and repository framing

### Task 1: Rework project metadata and configuration defaults

**Files:**
- Modify: `pom.xml`
- Modify: `src/main/resources/application.properties`
- Create: `src/main/resources/application-local.example.properties`
- Create: `.editorconfig`
- Create: `.github/.gitkeep` or actual template files in later tasks

- [ ] **Step 1: Update Maven metadata and Java version**

Set Java compiler source/target to 1.8, improve project URL/name fields, and add test dependencies needed for controller/service coverage.

- [ ] **Step 2: Move tracked config to safe defaults**

Keep checked-in `application.properties` minimal and non-secret. Ensure local DB values live in `application-local.example.properties`.

- [ ] **Step 3: Verify Maven config parses**

Run: `mvn -q -DskipTests help:effective-pom >/tmp/miaosha-effective-pom.xml`
Expected: command succeeds without POM parsing errors.

### Task 2: Replace fragile root behavior with neutral app metadata

**Files:**
- Modify: `src/main/java/com/miaoshaproject/App.java`
- Create: `src/main/java/com/miaoshaproject/response/AppInfoResponse.java` if a dedicated response object is useful
- Test: `src/test/java/com/miaoshaproject/AppWebMvcTest.java`

- [ ] **Step 1: Write the failing controller test**

Add a Spring MVC test that expects a successful response from `/` or `/health` without requiring a database lookup.

- [ ] **Step 2: Run the test to verify failure**

Run: `mvn -q -Dtest=AppWebMvcTest test`
Expected: FAIL because current root endpoint depends on database state.

- [ ] **Step 3: Implement neutral metadata/status response**

Return a stable project info payload that indicates the app is up and identifies the project as a flash-sale reference implementation.

- [ ] **Step 4: Run the test to verify pass**

Run: `mvn -q -Dtest=AppWebMvcTest test`
Expected: PASS.

## Chunk 2: Product-facing improvements and tests

### Task 3: Add item stock and promotion inspection endpoint

**Files:**
- Modify: `src/main/java/com/miaoshaproject/contorller/ItemController.java`
- Create or Modify: `src/main/java/com/miaoshaproject/contorller/viewobject/ItemVo.java`
- Create: `src/test/java/com/miaoshaproject/contorller/ItemControllerTest.java`

- [ ] **Step 1: Write the failing controller test**

Test an endpoint that returns item detail plus inspectable stock/promotion fields for a mocked item service response.

- [ ] **Step 2: Run the test to verify failure**

Run: `mvn -q -Dtest=ItemControllerTest test`
Expected: FAIL because the endpoint does not exist or fields are missing.

- [ ] **Step 3: Implement minimal controller/view changes**

Expose a read-only inspection endpoint and only the extra fields needed to understand stock and promotion state.

- [ ] **Step 4: Run the test to verify pass**

Run: `mvn -q -Dtest=ItemControllerTest test`
Expected: PASS.

### Task 4: Add order validation tests around core service rules

**Files:**
- Create: `src/test/java/com/miaoshaproject/service/impl/OrderServiceImplTest.java`
- Modify: `src/main/java/com/miaoshaproject/service/impl/OrderServiceImpl.java` only if tests expose a small bug worth fixing

- [ ] **Step 1: Write failing tests for invalid order conditions**

Cover at least invalid amount and missing item / user validation paths with mocked dependencies.

- [ ] **Step 2: Run tests to verify current behavior**

Run: `mvn -q -Dtest=OrderServiceImplTest test`
Expected: at least one failure or brittle behavior exposed by current implementation.

- [ ] **Step 3: Make the minimal fix**

Adjust validation order or null handling only as needed to satisfy the new tests.

- [ ] **Step 4: Re-run tests**

Run: `mvn -q -Dtest=OrderServiceImplTest test`
Expected: PASS.

## Chunk 3: Documentation, governance, and cleanup

### Task 5: Rewrite README and add English-facing docs

**Files:**
- Modify: `readme.md`
- Create: `README_EN.md`
- Create: `docs/quick-start.md`
- Create: `docs/api-overview.md`
- Create: `ROADMAP.md`
- Create: `CHANGELOG.md`
- Create: `CONTRIBUTING.md`

- [ ] **Step 1: Replace course-oriented README structure**

Rewrite the main README around positioning, features, architecture, quick start, API overview, roadmap, and project status.

- [ ] **Step 2: Add English-facing project summary**

Create `README_EN.md` aligned with the same scope and claims.

- [ ] **Step 3: Add supporting docs**

Document setup, database import, local config, and the main APIs a reviewer should inspect.

### Task 6: Add GitHub templates and clean obvious repository noise

**Files:**
- Create: `.github/ISSUE_TEMPLATE/bug_report.md`
- Create: `.github/ISSUE_TEMPLATE/feature_request.md`
- Create: `.github/pull_request_template.md`
- Modify/Delete: selected files under `src/main/resources/static/static/**` only if clearly unrelated

- [ ] **Step 1: Add contribution surfaces**

Create practical issue and PR templates that reinforce a maintained OSS posture.

- [ ] **Step 2: Audit static assets**

Identify assets not referenced by the retained demo pages and remove only the safest subset.

- [ ] **Step 3: Smoke-check retained static pages**

Use code search to ensure remaining demo HTML files still reference existing assets.

## Chunk 4: Verification and release framing

### Task 7: Run verification and prepare release-facing summary

**Files:**
- Modify: `CHANGELOG.md`
- Optionally create: `docs/release-notes-v1.1.0.md`

- [ ] **Step 1: Run targeted tests**

Run: `mvn test`
Expected: tests added in previous tasks pass.

- [ ] **Step 2: Review final diff**

Run: `git status --short` and `git diff --stat`
Expected: changes are focused on docs, configuration, tests, and narrow code additions.

- [ ] **Step 3: Record release summary**

Summarize the repo upgrade in changelog terms suitable for a tagged release or application material.

- [ ] **Step 4: Commit**

```bash
git add .
git commit -m "feat: upgrade miaosha as OSS reference implementation"
```

Plan complete and saved to `docs/superpowers/plans/2026-03-13-miaosha-oss-upgrade.md`. Ready to execute.

## Quick context

This repository contains two main pieces:
- `bankPropEvalutionAppUI/` — an Angular 17 standalone app (frontend). See `package.json` and `src/app`.
- `propertyEvaluation/propertyEvaluation/` — a Spring Boot 3 application (backend). See `pom.xml`, `PropertyEvaluationApplication.java`, and `application.properties`.

The frontend and backend are separate projects in the same repo (not a single build); the usual developer workflow is to run them independently during development.

## How to run (developer-first)
- Frontend (dev):
  - cd `bankPropEvalutionAppUI` then `npm install` (first time) and `npm start` (runs `ng serve`). The app serves on `http://localhost:4200` by default. See `package.json` scripts.
- Backend (dev):
  - cd `propertyEvaluation/propertyEvaluation` then on Windows run `mvnw.cmd spring-boot:run` or use your global Maven: `mvn spring-boot:run`.
  - The Spring Boot app starts on the default port (8080). H2 in-memory DB is configured in `src/main/resources/application.properties` and the H2 console is enabled.

## Project-specific patterns & conventions for AI agents
- Frontend uses Angular standalone components (example: `src/app/app.component.ts` has `standalone: true`). When generating new components, prefer the standalone style used here.
- Routing is centralized in `src/app/app.routes.ts` (currently empty). Add route definitions there; the router is provided in `src/app/app.config.ts`.
- Backend is a minimal Spring Boot app. Controllers, services, and repositories should live under `com.bankPropertyApplication.propertyEvaluation` (same package as `PropertyEvaluationApplication.java`) so Spring component scan picks them up.
- Persistence: H2 is used (runtime) per `application.properties`. Tests and development rely on an in-memory DB — avoid adding hard external DB assumptions without updating configs.

## Integration notes (frontend <> backend)
- There is no explicit proxy or CORS configuration in the repo. If the frontend calls the backend on `localhost:8080` from `:4200`, you will likely need to:
  - add a Spring CORS configuration on the backend, or
  - add an Angular dev proxy (not present) to `bankPropEvalutionAppUI`.
- No REST controllers were found in the current snapshot; expect typical REST endpoints under `src/main/java/.../controller` when they are added.

## Useful files to reference when editing or generating code
- Frontend: `bankPropEvalutionAppUI/package.json`, `bankPropEvalutionAppUI/src/app/app.component.ts`, `bankPropEvalutionAppUI/src/app/app.routes.ts`, `bankPropEvalutionAppUI/README.md`.
- Backend: `propertyEvaluation/propertyEvaluation/pom.xml`, `propertyEvaluation/propertyEvaluation/src/main/java/com/bankPropertyApplication/propertyEvaluation/PropertyEvaluationApplication.java`, `propertyEvaluation/propertyEvaluation/src/main/resources/application.properties`.

## Helpful examples for AI edits
- Add a new standalone component: mirror the pattern in `src/app/app.component.ts` (use `standalone: true`, import `RouterOutlet` or needed modules explicitly).
- Add a Spring REST controller under the same base package. Minimal example structure: `controller` → `service` → `repository` with JPA entities (H2 runtime).

## Developer workflows & checks
- Run frontend unit tests: from `bankPropEvalutionAppUI` run `npm test` (executes `ng test`).
- Run backend tests: from `propertyEvaluation/propertyEvaluation` run `mvn test`.
- Build for production:
  - Frontend: `npm run build` in `bankPropEvalutionAppUI` (outputs `dist/`).
  - Backend: `mvn package` in `propertyEvaluation/propertyEvaluation`.

## What to watch for / gotchas
- No global CORS or proxy is present — cross-origin errors are likely when frontend + backend are run separately.
- The Angular app currently has no routes defined; generated UI work should register routes in `app.routes.ts` and update `app.config.ts` if needed.
- The repo uses in-memory H2 for dev; persistence changes require updating `application.properties` and tests.

If any section is unclear or you want me to include examples/snippets (e.g., a minimal CORS config, Angular proxy config, or a sample REST controller), tell me which and I will add them.

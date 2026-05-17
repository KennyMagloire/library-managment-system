# CHANGELOG

## [1.3.0] - Assignment 12: Service Layer & REST API

### Added
- `service/BookService` — business logic for book operations
- `service/PatronService` — business logic for patron management
- `service/LoanService` — business logic for loan operations
- `api/BookController` — REST endpoints for books (GET, POST)
- `api/PatronController` — REST endpoints for patrons (GET, POST)
- `api/LoanController` — REST endpoints for loans (GET, POST)
- `exception/BookNotFoundException` — 404 response for missing books
- `exception/PatronNotFoundException` — 404 response for missing patrons
- `exception/LoanNotFoundException` — 404 response for missing loans
- `exception/GlobalExceptionHandler` — centralised error handling
- `config/RepositoryConfig` — wires InMemory repositories as Spring beans
- `config/OpenApiConfig` — Swagger UI configuration
- `LibraryApplication` — Spring Boot entry point
- `docs/openapi.yaml` — full OpenAPI 3.0.3 specification
- Unit tests for BookService, PatronService, LoanService

### Notes
- `Main.java` preserved from A9/A10/A11 to demonstrate design patterns
- API runs on port 8080
- Swagger UI available at http://localhost:8080/swagger-ui/index.html

---

## [1.2.0] - Assignment 11: Repository Layer

### Added
- Generic `Repository<T, ID>` interface
- `BookRepository`, `PatronRepository`, `LoanRepository`,
  `FineRepository`, `SystemUserRepository`, `AuditLogRepository` interfaces
- InMemory implementations for all repositories
- `RepositoryFactory` for creating repository instances
- Unit tests for InMemory repositories

---

## [1.1.0] - Assignment 10: Design Patterns

### Added
- Singleton: `DatabaseConnection`
- Simple Factory: `SystemUserFactory`
- Builder: `PatronBuilder`
- Prototype: `BookPrototypeCache`
- Factory Method: `ReportFactory`, `CirculationReportFactory`
- Abstract Factory: `NotificationFactory`, `ConsoleNotificationFactory`

---

## [1.0.0] - Assignment 9: Domain Model

### Added
- Core domain classes: `Book`, `Patron`, `Loan`, `Fine`, `SystemUser`, `AuditLog`, `Report`
- Enums: `BookStatus`, `LoanStatus`, `FineStatus`, `UserRole`, `AffiliationType`, `AuditAction`
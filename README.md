# Library Management System

[![CI](https://github.com/KennyMagloire/library-managment-system/actions/workflows/ci.yml/badge.svg)](https://github.com/KennyMagloire/library-managment-system/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)

A Java-based CLI application that digitises and automates the operations of a university library. Manages book inventory, patron registration, borrowing/returns, fine tracking, and report generation.

---

## Getting Started

### Prerequisites

| Tool | Version |
|------|---------|
| Java (OpenJDK) | 21+ |
| Maven | 3.8+ |
| MySQL | 8.0+ |

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/KennyMagloire/library-managment-system.git
cd library-managment-system

# 2. Set up the MySQL database
#    Create a database and update credentials in src/main/java/com/library/patterns/singleton/DatabaseConnection.java

# 3. Install dependencies
mvn install

# 4. Run the application
mvn exec:java -Dexec.mainClass="com.library.Main"
```

### Running Tests

```bash
mvn test
```

---

## Features

- ✅ Add, update, and search books by title, author, or ISBN
- ✅ Register and manage library patrons
- ✅ Borrow and return books with automatic due-date tracking
- ✅ Track overdue books and calculate fines
- ✅ Generate reports (Circulation, Fines, Audit, Member Activity)
- ✅ Role-based access control (Librarian, Head Librarian, System Admin, University Admin, External Auditor)
- ✅ Full audit logging of every system action
- ✅ MySQL persistence via Singleton connection
- ✅ Six creational design patterns implemented
- ✅ REST API layer with OpenAPI/Swagger documentation

---

## Project Structure

```
library-management-system/
├── .github/workflows/     # CI/CD pipeline (Java 21, Maven)
├── Images/                # Use case and architecture diagrams
├── Test and Use Case/     # Use case specifications and test cases
├── docs/
│   ├── assignments/       # All assignment documentation (A4–A14)
│   ├── CHANGELOG.md       # Detailed changelog
│   └── openapi.yaml       # OpenAPI specification
├── src/
│   ├── main/java/com/library/
│   │   ├── Main.java
│   │   ├── patterns/      # Six creational design patterns
│   │   ├── repository/    # Data access layer
│   │   ├── api/           # REST controllers
│   │   └── ...
│   └── test/java/com/library/
│       └── ...            # Unit tests for all patterns
├── CONTRIBUTING.md        # Contribution guidelines
├── ROADMAP.md             # Planned features
├── LICENSE                # MIT License
└── pom.xml
```

---

## Documentation

All assignment documentation lives in [`docs/assignments/`](docs/assignments/):

| Document | Description |
|----------|-------------|
| [SPECIFICATION.md](docs/assignments/SPECIFICATION.md) | System requirements, domain analysis, scope |
| [STAKEHOLDER_ANALYSIS.md](docs/assignments/STAKEHOLDER_ANALYSIS.md) | Stakeholders, actors, and concerns |
| [SYSTEM_REQUIREMENTS.md](docs/assignments/SYSTEM_REQUIREMENTS.md) | Functional and non-functional requirements (FR1–FR16) |
| [ARCHITECTURE.md](docs/assignments/ARCHITECTURE.md) | C4 architectural diagrams and design decisions |
| [DOMAIN_MODEL_1.md](docs/assignments/DOMAIN_MODEL_1.md) | UML class and domain model |
| [AGILE_PLANNING_1.md](docs/assignments/AGILE_PLANNING_1.md) | User stories, product backlog, sprint plan |
| [ACTIVITY_DIAGRAMS.md](docs/assignments/ACTIVITY_DIAGRAMS.md) | Activity diagrams for core workflows |
| [STATE_DIAGRAMS.md](docs/assignments/STATE_DIAGRAMS.md) | State machine diagrams |
| [CHANGELOG_1.md](docs/assignments/CHANGELOG_1.md) | Full change history across assignments |

Use case specs and test cases are in [`Test and Use Case/`](Test%20and%20Use%20Case/).

---

## Features for Contribution

Looking for a place to start? Here are areas where contributions are welcome:

| Feature | Difficulty | Label |
|---------|-----------|-------|
| Add integration tests for BookController | Beginner | `good first issue` |
| Write unit tests for the service layer | Beginner | `good first issue` |
| Set up Swagger/OpenAPI documentation | Beginner | `good first issue` |
| Fix null username validation in SystemUserFactory | Beginner | `good first issue` |
| Write unit tests for all six creational patterns | Beginner | `good first issue` |
| Build full CLI menu for system interaction | Intermediate | `feature-request` |
| Design generic Repository<T,ID> interface | Intermediate | `feature-request` |
| Add REST controllers for books, patrons and loans | Intermediate | `feature-request` |

Browse all open issues [here](https://github.com/KennyMagloire/library-managment-system/issues). See [CONTRIBUTING.md](CONTRIBUTING.md) before submitting a pull request.

---

## Tech Stack

| Aspect | Details |
|--------|---------|
| Language | Java 21 (OpenJDK) |
| Build Tool | Maven |
| Database | MySQL |
| Architecture | Layered (Presentation → Business Logic → Data Access → Database) |
| Design Patterns | Simple Factory, Factory Method, Abstract Factory, Builder, Prototype, Singleton |
| API | Spring Boot REST + OpenAPI/Swagger |
| CI/CD | GitHub Actions |

---

## Design Decisions

**Why enums over Strings for status fields?**
`BookStatus`, `LoanStatus`, `FineStatus`, and `UserRole` use enums so invalid values are caught at compile time, not at runtime.

**Why `institutionId` instead of `studentNumber`?**
A `Patron` can be a student, lecturer, or staff member — `institutionId` is a generic identifier that works for all affiliation types.

**Why `LocalDate` for dates?**
Date arithmetic (e.g. checking overdue status) requires `ChronoUnit.DAYS.between(dueDate, LocalDate.now())` — impossible with plain Strings.

**Why role-based access on `SystemUser` instead of subclasses?**
A `UserRole` enum and `hasPermission()` method keeps the model flat. Adding a new role only requires adding one enum value.

---

## License

MIT — see [LICENSE](LICENSE) for details.

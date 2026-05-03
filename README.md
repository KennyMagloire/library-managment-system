# Library Management System

## Project Overview

**Library Management System** is a Java-based CLI application that digitizes and automates the operations of a university library. The system enables librarians to manage book inventory, register patrons, process checkouts and returns, track fines, and generate reports.

## Project Links

- 📖 **[System Specification](./SPECIFICATION.md)** - Complete system requirements, domain analysis, and scope
- 🏗️ **[Architecture Documentation](./ARCHITECTURE.md)** - C4 architectural diagrams and system design
- 📋 **[Agile Planning](./AGILE_PLANNING.md)** - User stories, product backlog, and sprint plan
- 📝 **[Changelog](./CHANGELOG.md)** - Full history of changes across all assignments
- 🔗 **[GitHub Repository](https://github.com/KennyMagloire/library-managment-system)**

---

## Quick Summary

| Aspect | Details |
|--------|---------|
| **Domain** | Library Management |
| **Primary Language** | Java (OpenJDK 24) |
| **Build Tool** | Maven |
| **Database** | MySQL |
| **Architecture** | Layered (Presentation, Business Logic, Data Access, Database) |
| **Design Patterns** | Simple Factory, Factory Method, Abstract Factory, Builder, Prototype, Singleton |

---

## Features

- ✅ Add, update, and search books
- ✅ Register and manage library patrons
- ✅ Borrow and return books with automatic due date tracking
- ✅ Track overdue books and calculate fines
- ✅ Generate reports (Circulation, Fines, Audit, Member Activity)
- ✅ Role-based access control (Librarian, Head Librarian, System Admin, etc.)
- ✅ Full audit logging of every system action
- ✅ MySQL database persistence via Singleton connection
- ✅ Six creational design patterns implemented

---

## Project Structure

```
library-management-system/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/library/
│   │           ├── Main.java
│   │           ├── SystemUser.java
│   │           ├── Patron.java
│   │           ├── Book.java
│   │           ├── Loan.java
│   │           ├── Fine.java
│   │           ├── Report.java
│   │           ├── AuditLog.java
│   │           ├── (enums)
│   │           └── patterns/
│   │               ├── singleton/       # DatabaseConnection
│   │               ├── simplefactory/   # SystemUserFactory
│   │               ├── factorymethod/   # ReportFactory + 4 factories
│   │               ├── abstractfactory/ # NotificationFactory families
│   │               ├── builder/         # PatronBuilder
│   │               └── prototype/       # BookPrototypeCache
│   └── test/
│       └── java/
│           └── com/library/
│               ├── SingletonTest.java
│               ├── SimpleFactoryTest.java
│               ├── BuilderTest.java
│               ├── PrototypeTest.java
│               ├── FactoryMethodTest.java
│               └── AbstractFactoryTest.java
└── pom.xml
```

---

## Language Choice: Java

Java was chosen because the system is built around object-oriented principles — classes, interfaces, inheritance, and composition — which map directly to the UML class diagram. Java's `Cloneable` interface made the Prototype pattern straightforward, and `synchronized` with `volatile` provided proper thread safety for the Singleton without any external libraries.

---

## Design Decisions

### Why enums over Strings for status fields?
Fields like `BookStatus`, `LoanStatus`, `FineStatus`, and `UserRole` use enums instead of plain Strings. This prevents typos like `"AVAILBLE"` from slipping through silently — Java catches invalid values at compile time rather than at runtime.

### Why `institutionId` instead of `studentNumber` on Patron?
A `Patron` can be a student, lecturer, or staff member. Calling the field `studentNumber` would be incorrect for non-students. `institutionId` is a generic identifier that works for all affiliation types.

### Why `LocalDate` and `LocalDateTime` instead of Strings for dates?
Date comparisons (e.g. checking if a loan is overdue) require real date arithmetic. Using `LocalDate` lets us call `ChronoUnit.DAYS.between(dueDate, LocalDate.now())` directly instead of manually parsing strings.

### Why composition between Loan and Fine?
A `Fine` has no meaning outside of a `Loan`. If a loan is removed, its fine goes with it. This is modelled as composition — `Fine` holds a direct reference to its parent `Loan`.

### Why role-based access on SystemUser instead of subclasses?
Rather than creating separate classes for each actor (Librarian, HeadLibrarian, etc.), a `UserRole` enum and `hasPermission()` method control what each user can do. This is simpler and more practical for a CLI system — adding a new role only requires adding a value to the enum.

---

## Creational Pattern Rationale

| Pattern | Implementation | Why |
|---|---|---|
| **Singleton** | `DatabaseConnection` | Only one MySQL connection should exist. Multiple instances writing simultaneously would corrupt data. |
| **Simple Factory** | `SystemUserFactory` | Centralises user creation. Instead of `new SystemUser(...)` scattered everywhere, one factory handles all roles. |
| **Factory Method** | `ReportFactory` + 4 subclasses | Each report type has its own factory. Adding a new report type only requires a new factory class — no existing code changes. |
| **Abstract Factory** | `NotificationFactory` | Console notifications for development, Email for production. Swapping the entire notification family requires changing one line. |
| **Builder** | `PatronBuilder` | A Patron has required fields (ID, name, affiliation) and optional ones (email, phone, institutionId). The builder makes construction readable and safe. |
| **Prototype** | `BookPrototypeCache` | When adding multiple similar books, cloning a pre-configured template is faster than filling in all fields from scratch each time. |

---

## Running the Project

### Prerequisites
- Java 21+
- Maven
- MySQL

### Setup
```bash
# Clone the repository
git clone https://github.com/KennyMagloire/library-managment-system.git

# Navigate to project
cd library-management-system

# Install dependencies
mvn install

# Run the application
mvn exec:java -Dexec.mainClass="com.library.Main"
```

### Running Tests
```bash
mvn test
```

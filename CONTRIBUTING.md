# Contributing to Library Management System

Thank you for your interest in contributing! This document explains how to get the project running locally, what coding standards to follow, and how to submit your work.

---

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Coding Standards](#coding-standards)
- [Picking an Issue](#picking-an-issue)
- [Submitting a Pull Request](#submitting-a-pull-request)
- [Commit Message Format](#commit-message-format)

---

## Prerequisites

Before you begin, make sure you have the following installed:

| Tool | Version | Purpose |
|------|---------|---------|
| Java JDK | 21+ | Runtime and compilation |
| Maven | 3.8+ | Build and dependency management |
| MySQL | 8.0+ | Database |
| Git | Any recent | Version control |

---

## Getting Started

```bash
# 1. Fork this repository on GitHub, then clone your fork
git clone https://github.com/YOUR_USERNAME/library-managment-system.git
cd library-managment-system

# 2. Add the upstream remote
git remote add upstream https://github.com/KennyMagloire/library-managment-system.git

# 3. Install dependencies and verify the build passes
mvn install

# 4. Run the test suite
mvn test

# 5. Create a feature branch
git checkout -b feature/your-feature-name
```

---

## Coding Standards

- **Language:** Java 21
- **Naming:** camelCase for methods/variables, PascalCase for classes, UPPER_SNAKE_CASE for constants
- **Formatting:** 4-space indentation, no trailing whitespace
- **Tests:** every new feature must include at least one JUnit 5 test. Run mvn test before committing.
- **Patterns:** the project uses six creational patterns. New code must respect the existing architecture in docs/assignments/ARCHITECTURE.md.
- **No magic strings:** use enums for status fields (BookStatus, LoanStatus, UserRole).

---

## Picking an Issue

1. Browse [open issues](https://github.com/KennyMagloire/library-managment-system/issues).
2. Issues labelled good-first-issue are beginner-friendly.
3. Issues labelled feature-request are larger enhancements.
4. Leave a comment on the issue before you start working.
5. To work on something not listed, open an issue first.

---

## Submitting a Pull Request

1. Ensure mvn test passes locally.
2. Push your branch: git push origin feature/your-feature-name
3. Open a Pull Request against the main branch.
4. In your PR description include: what the change does, which issue it closes (e.g. Closes #12), and any relevant screenshots.
5. Address reviewer feedback promptly.

---

## Commit Message Format

Use conventional commits: type: short description

Types: feat, fix, docs, test, refactor, chore

Examples:
- feat: add overdue fine calculation to LoanService
- fix: correct null check in SystemUserFactory
- docs: update README with Getting Started section
- test: add unit tests for PatronBuilder

---

## Questions?

Open a GitHub Discussion or leave a comment on the relevant issue.

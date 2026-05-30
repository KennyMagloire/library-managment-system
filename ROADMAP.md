# Roadmap — Library Management System

This document outlines the planned features and improvements for future versions of the Library Management System. Items are grouped by priority. Contributors are welcome to pick up any item — check the [issues page](https://github.com/KennyMagloire/library-managment-system/issues) for items already tracked as feature-request.

---

## Version 2.0 — Core Enhancements

| Feature | Description | Label |
|---------|-------------|-------|
| **Web API (REST)** | Expose all library operations via a RESTful API so the system is not CLI-only. Built on Spring Boot. | feature-request |
| **Web UI** | A simple browser-based interface (React or plain HTML/JS) to replace the CLI for end users. | feature-request |
| **Email Notifications** | Send overdue reminders and fine notices to patrons via email (Jakarta Mail / SendGrid). | feature-request |
| **Redis Caching** | Cache frequently accessed book and patron records in Redis to reduce database load. | feature-request |
| **Book Reservation System** | Allow patrons to reserve books currently on loan. Notify them when the book becomes available. | feature-request |

---

## Version 2.1 — Data and Reporting

| Feature | Description | Label |
|---------|-------------|-------|
| **PDF Report Export** | Generate borrowing and fine reports as downloadable PDF files using Apache PDFBox. | feature-request |
| **Advanced Search & Filters** | Search by genre, publication year range, availability status, and author. Add sorting options. | good-first-issue |
| **Patron Borrowing History** | A dedicated endpoint/view for a patron's full borrowing history with statistics. | good-first-issue |
| **Overdue Analytics Dashboard** | Visual summary of overdue rates, peak borrowing periods, and top borrowers. | feature-request |

---

## Version 2.2 — Security and Compliance

| Feature | Description | Label |
|---------|-------------|-------|
| **JWT Authentication** | Replace the current session model with JWT tokens for stateless authentication. | feature-request |
| **Role-Based API Access** | Enforce UserRole permissions at the API layer (not just CLI). | good-first-issue |
| **Audit Log Export** | Allow External Auditors to export audit logs as CSV or JSON. | good-first-issue |
| **Password Reset Flow** | Secure password reset via email verification link. | good-first-issue |

---

## Version 3.0 — Scale and Infrastructure

| Feature | Description | Label |
|---------|-------------|-------|
| **Docker Support** | Containerise the application and database with Docker Compose for easy local setup. | feature-request |
| **CI/CD Deployment** | Extend the GitHub Actions pipeline to auto-deploy to a cloud environment (Railway, Render, or AWS EC2). | feature-request |
| **Multi-Branch Library Support** | Support multiple library branches sharing one database, with branch-specific inventory. | feature-request |
| **Internationalisation (i18n)** | Support multiple languages for the UI and notifications. | feature-request |

---

## Completed

| Feature | Version | Notes |
|---------|---------|-------|
| Core CLI (book catalog, members, loans, fines) | 1.0 | Assignments 1–8 |
| Six creational design patterns | 1.0 | Assignments 9–11 |
| REST API layer | 1.0 | Assignment 12 |
| CI/CD pipeline (GitHub Actions) | 1.0 | Assignment 13 |
| Branch protection & open-source setup | 1.0 | Assignment 14 |

---

## Contributing to the Roadmap

Have an idea not listed here? Open a [GitHub Issue](https://github.com/KennyMagloire/library-managment-system/issues/new) with the label `feature-request` and describe the problem it solves. We welcome all suggestions.

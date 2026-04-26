# Reflection – Assignment 9: Domain Modeling and Class Diagram Development

## Overview

Assignment 9 asked me to shift from behavioral modeling — which I worked through in Assignment 8 with state and activity diagrams — into structural modeling. Designing the domain model and class diagram forced me to think about the system not as a sequence of actions but as a set of interconnected objects with defined responsibilities. That change in perspective brought its own set of challenges.

---

## Challenges Faced

The first challenge was deciding what counts as a domain entity. Early on I had too many candidates — I was thinking about things like `Permission`, `Role`, `LoanPeriod`, and `BookCategory` as separate entities. After reviewing the functional requirements (FR1–FR16) and the use cases from Assignment 5, I narrowed it down to seven core entities: `Book`, `Patron`, `Loan`, `Fine`, `SystemUser`, `Report`, and `AuditLog`. The rule I ended up applying was: if it has meaningful attributes and behavior of its own, it's an entity. If it's just a value that another entity holds, it's an attribute.

One terminology decision that required careful thought was what to call the person borrowing a book. In a university library, borrowers are not a homogeneous group — they can be students, lecturers, or other university-affiliated staff. Using a term like "Student" would be too narrow. I settled on **Patron**, which accurately describes anyone affiliated with the university who uses the library's borrowing service, and added an `affiliationType` attribute to capture the distinction. This is also consistent with how the actor model was defined in prior assignments — Patrons are not system actors, they do not log in, and the Librarian acts on their behalf at all times.

The second challenge was representing actors from previous assignments inside the domain model. In Assignments 4 and 5, I established five direct actors: Librarian, System Administrator, Head Librarian, University Administrator, and External Auditor. The question was whether each of those needed its own class. My initial instinct was to use inheritance — a `Librarian` class and an `Administrator` class both extending a `SystemUser` base. But in practice, the system differentiates between roles through permissions, not through distinct behavior at the class level. A Librarian and a Head Librarian both process loans and manage books; the difference is what they're allowed to do, not how they do it. So I collapsed all actors into a single `SystemUser` class with a `role` attribute and a `hasPermission()` method. This was a deliberate simplification, and it's one of the trade-offs I'll discuss below.

The third challenge was getting the Mermaid.js syntax right. I found that Mermaid classDiagram is strict about how it handles certain characters and type annotations. Using Java-style types (e.g., `List<Loan>`) caused rendering issues, so I had to simplify type declarations to just `List`. It's a minor thing, but it highlighted the difference between what a language supports in theory and what a diagram tool handles cleanly in practice.

---

## Alignment with Prior Assignments

The domain model aligns closely with the functional requirements from Assignment 4. FR1 (book management) maps directly to the `Book` class and the `addBook()`, `removeBook()`, and `searchBook()` methods on `SystemUser`. FR2 and FR3 (borrowing and returns) are reflected in the `Loan` entity, the `processCheckout(book, patron)` and `processReturn(loan)` methods on `SystemUser`, and the relationship between `Loan` and `Patron`. FR4 (fine management) gives us the `Fine` class. FR11 (authentication) is represented by `SystemUser.authenticate()`. FR13 and FR14 (reporting) map to the `Report` class. FR16 (audit trail) justifies the `AuditLog` entity.

The use case specifications from Assignment 5 also hold up. UC-001 (borrow book) requires `Book`, `Patron`, `Loan`, and `SystemUser` all to exist with the right relationships — and they do. The `processCheckout(book, patron)` method explicitly takes both a Book and a Patron as parameters, which reflects the two elements involved in any checkout operation. UC-006 (manage fines) requires a `Fine` that's linked to a `Loan` — modelled as composition here. UC-011 (authenticate user) is directly supported by the `authenticate()` method on `SystemUser`.

From Assignment 6, the user stories in the product backlog all trace back to these entities. US-001 (add/update books) drives `addBook()` and `Book.updateDetails()`. US-003 (Patron registration) drives `SystemUser.registerPatron()`. US-005 (fine calculation) drives `Loan.calculateFine()` and `Fine.calculateAmount()`. The traceability feels consistent across assignments, which was something I was conscious of when building this model.

---

## Trade-offs Made

The biggest trade-off was the decision to use a flat `SystemUser` class with role-based access control rather than an inheritance hierarchy. An inheritance approach — with a `Librarian` subclass, an `Administrator` subclass, and so on — would be more strictly object-oriented. But for a CLI system with file-based persistence, a role attribute stored in a user file is far more practical than managing a polymorphic class hierarchy at runtime. I chose composition of behavior (via `hasPermission()`) over inheritance of type because it fits the implementation context better.

Another trade-off was keeping `AuditLog` as a standalone entity rather than embedding audit fields (`lastModifiedBy`, `timestamp`) inside every other class. The standalone approach is cleaner for querying and reporting, even though it adds a dependency between `SystemUser` and `AuditLog`. For a system that has an External Auditor actor with read access to logs, a dedicated entity makes more sense than scattered audit fields.

---

## Lessons Learned

The main lesson from this assignment is that Every class in this diagram corresponds to a concrete business concern — borrowing, fines, access control, reporting, accountability. When I caught myself adding a class just because it "felt right" (like a standalone `Permission` class), checking it against the requirements list was the fastest way to decide whether it actually belonged.

Terminology also matters more than I initially gave it credit for. Calling a Patron a "Member" sounds close enough, but it carries assumptions — that the person has an account, that they self-register, that they're a fixed type of user. None of that is true in this system. Getting the language right forced clearer thinking about the actual design. A Patron is someone the Librarian registers and acts on behalf of. That distinction shaped where methods live and how relationships are drawn.



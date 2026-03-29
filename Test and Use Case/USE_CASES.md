# Use Case Diagrams and Explanations: Library Management System

## 1. Use Case Overview

The use case diagram models how different actors interact with the Library Management System. The diagram includes 5 system actors (people who directly use the system) and 15 use cases mapped to your 16 functional requirements.

**Important Note:** Library Members are **stakeholders** (they benefit from the system) but **not actors** (they don't use the system). The Librarian operates the system **on their behalf**.

---

## 2. Use Case Diagram 
![Use Case Diagram](../images/.Use_Case_Diagram.drawio.png)

---

## 3. Actor Descriptions and Relationships

### Actor 1: Librarian (Primary System User)
**Role:** Primary system user who manages books, processes borrowing/return transactions, and assists library members.

**Performs/Initiates Use Cases:**
- Search Books (UC-001) - to assist members or manage inventory
- Add Book (UC-002) - expand catalog
- Update Book (UC-003) - manage availability and status
- Delete Book (UC-004) - remove obsolete materials
- Register Member (UC-005) - onboard new patrons
- Borrow Book (UC-006) - process checkout **on behalf of member**
- Return Book (UC-007) - process return **on behalf of member**
- Authenticate (UC-011) - login to system
- View Member History (UC-009) - access patron records

**Stakeholder Mapped To:** Librarian (from Assignment 4)

**Concern Addressed:** "Fast and accurate operations, ease of use, minimal errors"

---

### Actor 2: System Administrator (IT Support)
**Role:** Maintains system infrastructure, manages authentication, handles backups, and monitors system activity.

**Performs/Monitors Use Cases:**
- Authenticate Librarian (UC-011) - manage login system
- Manage Authentication (UC-011) - configure access control
- Backup & Restore Data (UC-013) - disaster recovery
- View Activity Logs (UC-012) - monitor system health

**Stakeholder Mapped To:** System Administrator (from Assignment 4)

**Concern Addressed:** "System stability, data integrity, security, backup and recovery"

---

### Actor 3: Head Librarian (Supervisory Staff)
**Role:** Supervisory staff who manages librarian accounts, reviews activity logs, and oversees operations.

**Performs/Reviews Use Cases:**
- View Activity Logs (UC-012) - review staff actions
- Manage Librarian Accounts (UC-014) - create, update, deactivate staff
- View Member History (UC-009) - verify transaction accuracy
- View Library Statistics (UC-015) - assess operational performance

**Stakeholder Mapped To:** Head Librarian (from Assignment 4)

**Concern Addressed:** "Monitoring staff activities, accountability, access to reports"

---

### Actor 4: University Administrator (Strategic Stakeholder)
**Role:** Senior institutional leader who accesses reports and statistics for decision-making.

**Accesses Use Cases:**
- Generate Reports (UC-010) - circulation data, popular books, member activity
- View Library Statistics (UC-015) - institutional metrics

**Stakeholder Mapped To:** University Administration (from Assignment 4)

**Concern Addressed:** "System efficiency, usage statistics, resource management"

---

### Actor 5: External Auditor / Compliance Officer (Reviewer)
**Role:** Reviews system compliance, audits transactions, and verifies data integrity.

**Reviews/Audits Use Cases:**
- View Activity Logs (UC-012) - audit trail for compliance
- Generate Reports (UC-010) - verify transaction accuracy

**Stakeholder Mapped To:** External Auditor / Compliance Officer (from Assignment 4)

**Concern Addressed:** "Data integrity, transparency, traceability of actions"

---

## 4. Use Case Map to Functional Requirements

| Use Case | FR(s) | Description |
|----------|-------|-------------|
| UC-001: Search Books | FR1 | Librarian searches catalog by title, author, or ISBN with results in <2 seconds |
| UC-002: Add Book | FR2 | Librarian adds new books with unique ISBN and validated fields |
| UC-003: Update Book | FR3 | Librarian updates book details and availability status immediately |
| UC-004: Delete Book | FR4 | Librarian deletes books (only if not borrowed) with reason logging and timestamp |
| UC-005: Register Member | FR5 | Librarian registers new patrons with validated data; system generates unique ID |
| UC-006: Borrow Book | FR6 | Librarian processes checkout **for member** with availability check and 14-day due date |
| UC-007: Return Book | FR7 | Librarian processes return **for member**; date/time recorded; availability updated |
| UC-008: Calculate Fine | FR8 | System automatically calculates overdue fines based on days overdue |
| UC-009: View Member History | FR9 | Librarian/Head Librarian display all member transactions and fine balance |
| UC-010: Generate Reports | FR10 | Generate reports on circulation, popular books, member activity |
| UC-011: Authenticate Librarian | FR11 | Librarians log in with username/password before accessing system |
| UC-012: View Activity Logs | FR12, FR13 | View/review timestamped records of user operations |
| UC-013: Backup & Restore Data | FR14 | System administrators backup and restore data |
| UC-014: Manage Librarian Accounts | FR15 | Head librarian creates, updates, deactivates librarian accounts |
| UC-015: View Library Statistics | FR16 | View summary stats (total books, members, borrowed count) |

---

## 5. Key Distinction: Stakeholders vs. Actors

### Library Member is a **Stakeholder, NOT an Actor**

**Stakeholder Definition:** A person who benefits from or is affected by the system

**Actor Definition:** A person who directly interacts with the system

**Library Member's Role:**
- ✅ Benefits from the system (can borrow books, track fines, etc.)
- ✅ Interacts with the library (visits, requests books)
- ❌ Does NOT use the system directly
- ❌ Does NOT log in
- ❌ Does NOT perform transactions

**Librarian Acts On Behalf of Members:**
- Librarian logs into the system
- Librarian searches for books
- Librarian registers new members
- Librarian processes checkout **for** the member
- Librarian processes return **for** the member
- Member gets access to information through the librarian

**Example Flow:**
1. Member wants to borrow a book
2. Member asks librarian at desk
3. Librarian searches system (using UC-001)
4. Librarian processes checkout (using UC-006)
5. Member receives book and receipt (librarian provided)

---

## 6. Use Case Dependencies and Relationships

### Dependency 1: "Search Books" precedes "Borrow Book"
- Librarian searches for a book before processing checkout
- Search results help librarian confirm availability
- Requirement Alignment: FR1 + FR6

### Dependency 2: "Borrow Book" triggers "Calculate Fine"
- When a return is late, fine calculation is automatic
- Fine is triggered by UC-007 (Return), not a separate workflow
- Requirement Alignment: FR6 + FR8

### Dependency 3: "Return Book" updates "View Member History"
- Each return transaction becomes part of member's history
- Librarians can review member records in history
- Requirement Alignment: FR7 + FR9

### Dependency 4: "Authenticate Librarian" precedes all librarian operations
- Librarians must log in before accessing any functionality
- Single authentication session enables all operations
- Requirement Alignment: FR11 + FR2-7

### Dependency 5: "View Activity Logs" depends on "Operation Tracking"
- All operations (FR12) are tracked in background
- Logs become available for review (FR13)
- Requirement Alignment: FR12 → FR13

---

## 7. How the Diagram Addresses Stakeholder Concerns

### Librarian Concern: "Fast and accurate operations"
**Use Cases Supporting:**
- UC-001 (Search): <2 second response
- UC-006 (Borrow): Quick checkout **on behalf of member**
- UC-007 (Return): Immediate fine calculation
- UC-012 (Logs): Review own actions for accuracy

---

### Library Member Concern: "Book availability and due dates"
**How Addressed (through Librarian):**
- UC-001 (Search): Librarian searches to show availability to member
- UC-009 (History): Librarian can show member their transaction history
- UC-006 (Borrow): Librarian confirms due date at checkout to member

---

### System Administrator Concern: "Data integrity and recovery"
**Use Cases Supporting:**
- UC-013 (Backup/Restore): Backup functionality for disaster recovery
- UC-012 (Logs): Timestamped records for audit trail
- FR12 (Operation Tracking): Comprehensive logging of all changes

---

### Head Librarian Concern: "Accountability and staff monitoring"
**Use Cases Supporting:**
- UC-012 (Activity Logs): Review who did what and when
- UC-014 (Manage Accounts): Control staff access
- UC-009 (History): Verify transaction accuracy

---

### University Administrator Concern: "Usage statistics and decision-making"
**Use Cases Supporting:**
- UC-010 (Reports): Circulation data, popular books
- UC-015 (Statistics): Total books, members, borrowed count
- UC-009 (History): Detailed transaction data

---

### Auditor Concern: "Compliance and data traceability"
**Use Cases Supporting:**
- UC-012 (Logs): Complete audit trail with timestamps
- UC-010 (Reports): Data accuracy verification
- FR12 (Operation Tracking): Traceable operations



---

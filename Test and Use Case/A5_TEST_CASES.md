 Test Case Development

## Overview

This document contains functional test cases validating the functional  and non-functional requirements test scenarios for performance, security, and reliability.

---

## Functional Test Cases

### TC-001: Search Books - Valid Title Search

| Field | Details |
|---|---|
| **Test Case ID** | TC-001 |
| **Requirement ID** | FR1 |
| **Use Case** | UC-001: Search Books |
| **Description** | Librarian searches for book by title and receives results within 2 seconds |
| **Preconditions** | Librarian authenticated; catalog loaded with books |
| **Steps** | 1. Select "Search Books" 2. Enter "Harry Potter" 3. Click Search |
| **Expected Result** | Results display within 2 seconds; shows Title, Author, ISBN, Category, Availability (e.g., "2 of 5") |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-002: Search Books - Partial Match

| Field | Details |
|---|---|
| **Test Case ID** | TC-002 |
| **Requirement ID** | FR1 |
| **Use Case** | UC-001: Search Books |
| **Description** | Search with partial text should find matching books |
| **Preconditions** | Librarian authenticated; catalog loaded |
| **Steps** | 1. Select "Search Books" 2. Enter "Art" 3. Click Search |
| **Expected Result** | All books containing "Art" display (e.g., "Art of War", "Artificial Intelligence") |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-003: Search Books - No Results

| Field | Details |
|---|---|
| **Test Case ID** | TC-003 |
| **Requirement ID** | FR1 |
| **Use Case** | UC-001: Search Books |
| **Description** | Search with no matching books should display clear message |
| **Preconditions** | Librarian authenticated |
| **Steps** | 1. Select "Search Books" 2. Enter "XYZ12345" (non-existent) 3. Click Search |
| **Expected Result** | Message: "No books found matching 'XYZ12345'" |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-004: Register Member - Valid Data

| Field | Details |
|---|---|
| **Test Case ID** | TC-004 |
| **Requirement ID** | FR5 |
| **Use Case** | UC-005: Register Member |
| **Description** | Register new member with valid information |
| **Preconditions** | Librarian authenticated; email not already registered |
| **Steps** | 1. Select "Register Member" 2. Enter: Name="John Smith", Email="john@university.edu", Phone="555-1234", Address="123 Main", DOB="01/01/2000" 3. Click Submit |
| **Expected Result** | Member registered; Member ID generated (LMS-2026-NNNN); Status=Active; Expiry set to today+1 year; Confirmation displayed |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-005: Register Member - Duplicate Email

| Field | Details |
|---|---|
| **Test Case ID** | TC-005 |
| **Requirement ID** | FR5 |
| **Use Case** | UC-005: Register Member |
| **Description** | System should reject duplicate email registration |
| **Preconditions** | Librarian authenticated; john@university.edu already registered |
| **Steps** | 1. Select "Register Member" 2. Enter: Name="Jane Smith", Email="john@university.edu" 3. Click Submit |
| **Expected Result** | Error: "This email is already registered" |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-006: Register Member - Missing Required Field

| Field | Details |
|---|---|
| **Test Case ID** | TC-006 |
| **Requirement ID** | FR5 |
| **Use Case** | UC-005: Register Member |
| **Description** | System should require all mandatory fields |
| **Preconditions** | Librarian authenticated |
| **Steps** | 1. Select "Register Member" 2. Enter: Name="John Smith", Email="john@university.edu", Phone="" (empty), Address="123 Main", DOB="01/01/2000" 3. Click Submit |
| **Expected Result** | Error: "Phone number is required"; Form not submitted |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-007: Borrow Book - Valid Checkout

| Field | Details |
|---|---|
| **Test Case ID** | TC-007 |
| **Requirement ID** | FR6 |
| **Use Case** | UC-006: Borrow Book |
| **Description** | Valid checkout with member meeting all eligibility criteria |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0001 exists, Active status, no fines, has borrowed <5 books; Book ISBN 0747532699 exists with availability >0 |
| **Steps** | 1. Select "Borrow Book" 2. Enter Member ID: LMS-2026-0001 3. Enter ISBN: 0747532699 4. Click Process |
| **Expected Result** | Transaction recorded; Due date = today+14 days; Receipt displayed; Inventory updated (available copies -1); Logged with timestamp (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-008: Borrow Book - Member Has Outstanding Fines

| Field | Details |
|---|---|
| **Test Case ID** | TC-008 |
| **Requirement ID** | FR6 |
| **Use Case** | UC-006: Borrow Book |
| **Description** | Member with unpaid fines cannot borrow |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0002 exists with $5.50 in unpaid fines |
| **Steps** | 1. Select "Borrow Book" 2. Enter Member ID: LMS-2026-0002 3. Enter ISBN: 0747532699 4. Click Process |
| **Expected Result** | Error: "Member has $5.50 in unpaid fines. Fines must be settled before borrowing" |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-009: Borrow Book - Exceeds Borrowing Limit

| Field | Details |
|---|---|
| **Test Case ID** | TC-009 |
| **Requirement ID** | FR6 |
| **Use Case** | UC-006: Borrow Book |
| **Description** | Member cannot borrow more than 5 books at once |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0003 exists with 5 active borrowings |
| **Steps** | 1. Select "Borrow Book" 2. Enter Member ID: LMS-2026-0003 3. Enter ISBN: 0747532699 4. Click Process |
| **Expected Result** | Error: "Borrowing limit reached (5 books). Member must return one book before borrowing more" |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-010: Borrow Book - Book Unavailable

| Field | Details |
|---|---|
| **Test Case ID** | TC-010 |
| **Requirement ID** | FR6 |
| **Use Case** | UC-006: Borrow Book |
| **Description** | Cannot checkout book with zero available copies |
| **Preconditions** | Librarian authenticated; Book with ISBN 0547928219 has 0 available copies (all borrowed) |
| **Steps** | 1. Select "Borrow Book" 2. Enter Member ID: LMS-2026-0001 3. Enter ISBN: 0547928219 4. Click Process |
| **Expected Result** | Error: "Book unavailable. All copies currently borrowed. Next available: [date]" |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-011: Return Book - On-Time Return

| Field | Details |
|---|---|
| **Test Case ID** | TC-011 |
| **Requirement ID** | FR7 |
| **Use Case** | UC-007: Return Book |
| **Description** | Return book on due date with no late fees |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0001 has book ISBN 0747532699 checked out with due date today |
| **Steps** | 1. Select "Return Book" 2. Enter Member ID: LMS-2026-0001 3. Enter ISBN: 0747532699 4. Click Process |
| **Expected Result** | Return recorded; Fine=$0.00; Receipt shows "ON TIME"; Availability +1; Member total fines unchanged; Logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-012: Return Book - Late Return with Fine

| Field | Details |
|---|---|
| **Test Case ID** | TC-012 |
| **Requirement ID** | FR7, FR8 |
| **Use Case** | UC-007: Return Book |
| **Description** | Return book 5 days late; system calculates fine correctly |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0002 has book ISBN 0547928219 checked out with due date 5 days ago |
| **Steps** | 1. Select "Return Book" 2. Enter Member ID: LMS-2026-0002 3. Enter ISBN: 0547928219 4. Click Process (today) |
| **Expected Result** | Return recorded; Fine = 5 × $0.50 = $2.50; Receipt shows "LATE RETURN (5 days)"; Member fine balance += $2.50; Availability +1; Logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-013: Return Book - Fine Exceeds Maximum

| Field | Details |
|---|---|
| **Test Case ID** | TC-013 |
| **Requirement ID** | FR7, FR8 |
| **Use Case** | UC-007: Return Book |
| **Description** | Fine capped at $25 maximum |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0003 has book ISBN 0587123456 checked out with due date 60 days ago |
| **Steps** | 1. Select "Return Book" 2. Enter Member ID: LMS-2026-0003 3. Enter ISBN: 0587123456 4. Click Process |
| **Expected Result** | Return recorded; Raw fine = 60 × $0.50 = $30; Fine capped at $25; Receipt shows "Fine capped at maximum: $25.00"; Member fine += $25; Logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-014: View Member History - Complete Transaction List

| Field | Details |
|---|---|
| **Test Case ID** | TC-014 |
| **Requirement ID** | FR9 |
| **Use Case** | UC-009: View Member History |
| **Description** | Display all past and present borrowing transactions for member |
| **Preconditions** | Librarian authenticated; Member LMS-2026-0001 has 3 past and 1 current borrowing records |
| **Steps** | 1. Select "View Member History" 2. Enter Member ID: LMS-2026-0001 3. View history |
| **Expected Result** | All 4 transactions displayed in table format (most recent first); shows Borrow Date, Title, Return Date, Fine Status; Current fine balance displayed |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-015: Authenticate Librarian - Valid Credentials

| Field | Details |
|---|---|
| **Test Case ID** | TC-015 |
| **Requirement ID** | FR11 |
| **Use Case** | UC-011: Authenticate Librarian |
| **Description** | Valid username and password grants access |
| **Preconditions** | System operational; Librarian account exists (username="librarian1", password correct) |
| **Steps** | 1. System displays login prompt 2. Enter Username: librarian1 3. Enter Password: (correct password) 4. Click Login |
| **Expected Result** | Authentication successful; Session created; Main menu displayed; Login logged with timestamp (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-016: Authenticate Librarian - Invalid Password

| Field | Details |
|---|---|
| **Test Case ID** | TC-016 |
| **Requirement ID** | FR11 |
| **Use Case** | UC-011: Authenticate Librarian |
| **Description** | Invalid password denies access |
| **Preconditions** | System operational; Librarian account "librarian1" exists |
| **Steps** | 1. System displays login prompt 2. Enter Username: librarian1 3. Enter Password: wrongpassword 4. Click Login |
| **Expected Result** | Error: "Invalid username or password"; Access denied; Failed attempt logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-017: Authenticate Librarian - Account Locked

| Field | Details |
|---|---|
| **Test Case ID** | TC-017 |
| **Requirement ID** | FR11 |
| **Use Case** | UC-011: Authenticate Librarian |
| **Description** | Account locked after 5 failed login attempts |
| **Preconditions** | Librarian account "librarian1" has 4 failed attempts |
| **Steps** | 1. System displays login prompt 2. Enter Username: librarian1 3. Enter Password: wrong 4. Click Login (5th attempt) |
| **Expected Result** | Error: "Account locked for security. Contact administrator"; Account locked; No further login attempts allowed; Locked event logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-018: Generate Reports - Circulation Report

| Field | Details |
|---|---|
| **Test Case ID** | TC-018 |
| **Requirement ID** | FR10 |
| **Use Case** | UC-010: Generate Reports |
| **Description** | Generate circulation statistics report |
| **Preconditions** | User authenticated; transaction data exists for current period |
| **Steps** | 1. Select "Generate Reports" 2. Choose "Circulation Summary" 3. Select "This Month" 4. Click Generate |
| **Expected Result** | Report displays: Total checkouts, Returns, Currently borrowed, Active members; Top 10 borrowed books; Monthly trend; Generated with timestamp logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

### TC-019: View Library Statistics - Summary Display

| Field | Details |
|---|---|
| **Test Case ID** | TC-019 |
| **Requirement ID** | FR16 |
| **Use Case** | UC-015: View Library Statistics |
| **Description** | Display library summary statistics |
| **Preconditions** | User authenticated; system has recorded transactions |
| **Steps** | 1. Select "View Library Statistics" 2. View dashboard |
| **Expected Result** | Statistics displayed: Total books, Total members, Currently borrowed, Available count, Utilization %, Members with fines, Total fines; Access logged (FR12) |
| **Actual Result** | *(To be filled during testing)* |
| **Status** | ☐ Pass / ☐ Fail |

---

## Non-Functional Test Cases

### NFT-001: Performance Test - Search Response Time

| Field | Details |
|---|---|
| **Test ID** | NFT-001 |
| **Requirement** | FR1: Performance |
| **Test Name** | Search Books Response Time |
| **Description** | Verify search returns results within 2 seconds for 50,000 book catalog |
| **Test Scenario** | 1. Load system with 50,000 books 2. Submit search query "Harry" 3. Measure response time 4. Repeat 10 times |
| **Expected Result** | All searches complete within 2 seconds (FR1 requirement); Average response time <1 second |
| **Actual Result** | *(To be filled during testing)* |
| **Pass Criteria** | ☐ 100% of searches ≤2 seconds |

---

### NFT-002: Security Test - Authentication & Logging

| Field | Details |
|---|---|
| **Test ID** | NFT-002 |
| **Requirement** | FR11, FR12: Authentication & Logging |
| **Test Name** | Login Security & Audit Trail |
| **Description** | Verify failed login attempts are logged and accounts lock after 5 failures |
| **Test Scenario** | 1. Attempt login with wrong password 5 times 2. Verify account locked on 5th attempt 3. Check activity log for all 5 failed attempts with timestamps |
| **Expected Result** | All failed attempts logged with timestamp and username; Account locked after 5 attempts; Audit trail complete |
| **Actual Result** | *(To be filled during testing)* |
| **Pass Criteria** | ☐ All failed attempts logged ☐ Account locked after 5 attempts ☐ Log entries include timestamp, username, attempt # |

---

### NFT-003: Reliability Test - Data Persistence

| Field | Details |
|---|---|
| **Test ID** | NFT-003 |
| **Requirement** | FR14: Backup & Restore |
| **Test Name** | Data Backup & Restore Verification |
| **Description** | Verify all data persists correctly after system shutdown and restart |
| **Test Scenario** | 1. Register member, borrow book, process return 2. Perform backup 3. Shut down system 4. Restore from backup 5. Verify all data intact |
| **Expected Result** | All transactions persisted; Backup completes successfully; Restore recovers 100% of data; No data loss |
| **Actual Result** | *(To be filled during testing)* |
| **Pass Criteria** | ☐ All member records intact ☐ All transactions intact ☐ All book records intact ☐ Zero data loss |

---

### NFT-004: Usability Test - Menu Navigation

| Field | Details |
|---|---|
| **Test ID** | NFT-004 |
| **Requirement** | FR2-7, FR9, FR10, FR16: System Usability |
| **Test Name** | User Interface Intuitiveness |
| **Description** | Verify new librarian can navigate all main functions without training within 5 minutes |
| **Test Scenario** | 1. Have user complete: search book, register member, process borrow, process return, view history 2. Measure time to complete all tasks 3. Count errors/misclicks |
| **Expected Result** | All tasks completed in <5 minutes; ≤2 errors; User finds functions intuitively |
| **Actual Result** | *(To be filled during testing)* |
| **Pass Criteria** | ☐ Completed in <5 minutes ☐ ≤2 errors ☐ User indicates "Easy" or "Very Easy" |

---

### NFT-005: Maintainability Test - Code Organization

| Field | Details |
|---|---|
| **Test ID** | NFT-005 |
| **Requirement** | System Design Quality |
| **Test Name** | Code Structure & Documentation |
| **Description** | Verify code is well-organized, documented, and maintainable for future updates |
| **Test Scenario** | 1. Review code organization (separation of concerns) 2. Verify inline comments on complex logic 3. Check method naming clarity 4. Review error handling |
| **Expected Result** | Clear layered architecture (Presentation, Business Logic, Data Access); Meaningful method names; Proper error handling; Code documented |
| **Actual Result** | *(To be filled during testing)* |
| **Pass Criteria** | ☐ Layered architecture evident ☐ Methods clearly named ☐ Complex logic documented ☐ Error handling implemented |

---



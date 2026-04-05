# Agile Planning Document
## Library Management System — Assignment 6

---

## 1. User Story Creation


| Story ID | User Story | Acceptance Criteria | Priority | FR / UC Ref |
|----------|------------|---------------------|----------|-------------|
| US-001 | As a Librarian, I want to log in with my credentials so that I can access the system securely. | Login succeeds with valid credentials; invalid credentials display an error; session is established before any other operation is permitted. | High | FR11 / UC-011 |
| US-002 | As a Librarian, I want to add a new book to the catalog so that the library's collection stays current. | Book saved with title, author, ISBN, genre, and copy count; duplicate ISBN rejected with an error message. | High | FR1 / UC-001 |
| US-003 | As a Librarian, I want to search for books by title, author, or ISBN so that I can locate items quickly. | Results returned in under 2 seconds; availability status displayed alongside each result. | High | FR2 / UC-005 |
| US-004 | As a Librarian, I want to record a borrowing transaction so that member checkouts are tracked accurately. | Transaction saved with member ID, book ID, and due date; available copy count decremented; duplicate borrow by same member rejected. | High | FR3 / UC-006 |
| US-005 | As a Librarian, I want to process a book return so that the catalog reflects current availability. | Book marked available; return date recorded; overdue flag set if returned after due date. | High | FR4 / UC-007 |
| US-006 | As a Librarian, I want to calculate and record fines for overdue books so that members are held accountable. | Fine computed per day overdue using the configured rate; amount recorded against the member's record. | Medium | FR8 / UC-010 |
| US-007 | As a Head Librarian, I want to generate usage and inventory reports so that I can make informed collection decisions. | Report generated with accurate totals; output saved to a file; covers borrowing activity and inventory levels. | Medium | FR6 / UC-009 |
| US-008 | As a Librarian, I want to register and manage library members so that borrowing privileges can be controlled. | Member created with ID, name, and contact info; duplicate member ID rejected; member record retrievable by ID. | High | FR5 |
| US-009 | As a Head Librarian, I want to view the full inventory with stock levels so that I can identify shortages. | All books listed with available and borrowed counts; items with zero available copies flagged. | Medium | FR10 |
| US-010 | As an External Auditor, I want to review all system transaction logs so that compliance can be verified. | Logs display all transactions with timestamps and actor IDs; auditor has read-only access with no modification possible. | Low | FR15 / UC-015 |
| US-011 | As a System Administrator, I want user credentials stored in hashed format so that security compliance is met. | No plain-text passwords stored in any file; hashing applied on account creation and on login verification. | High | FR16 |

---

## 2. Product Backlog



| Story ID | User Story | MoSCoW | Story Points | Dependencies |
|----------|------------|--------|--------------|--------------|
| US-001 | Librarian login and authentication | Must-have | 2 | None |
| US-011 | Hash and secure stored credentials | Must-have | 3 | None |
| US-008 | Register and manage library members | Must-have | 3 | US-001 |
| US-002 | Add new book to catalog | Must-have | 3 | US-001 |
| US-003 | Search books by title, author, or ISBN | Must-have | 3 | US-002 |
| US-004 | Record borrowing transaction | Must-have | 3 | US-003, US-008 |
| US-005 | Process book return | Must-have | 2 | US-004 |
| US-006 | Calculate and record overdue fines | Should-have | 3 | US-005 |
| US-007 | Generate usage and inventory reports | Should-have | 5 | US-004, US-005 |
| US-019 | View full inventory with stock levels | Should-have | 2 | US-002 |

| US-010 | Review system transaction logs (audit) | Could-have | 2 | US-004, US-005 |

### Prioritisation Justification

**Must-have** stories (US-001, US-002, US-003, US-004, US-005, US-008, US-011) form the minimum viable core of the system. Without authentication, catalog management, member management, and the borrow/return cycle, no library operation is possible. Security (US-011) is Must-have because storing plain-text credentials in a file-based system creates an unacceptable risk from the outset.

**Should-have** stories (US-006, US-007, US-009) add significant operational value — fines enforce accountability, reports support decision-making, and inventory views enable proactive stock management — but the system can deliver its core function without them in a first release.

**Could-have** story (US-010) represents an enhancement. Audit log access serves compliance requirements but is not required for day-to-day library operations and is deferred to a future sprint.

---

## 3. Sprint Plan

### Sprint Goal

> Implement core authentication, catalog management, member registration, and the full borrow/return cycle to deliver a functional Minimum Viable Product of the Library Management System.

This sprint targets the six Must-have stories that represent the complete operational loop: a Librarian logs in, manages members and the book catalog, records borrowing transactions, and processes returns. Completing these six stories in two weeks establishes the MVP from which subsequent sprints can layer enhancements.

**Selected stories:** US-001, US-008, US-002, US-003, US-004, US-005  
**Combined story points:** 2 + 3 + 3 + 3 + 3 + 2 = **16 points**  
**Sprint duration:** 2 weeks

### Sprint Backlog

| Task ID | Task Description | Story | Est. Hours | Status |
|---------|-----------------|-------|------------|--------|
| T-001 | Implement CLI login prompt and session initialisation | US-001 | 4 hrs | To Do |
| T-002 | Validate credentials against hashed values in file store | US-001 | 4 hrs | To Do |
| T-003 | Return descriptive error on invalid login attempt | US-001 | 2 hrs | To Do |
| T-004 | Build member registration CLI command | US-008 | 4 hrs | To Do |
| T-005 | Persist member record to file; reject duplicate IDs | US-008 | 3 hrs | To Do |
| T-006 | Build add-book CLI command with all required fields | US-002 | 4 hrs | To Do |
| T-007 | Implement ISBN duplicate check before saving | US-002 | 3 hrs | To Do |
| T-008 | Persist book record to file-based catalog store | US-002 | 2 hrs | To Do |
| T-009 | Build search command with title, author, and ISBN filters | US-003 | 5 hrs | To Do |
| T-010 | Display search results with real-time availability status | US-003 | 3 hrs | To Do |
| T-011 | Build borrow-book command; assign member, book, and due date | US-004 | 4 hrs | To Do |
| T-012 | Decrement available copy count on successful borrow | US-004 | 3 hrs | To Do |
| T-013 | Build return-book command and record return date | US-005 | 4 hrs | To Do |
| T-014 | Increment availability; set overdue flag if past due date | US-005 | 3 hrs | To Do |

**Total estimated effort: 48 hours**

---



## 4. Reflection
 The This assignment was very challenging. At first glance, writing a user story seems simple enough: a sentence in a fixed format. But the real difficulty showed up the moment I had to decide which stories mattered more than others, and then define exactly what "done" looks like for each one. Acceptance criteria forced me to track multiple variables at once — what the system should do, what it should reject, what it should display — and then align all of that with the functional requirements and use cases from prior assignments. Keeping everything consistent across those layers was genuinely hectic. One wrong assumption in an acceptance criterion could break traceability back to Assignment 4 or 5, so every line required careful thought.

The product backlog felt, in some ways, like a continuation of that same problem. It was not an entirely new challenge — it was more like another angle on the same question of prioritisation. The MoSCoW method was something I had to go and read about before I could apply it properly, and even after reading, deciding what truly belongs in Must-have versus Should-have required real deliberation. Effort estimation added another layer of complexity. Story points, especially using the Fibonacci sequence, are not intuitive at first. The idea that you are estimating relative complexity rather than actual hours is a mental shift that takes time to internalise. There were moments where I found myself converting back and forth between points and hours just to feel grounded in what I was committing to.

Using GitHub Issues, Projects, and Milestones was more straightforward than the content itself. I understood the logic behind it — issues represent individual stories, the project board visualises the workflow, and milestones group stories into a sprint. Setting it up made sense as a process. That said, I am aware that my understanding is still fairly basic at this point. I have never worked in a real team using these tools, so I am applying them somewhat mechanically. I expect that working professionally with a team in the future will give me a much deeper understanding of why these tools are structured the way they are, and how they actually support collaboration in practice.

What this assignment made clear overall is that Agile planning is not just documentation — there is a lot of logic running underneath all of it. Whether it is user story creation, backlog prioritisation, or sprint planning, every step requires you to account for many factors simultaneously and make deliberate decisions about what matters, what can wait, and what the system actually needs to do first. Doing this alone, without a team to debate and negotiate with, highlighted just how much of Agile is designed for group work. The prioritisation, the estimation, the planning — all of it would be richer and more grounded with other perspectives in the room. That is something I am looking forward to experiencing properly when the opportunity comes.
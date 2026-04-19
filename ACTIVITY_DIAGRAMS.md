# Activity Diagrams
## Library Management System — Assignment 8

---

## AD-001: Librarian Login

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B[Enter username and password]
        G[Re-enter credentials]
        STOP2([Stop])
    end
    subgraph System
        C[Retrieve stored credentials]
        D{Credentials valid?}
        E[Establish session]
        F[Log successful attempt with timestamp - FR12]
        H[Display error message]
        I[Log failed attempt with timestamp - FR12]
        J{Librarian retries?}
        K[Exit system]
    end
    B --> C --> D
    D -->|Yes| E & F
    E & F --> STOP1([Stop])
    D -->|No| H --> I --> J
    J -->|Yes| G --> C
    J -->|No| K --> STOP2
```

**Stakeholder concerns:** Once the system validates the credentials, it established the librarian session and record it at the same time. Failed attempts are always logged, meeting the System Administrator audit requirement. No feature is accessible before authentication, implementing FR11.

**Mapping:** FR11, FR12 | US-001 | T-001, T-002, T-003

---

## AD-002: Add and Update Book

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B{Adding new book?}
        C[Enter book details]
        M[Enter ISBN to locate record]
        N[Enter updated fields]
        STOP1([Stop])
        STOP2([Stop])
    end
    subgraph System
        D{Fields valid?}
        E{ISBN unique?}
        F[Save book to catalog]
        G[Set availability status]
        H[Log add operation - FR12]
        I[Display success]
        J[Display duplicate ISBN error]
        K[Display validation error]
        L[Look up book in catalog]
        O{Book found?}
        P[Save changes]
        Q[Update availability]
        R[Log update - FR12]
        S[Display updated]
        U[Display not found error]
    end
    B -->|Yes| C --> D
    D -->|Yes| E
    D -->|No| K --> STOP1
    E -->|Yes| F & G --> H & I --> STOP1
    E -->|No| J --> STOP1
    B -->|No| M --> L --> O
    O -->|Yes| N --> P & Q --> R & S --> STOP2
    O -->|No| U --> STOP2
```

**Stakeholder concerns:** Validation before save prevents bad data. Availability updates in parallel with save so search results always reflect current stock. All catalog changes are audit-logged for the External Auditor.

**Mapping:** FR2, FR3 | US-002 | T-006, T-007, T-008

---

## AD-003: Delete Book

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B[Enter book ISBN]
        G[Enter removal reason]
        H[Confirm deletion]
        STOP1([Stop])
    end
    subgraph System
        C[Look up book in catalog]
        D{Book found?}
        E{Book currently on loan?}
        F[Display cannot delete - book is borrowed]
        I{Reason provided?}
        J[Remove book from catalog]
        K[Record reason and timestamp - FR4]
        L[Log deletion with librarian ID - FR12]
        M[Display book removed]
        N[Display reason required error]
        O[Display not found error]
    end
    B --> C --> D
    D -->|Yes| E
    D -->|No| O --> STOP1
    E -->|Yes| F --> STOP1
    E -->|No| G --> H --> I
    I -->|Yes| J & K & L --> M --> STOP1
    I -->|No| N --> STOP1
```

**Stakeholder concerns:** Borrowed books cannot be deleted, protecting catalog integrity. Mandatory removal reason supports the External Auditor's compliance requirement. Parallel logging captures the deletion at the exact moment it is executed.

**Mappingy:** FR4 | SD-001

---

## AD-004: Borrow Book

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B[Search book by title, author, or ISBN - FR1]
        B --> C[Enter member ID]
        STOP1([Stop])
    end
    subgraph System
        D{Member account active?}
        E{No outstanding fines?}
        F{No overdue books?}
        G{Within borrow limit?}
        H{Copies available?}
        I[Set due date = today + 14 days]
        J[Create loan record]
        K[Decrement available copy count]
        L[Log borrow transaction - FR12]
        M[Generate and display receipt]
        ERR[Display appropriate error]
    end
    C --> D
    D -->|Yes| E
    D -->|No| ERR --> STOP1
    E -->|Yes| F
    E -->|No| ERR
    F -->|Yes| G
    F -->|No| ERR
    G -->|Yes| H
    G -->|No| ERR
    H -->|Yes| I --> J & K & L --> M --> STOP1
    H -->|No| ERR
```

**Stakeholder concerns:** All five eligibility checks run automatically before any loan is created. Parallel fork on success ensures the loan record, copy count, and audit log are all updated together. Receipt generation gives the Librarian immediate confirmation.

**Mapping:** FR1, FR6 | US-003, US-004 | T-009, T-010, T-011, T-012

---

## AD-005: Return Book and Calculate Fine

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B[Enter member ID and book ISBN]
        STOP1([Stop])
    end
    subgraph System
        C[Locate active loan record]
        D{Loan record found?}
        E[Record return date and time]
        F{Return date after due date?}
        G[Calculate days overdue]
        H[Calculate fine amount]
        I[Issue fine to member record]
        J[Update loan to Overdue-Returned]
        K[Update loan to Returned]
        L[Increment available copy count]
        M[Log return transaction - FR12]
        N[Display confirmation]
        O[Display no active loan error]
    end
    B --> C --> D
    D -->|Yes| E --> F
    D -->|No| O --> STOP1
    F -->|Yes| G --> H --> I & J --> L & M --> N --> STOP1
    F -->|No| K --> L & M --> N
```

**Stakeholder concerns:** Fine is computed automatically without manual input. Availability and audit log are updated in parallel, ensuring real-time inventory accuracy. Return timestamp is always captured, supporting FR7 overdue auto-detection.

**Mapping:** FR7, FR8 | US-005, US-006 | T-013, T-014

---

## AD-006: Register and Manage Member

```
flowchart TD
    subgraph Librarian
        A([Start]) --> B{Registering new member?}
        C[Enter member details]
        M[Enter member ID]
        P[Select new status]
        STOP1([Stop])
    end
    subgraph System
        D{Fields valid?}
        E{Formats valid?}
        F{Member already exists?}
        G[Auto-generate member ID]
        H[Set status to Active]
        I[Save member record]
        J[Log registration - FR12]
        K[Display member registered]
        L[Display member exists error]
        N[Retrieve member record]
        O[Display member details and history - FR9]
        Q[Update member status]
        R[Log status change - FR12]
        S[Display status updated]
        ERR[Display validation error]
    end
    B -->|Yes| C --> D
    D -->|Yes| E
    D -->|No| ERR --> STOP1
    E -->|Yes| F
    E -->|No| ERR
    F -->|No| G & H --> I & J --> K --> STOP1
    F -->|Yes| L --> STOP1
    B -->|No| M --> N --> O --> P --> Q & R --> S --> STOP1
```

**Stakeholder concerns:** Sequential validation prevents bad data. Auto-generated member ID removes ambiguity. Transaction history is displayed before any status change, giving the Librarian context. Status update and log entry are written in parallel.

**Mapping:** FR5, FR9 | US-008 | T-004, T-005

---

## AD-007: Generate Reports and View Statistics

```
flowchart TD
    subgraph HeadLibrarian
        A([Start]) --> B{Generating report?}
        C[Select report type]
        STOP1([Stop])
    end
    subgraph System
        D[Query borrowing data]
        E[Query inventory data]
        F[Identify top 20 most-borrowed books]
        G[Compile report]
        H{Export to file?}
        I[Save report to file]
        J[Display report on screen]
        K[Log report generation - FR12]
        L[Count total books]
        M[Count total members]
        N[Count borrowed books]
        O[Compile statistics summary - FR16]
        P[Display statistics]
    end
    B -->|Yes| C --> D & E --> F --> G --> H
    H -->|Yes| I & K --> STOP1
    H -->|No| J & K --> STOP1
    B -->|No| L & M & N --> O --> P --> STOP1
```

**Stakeholder concerns:** Parallel data queries reduce response time. Top-20 calculation directly meets FR10 acceptance criteria. Statistics view computes all counts simultaneously. All report generation is logged for compliance.

**Mapping:** FR10, FR16 | US-007, US-009

---

## AD-008: View Audit Logs and Data Backup

```
flowchart TD
    subgraph AdminAuditor
        A([Start]) --> B{Viewing audit logs?}
        C[Specify filter criteria]
        EX{Export logs?}
        STOP1([Stop])
    end
    subgraph SysAdmin
        BA{Performing backup?}
        SEL[Select backup file]
    end
    subgraph System
        D[Retrieve all log entries]
        E{Filters applied?}
        F[Apply date filter]
        G[Apply action type filter]
        H[Display logs read-only - FR13]
        I[Export logs to file]
        J[Backup books data]
        K[Backup members data]
        L[Backup transactions data]
        M[Store backup with timestamp]
        N[Display backup complete]
        O[Validate backup file]
        P{File valid?}
        Q[Restore system data]
        R[Display restore complete]
        S[Display invalid file error]
    end
    B -->|Yes| C --> D --> E
    E -->|Yes| F & G --> H
    E -->|No| H
    H --> EX
    EX -->|Yes| I --> STOP1
    EX -->|No| STOP1
    B -->|No| BA
    BA -->|Yes| J & K & L --> M --> N --> STOP1
    BA -->|No| SEL --> O --> P
    P -->|Yes| Q --> R --> STOP1
    P -->|No| S --> STOP1
```

**Stakeholder concerns:** Read-only display enforces FR13. Parallel filters meet the date and action-type filtering requirement. Parallel backup of all three data stores ensures nothing is missed. File integrity check before restore protects live data.

**Mapping:** FR12, FR13, FR14 | US-010

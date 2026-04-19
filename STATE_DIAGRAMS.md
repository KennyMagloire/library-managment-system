# State Transition Diagrams
## Library Management System — Assignment 8

---

## SD-001: Book

```
stateDiagram-v2
    [*] --> Available : addBook()
    Available --> CheckedOut : borrowBook()
    CheckedOut --> Returned : returnBook() on time
    CheckedOut --> Overdue : autoFlag() due date passed
    Overdue --> Returned : returnBook() late
    Returned --> Available : updateAvailability()
    Available --> Damaged : reportDamaged()
    Available --> Lost : reportLost()
    Damaged --> Available : repaired()
    Damaged --> PendingRemoval : removeBook()
    Lost --> PendingRemoval : removeBook()
    PendingRemoval --> [*] : removalConfirmed()
```

**Key States:** Available, CheckedOut, Overdue, Returned, Damaged, Lost, PendingRemoval

**FR Mapping:** FR2 (add book), FR3 (update book), FR4 (delete book), FR6 (borrow), FR7 (return), FR8 (fine triggered on Overdue)

---

## SD-002: LoanRecord

```
stateDiagram-v2
    [*] --> Active : createLoan()
    Active --> Returned : processReturn() on time
    Active --> Overdue : autoFlag() due date passed
    Overdue --> Returned : processReturn() late
    Returned --> Closed : noFineOutstanding()
    Returned --> PendingFine : fineIssued()
    PendingFine --> Closed : fineSettled()
    Closed --> [*]
```

**Key States:** Active, Overdue, Returned, PendingFine, Closed

**FR Mapping:** FR6 (create loan), FR7 (return), FR8 (fine), FR9 (member history), FR12 (logging)

---

## SD-003: Fine

```
stateDiagram-v2
    [*] --> Issued : calculateFine()
    Issued --> PendingPayment : notifyLibrarian()
    PendingPayment --> Paid : processPayment()
    PendingPayment --> Waived : waiveFine()
    Paid --> [*]
    Waived --> [*]
```

**Key States:** Issued, PendingPayment, Paid, Waived

**FR Mapping:** FR8 (calculate fine), FR9 (fine history), FR12 (waiver logged)

---

## SD-004: MemberProfile

```
stateDiagram-v2
    [*] --> Active : registerMember()
    Active --> Suspended : suspendMember()
    Suspended --> Active : reinstateAccount()
    Active --> Inactive : deactivateMember()
    Inactive --> Active : reactivateMember()
    Inactive --> [*] : permanentRemoval()
```

**Key States:** Active, Suspended, Inactive

**FR Mapping:** FR5 (register member), FR6 (Suspended blocks borrowing), FR9 (member history)

---

## SD-005: LibrarianSession

```
stateDiagram-v2
    [*] --> Unauthenticated : systemStart()
    Unauthenticated --> Authenticated : login() valid credentials
    Unauthenticated --> Unauthenticated : login() invalid credentials
    Authenticated --> Expired : sessionTimeout()
    Authenticated --> Terminated : logout()
    Expired --> Unauthenticated : sessionReset()
    Terminated --> [*]
```

**Key States:** Unauthenticated, Authenticated, Expired, Terminated

**FR Mapping:** FR11 (authentication blocks all features), FR12 (login attempts logged)

---

## SD-006: LibrarianAccount

```
stateDiagram-v2
    [*] --> Active : createAccount()
    Active --> Inactive : deactivateAccount()
    Inactive --> Active : reactivateAccount()
    Active --> Deactivated : permanentDeactivation()
    Inactive --> Deactivated : permanentDeactivation()
    Deactivated --> [*]
```

**Key States:** Active, Inactive, Deactivated

**FR Mapping:** FR15 (all transitions admin-only), FR12 (account actions logged)

---

## SD-007: AuditLog

```
stateDiagram-v2
    [*] --> Created : logOperation()
    Created --> Finalized : attachTimestamp()
    Finalized --> Archived : archiveLogs()
    Archived --> [*]
```

**Key States:** Created, Finalized, Archived

**FR Mapping:** FR12 (operation tracking), FR13 (read-only view), FR14 (archived for backup)

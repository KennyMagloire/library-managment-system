# Assignment 5: Use Case Specifications (CORRECTED)

## Overview


This document provides detailed specifications for critical use cases that implement the defined  functional requirements 

---

## Use Case 1: Authenticate Librarian

### Use Case ID
UC-011

### Requirement Alignment
**Primary:** FR11 (Library Authentication)  
**Secondary:** FR12 (Operation Tracking)

### Actor
**Librarian**, **System Administrator**

### Description
Librarian logs in with username and password. System validates credentials, creates authenticated session, and grants access to all librarian functions. **NB: all other librarian operations depend on successful authentication.**

### Preconditions
- System is operational and running
- Librarian account exists in system
- Login interface is accessible

### Postconditions
- Librarian authenticated (session created)
- Access granted to all librarian functions (UC-001 through UC-009)
- Login action logged with timestamp (FR12)
- Session maintains authentication state

### Extension Point
**Extension Point Name:** N/A (foundational use case - other use cases extend from this)

### Basic Flow (Success Scenario)

1. System displays login prompt
2. Librarian enters username and password
3. Librarian submits credentials
4. System validates username exists and password matches
5. System creates authenticated session and initializes librarian context
6. System logs successful login with timestamp (FR12)
7. System displays main menu with available functions

### Sample Output
```
LIBRARY MANAGEMENT SYSTEM - LOGIN

Username: librarian1
Password: ●●●●●●●●●●

[Login]

Welcome, Librarian1!
Login successful at 2026-03-29 09:30:15

MAIN MENU
1. Search Books
2. Add Book
3. Update Book
4. Delete Book
5. Register Member
6. Borrow Book
7. Return Book
8. View Member History
9. Generate Reports
10. Logout
```

### Alternative Flows

#### Alternative Flow 1: Invalid Username
- **Trigger:** Librarian enters non-existent username
- **Steps:**
  1. System validates username
  2. System finds no match
  3. System displays: "Invalid username or password"
  4. System logs: "LOGIN FAILED - Invalid username" (FR12)
  5. After 5 failed attempts: Account locked
- **Result:** Authentication fails

#### Alternative Flow 2: Incorrect Password
- **Trigger:** Librarian enters wrong password
- **Steps:**
  1. System validates username (found)
  2. System validates password (mismatch)
  3. System displays: "Invalid username or password"
  4. System logs: "LOGIN FAILED - Invalid password" (FR12)
  5. After 5 failed attempts: Account locked
- **Result:** Authentication fails; account locked after repeated failures

#### Alternative Flow 3: Account Inactive
- **Trigger:** Librarian account has been deactivated
- **Steps:**
  1. System finds username
  2. System checks account status
  3. System detects status = "Inactive"
  4. System displays: "Your account is inactive. Contact administrator"
  5. System logs: "LOGIN BLOCKED - Account inactive" (FR12)
- **Result:** Authentication blocked

### Acceptance Criteria
- [ ] Valid credentials grant immediate access
- [ ] Invalid credentials deny access with clear message
- [ ] Failed login attempts logged with timestamp (FR12)
- [ ] Account locked after 5 failed attempts
- [ ] Locked account displays appropriate message
- [ ] Authenticated session created for valid login
- [ ] Librarian ID maintained for all operations (FR12)
- [ ] All login attempts logged (successful and failed)

### Business Rules
- **FOUNDATIONAL:** All other librarian use cases require successful authentication
- **Session Management:** One session per librarian; new login replaces previous session
- **Failed Attempts:** 5 consecutive failures locks account (requires admin unlock)
- **Logging:** All attempts (success/failure) logged with timestamp, username (FR12)

---

## Use Case 2: Search Books

### Use Case ID
UC-001

### Requirement Alignment
**Primary:** FR1 (Search Books)  
**Secondary:** FR16 (Library Statistics) - provides data for stats

### Actor
**Librarian**

### Description
Librarian searches the book catalog by title, author, or ISBN. System returns matching results with availability information within 2 seconds (performance requirement).

### Preconditions
- Librarian is authenticated and logged in (FR11)
- Book catalog is loaded and accessible
- System is operational

### Postconditions
- Search results displayed with availability information
- No changes to system data (read-only operation)
- Search execution time logged (FR12)

### Extension Point
**Extension Point Name:** Performance Monitoring
- **Description:** If search exceeds 2 seconds, system displays "Searching..." message

### Basic Flow (Success Scenario)

1. Librarian selects "Search Books" option
2. Librarian enters search criteria (title/author/ISBN)
3. Librarian submits search
4. System searches catalog and retrieves matching books
5. System displays results with availability within 2 seconds (FR1 requirement)
6. Librarian views results (Title, Author, ISBN, Category, Availability)

### Sample Output
```
SEARCH RESULTS FOR: "Harry Potter"

Results found: 2 books

1. Harry Potter and the Sorcerer's Stone
   Author: J.K. Rowling | ISBN: 0747532699
   Category: Fiction | Availability: Available (2 of 5)

2. Harry Potter and the Chamber of Secrets
   Author: J.K. Rowling | ISBN: 0747538492
   Category: Fiction | Availability: Currently Borrowed (0 of 4)
   Next available: March 20, 2026
```

### Alternative Flows

#### Alternative Flow 1: No Results Found
- **Trigger:** Search term matches no books in catalog
- **Steps:**
  1. System searches catalog
  2. No matches found
  3. System displays: "No books found matching 'SEARCH_TERM'"
  4. System offers to retry with different search
- **Result:** User informed; can search again

#### Alternative Flow 2: Partial Text Match
- **Trigger:** User searches "Art" → System finds "Art of War"
- **Steps:**
  1. System performs partial string matching
  2. System displays all results containing search term
  3. Results may include approximate matches
- **Result:** User finds books through partial matching

#### Alternative Flow 3: Search Takes > 2 Seconds
- **Trigger:** Large catalog (50,000 books) or system slow
- **Steps:**
  1. User submits search
  2. After 2 seconds with no results
  3. System displays: "Searching... Please wait"
  4. Results display when available
  5. System logs performance issue (FR12)
- **Result:** User aware of delay; not left wondering

### Acceptance Criteria
- [ ] Search returns results within 2 seconds (FR1)
- [ ] Partial text matches work (e.g., "Art" finds "Art of War")
- [ ] Results include: Title, Author, ISBN, Category, Availability
- [ ] Availability shows count (e.g., "2 of 5 copies available")
- [ ] "Book not found" message is clear
- [ ] Search is case-insensitive
- [ ] Search operation logged with timestamp (FR12)

---

## Use Case 3: Register Member

### Use Case ID
UC-005

### Requirement Alignment
**Primary:** FR5 (Register Member)  
**Secondary:** FR12 (Operation Tracking)

### Actor
**Librarian**

### Description
Librarian registers a new library member by collecting personal information. System validates data, auto-generates unique member ID, sets membership expiry to 1 year, and stores the record.

### Preconditions
- Librarian is authenticated and logged in (FR11)
- Patron has decided to become a member
- No existing account with same email exists

### Postconditions
- New member record created and saved
- Unique member ID generated (e.g., LMS-2026-0001)
- Member status set to "Active"
- Membership expiry date calculated (1 year from today)
- Confirmation provided to librarian and patron
- Registration action logged (FR12)

### Extension Point
**Extension Point Name:** Validation
- **Description:** Validates email format, phone number format, required fields, no duplicate email

### Basic Flow (Success Scenario)

1. Librarian selects "Register Member"
2. Librarian enters member information (Name, Email, Phone, Address, DOB)
3. Librarian submits registration form
4. System validates all required fields and email format
5. System checks for duplicate email
6. System generates unique member ID (LMS-YYYY-NNNN)
7. System calculates membership expiry (today + 1 year)
8. System saves member record with status "Active" and $0.00 fine balance
9. System logs registration action with timestamp (FR12)
10. System displays confirmation with member ID and details

### Sample Output
```
MEMBER REGISTRATION SUCCESSFUL

Member ID: LMS-2026-0523
Name: John Smith
Email: john.smith@university.edu
Phone: (555) 123-4567
Address: 123 Main Street

Membership Expiry: March 29, 2027
Status: ACTIVE ✓

Borrowing Limits:
  • Maximum books: 5 at a time
  • Borrowing period: 14 days
  • Late fee: $0.50 per day (max $25)
```

### Alternative Flows

#### Alternative Flow 1: Email Already Registered
- **Trigger:** User enters email that already exists
- **Steps:**
  1. System validates email
  2. System finds existing record
  3. System displays: "This email is already registered"
  4. System offers options: "Login or use different email"
- **Result:** Duplicate registration prevented

#### Alternative Flow 2: Invalid Email Format
- **Trigger:** User enters "john@example" (missing domain extension)
- **Steps:**
  1. System validates email format
  2. Format validation fails
  3. System displays: "Invalid email format. Example: john@domain.com"
  4. User corrects and resubmits
- **Result:** Email format enforced

#### Alternative Flow 3: Required Field Missing
- **Trigger:** User leaves "Phone" field empty
- **Steps:**
  1. System checks all required fields
  2. Detects missing phone number
  3. System displays: "Phone number is required"
  4. User enters phone and resubmits
- **Result:** All required fields enforced

### Acceptance Criteria
- [ ] Registration completes successfully with valid data
- [ ] Unique member ID generated automatically
- [ ] Email format validated
- [ ] Duplicate emails prevented
- [ ] All required fields validated
- [ ] Membership expiry set correctly (today + 1 year)
- [ ] Member status set to "Active"
- [ ] Member can immediately begin borrowing
- [ ] Confirmation displayed with full member details
- [ ] Registration action logged with timestamp (FR12)

---

## Use Case 4: Borrow Book

### Use Case ID
UC-006

### Requirement Alignment
**Primary:** FR6 (Borrow Book)  
**Secondary:** FR1 (Search), FR8 (Fine), FR12 (Logging)

### Actor
**Librarian**

### Description
Librarian processes book checkout for a member. System verifies member eligibility (active status, no outstanding fines, borrowing limit not exceeded), checks book availability, records transaction, sets 14-day due date, and updates inventory.

### Preconditions
- Librarian is authenticated and logged in (FR11)
- Member exists and is registered
- Book exists in catalog with available copies
- Member is physically present or patron details confirmed

### Postconditions
- Borrowing transaction recorded with transaction ID
- Book availability decreased by 1
- Due date set to exactly 14 days from checkout
- Member's borrowing record updated
- Receipt provided showing all details
- All changes persisted to storage
- Checkout action logged (FR12)

### Extension Point
**Extension Point Name:** Check Availability
- **Description:** Validates member status (Active), no outstanding fines, borrowing limit (5 books max), book availability

### Basic Flow (Success Scenario)

1. Librarian enters member ID
2. System retrieves member record and validates status (Active), no fines, borrowing limit < 5
3. Librarian enters book ISBN
4. System retrieves book record and validates availability (>0 copies)
5. System calculates due date (today + 14 days)
6. System creates borrowing record, updates inventory (-1), persists changes
7. System logs checkout with timestamp (FR12)
8. System displays receipt with member name, book details, due date
9. Librarian provides receipt to member

### Sample Output
```
═══════════════════════════════════════════════════════════
LIBRARY CHECKOUT RECEIPT
═══════════════════════════════════════════════════════════

Member: John Smith | ID: LMS-2026-0523
Checkout Date: March 29, 2026

Title: Harry Potter and the Sorcerer's Stone
Author: J.K. Rowling | ISBN: 0747532699

Due Date: April 12, 2026 (14 days)
Late Fee: $0.50/day (max $25)

Books Currently Borrowed: 1 of 5
Fines Owed: $0.00
═══════════════════════════════════════════════════════════
```

### Alternative Flows

#### Alternative Flow 1: Member Has Outstanding Fines
- **Trigger:** Member has unpaid fines > $0.00
- **Steps:**
  1. System retrieves member fine balance
  2. System detects outstanding fines
  3. System displays: "Member has $X.XX in unpaid fines"
  4. System displays: "Fines must be settled before borrowing"
  5. Librarian assists member with payment
  6. Once fines paid, checkout proceeds
- **Result:** Fines collected before borrowing allowed

#### Alternative Flow 2: Member Exceeds Borrowing Limit
- **Trigger:** Member already has 5 books checked out
- **Steps:**
  1. System counts active borrowing records
  2. System detects count = 5
  3. System displays: "Borrowing limit reached (5 books)"
  4. System displays: "Member must return one book before borrowing more"
  5. Checkout cancelled
- **Result:** Limit enforced

#### Alternative Flow 3: Book Not Available
- **Trigger:** All copies currently borrowed (AvailableCopies = 0)
- **Steps:**
  1. System checks book availability
  2. System finds AvailableCopies = 0
  3. System displays: "Book unavailable. All copies currently borrowed"
  4. System shows next available date
- **Result:** User informed; alternative options provided

#### Alternative Flow 4: Member Not Found
- **Trigger:** Librarian enters invalid member ID
- **Steps:**
  1. System searches for member ID
  2. System finds no match
  3. System displays: "Member not found"
  4. System offers: "Check ID or register new member"
- **Result:** No checkout to invalid member

### Acceptance Criteria
- [ ] Checkout validates member is "Active"
- [ ] Checkout validates member has NO outstanding fines
- [ ] Checkout validates member doesn't exceed 5-book limit
- [ ] Checkout validates book has available copies
- [ ] Due date set to exactly 14 days from checkout
- [ ] Receipt displays member name, book details, due date
- [ ] Inventory updated immediately
- [ ] Transaction persisted to storage
- [ ] Checkout logged with timestamp (FR12)

---

## Use Case 5: Return Book

### Use Case ID
UC-007

### Requirement Alignment
**Primary:** FR7 (Return Book)  
**Secondary:** FR8 (Calculate Fine), FR12 (Logging)

### Actor
**Librarian**

### Description
Librarian processes book return. System records return date/time, automatically calculates any overdue fines, updates book availability, updates member fine balance, and generates receipt.

### Preconditions
- Librarian is authenticated and logged in (FR11)
- Borrowing record exists for member + book
- Book is physically returned

### Postconditions
- Return date and time recorded
- Fine calculated if overdue
- Book availability increased by 1
- Member fine balance updated (if fine applies)
- Borrowing record status set to "Returned"
- Receipt provided confirming return and any fines
- All changes persisted
- Return action logged (FR12)

### Extension Point
**Extension Point Name:** Late Return
- **Description:** Calculates overdue fines if return date > due date; caps fine at $25 maximum

### Basic Flow (Success Scenario)

1. Librarian enters member ID and book ISBN
2. System retrieves borrowing record and validates it exists
3. System records return date and time
4. System calculates days overdue and fine amount (days_overdue × $0.50, capped at $25)
5. System updates member fine balance, updates book availability (+1), sets record status to "Returned"
6. System persists all changes
7. System logs return with timestamp (FR12)
8. System displays receipt with return status and fine amount
9. Librarian provides receipt to member

### Sample Output (On-Time Return)
```
LIBRARY RETURN RECEIPT

Member: John Smith | ID: LMS-2026-0523
Return Date: April 12, 2026 at 10:30 AM

Title: Harry Potter and the Sorcerer's Stone
Author: J.K. Rowling | ISBN: 0747532699

Checkout Date: March 29, 2026
Due Date: April 12, 2026
Return Date: April 12, 2026

Status: ✓ ON TIME

Fine: $0.00
Total Fines Owed: $0.00
```

### Sample Output (Late Return)
```
LIBRARY RETURN RECEIPT

Member: Jane Doe | ID: LMS-2026-0512
Return Date: April 17, 2026

Title: The Hobbit
Author: J.R.R. Tolkien | ISBN: 0547928219

Checkout Date: March 20, 2026
Due Date: April 3, 2026
Return Date: April 17, 2026

Status: ⚠ LATE RETURN (5 days)

Fine Calculation:
  Days Late: 5
  Fine Rate: $0.50 per day
  Fine Amount: $2.50

Total Fines Owed: $2.50
```

### Alternative Flows

#### Alternative Flow 1: Book Is Overdue (Fine Charged)
- **Trigger:** Book returned after due date
- **Steps:**
  1. System calculates days_overdue = return_date - due_date
  2. System calculates fine = days_overdue × $0.50
  3. System adds fine to member's TotalFines
  4. System displays fine amount on receipt
  5. Librarian informs member of fine
- **Result:** Fine tracked; member aware

#### Alternative Flow 2: Fine Exceeds Maximum ($25)
- **Trigger:** Book returned 60+ days late
- **Steps:**
  1. System calculates raw_fine = days_overdue × $0.50 = $30
  2. System detects fine > $25 maximum
  3. System caps fine at $25
  4. System displays: "Fine capped at maximum: $25.00"
- **Result:** Maximum fine enforced

#### Alternative Flow 3: Borrowing Record Not Found
- **Trigger:** ISBN doesn't match any active borrowing for member
- **Steps:**
  1. System searches for borrowing record
  2. System finds no match
  3. System displays: "No active borrowing record found"
  4. Librarian can investigate or re-enter
- **Result:** Prevents return of wrong books

#### Alternative Flow 4: Duplicate Return
- **Trigger:** Member attempts return of same book twice
- **Steps:**
  1. System searches for borrowing record
  2. System finds record marked "Returned"
  3. System displays: "This book was already returned on [date]"
  4. System prevents duplicate processing
- **Result:** Data integrity maintained

### Acceptance Criteria
- [ ] Return date and time recorded accurately
- [ ] Fine calculated correctly: (days overdue) × $0.50
- [ ] Fine capped at $25 maximum
- [ ] Fine added to member's total balance
- [ ] Book availability updated (+1)
- [ ] Receipt displays return confirmation and fine amount
- [ ] Duplicate returns prevented
- [ ] Return action logged with timestamp (FR12)

---

## Use Case 6: View Member History

### Use Case ID
UC-009

### Requirement Alignment
**Primary:** FR9 (View Member History)  
**Secondary:** FR8 (Fine information)

### Actor
**Librarian**, **Head Librarian**

### Description
Display complete borrowing history for a member, including all past and present transactions, return dates, and current fine balance. Enables tracking of member activity and accountability.

### Preconditions
- Librarian is authenticated and logged in (FR11)
- Member account exists
- Member has registered in system

### Postconditions
- Member history displayed with all transactions
- Current fine balance displayed
- No changes to system data (read-only)
- History access logged (FR12)

### Extension Point
**Extension Point Name:** None (read-only operation with no conditional behaviors)

### Basic Flow (Success Scenario)

1. Librarian selects "View Member History"
2. Librarian enters member ID
3. System validates member exists
4. System retrieves all borrowing transactions for member
5. System calculates current fine balance
6. System organizes transactions by date (most recent first)
7. System logs history access with timestamp (FR12)
8. System displays member history (all transactions with borrow date, title, return date, fine status)

### Sample Output
```
MEMBER BORROWING HISTORY

Member: John Smith
Member ID: LMS-2026-0523
Status: ACTIVE
Membership Expires: March 29, 2027

Account Summary:
  Total Fines Owed: $2.50
  Books Currently Borrowed: 1 of 5

Transaction History (Most Recent First):

Borrow Date | Title                    | Return Date | Fine Status
3/29/2026   | Harry Potter...          | 4/12/2026   | PAID ($0.00)
3/20/2026   | The Hobbit               | 4/17/2026   | UNPAID ($2.50)
2/28/2026   | 1984                     | 3/14/2026   | PAID ($0.00)
```

### Acceptance Criteria
- [ ] History shows all borrowing transactions
- [ ] Includes: borrow date, book title, return date, fine status
- [ ] Fine balance displayed prominently
- [ ] Transactions sortable by date
- [ ] Current and past books clearly distinguished
- [ ] 100% accurate for all member transactions
- [ ] History access logged with timestamp (FR12)

---

## Use Case 7: Generate Reports

### Use Case ID
UC-010

### Requirement Alignment
**Primary:** FR10 (Generate Reports)  
**Secondary:** FR9 (uses transaction data)

### Actor
**Head Librarian**, **University Administrator**

### Description
Generate administrative reports on library operations including circulation statistics, popular books, member activity, and financial summaries. On-demand reporting for decision-making.

### Preconditions
- User is authenticated (FR11)
- User has report access permissions
- Transaction data exists in system

### Postconditions
- Report generated and displayed
- No changes to system data (read-only)
- Report generation logged (FR12)
- Report can be exported or printed

### Extension Point
**Extension Point Name:** Report Generation
- **Description:** Different report types can be generated (Circulation, Popular Books, Member Activity, Financial Summary)

### Basic Flow (Success Scenario)

1. User selects "Generate Reports"
2. System displays available report types (Circulation, Popular Books, Member Activity, Financial Summary)
3. User chooses report type and date range (optional)
4. System retrieves relevant transaction data
5. System aggregates, calculates, and formats report
6. System logs report generation with timestamp (FR12)
7. System displays report on screen
8. User can export or print report

### Sample Report Output
```
LIBRARY CIRCULATION REPORT

Generated: March 29, 2026
Period: January 1 - March 29, 2026

Summary Statistics:
  Total Checkouts: 850
  Total Returns: 835
  Books Currently Borrowed: 15
  Active Members: 142

Top 5 Most Borrowed Books:
  1. Harry Potter Box Set (47 checkouts)
  2. The Hobbit (42 checkouts)
  3. 1984 (38 checkouts)
  4. To Kill a Mockingbird (35 checkouts)
  5. The Great Gatsby (32 checkouts)

Monthly Circulation Trend:
  January: 287 checkouts
  February: 310 checkouts
  March (YTD): 253 checkouts
  Year-over-Year Growth: +16%
```

### Acceptance Criteria
- [ ] Report generated on-demand
- [ ] Data accurate and current
- [ ] Includes relevant details and trends
- [ ] Date range customizable
- [ ] Generation time acceptable (< 3 seconds)
- [ ] Export/print functionality available
- [ ] Report generation logged with timestamp (FR12)

---

## Use Case 8: View Library Statistics

### Use Case ID
UC-015

### Requirement Alignment
**Primary:** FR16 (View Library Statistics)  
**Secondary:** FR10 (reporting)

### Actor
**Head Librarian**, **University Administrator**

### Description
Display summary statistics of library operations including total books, total members, current borrowing count, and other key metrics.

### Preconditions
- User is authenticated (FR11)
- User has statistics access permission
- System has recorded transactions

### Postconditions
- Statistics displayed with current data
- No changes to system data (read-only)
- Statistics access logged (FR12)
- Auto-updates when transactions occur

### Extension Point
**Extension Point Name:** None (simple read-only display with no conditional behaviors)

### Basic Flow (Success Scenario)

1. User selects "View Library Statistics"
2. System counts total books in catalog
3. System counts total registered members
4. System counts currently borrowed books (active borrowing records)
5. System calculates total outstanding fines and utilization metrics
6. System organizes statistics by category
7. System logs statistics access with timestamp (FR12)
8. System displays statistics dashboard
9. Statistics auto-update when transactions occur

### Sample Output
```
LIBRARY STATISTICS DASHBOARD

Last Updated: March 29, 2026 at 10:30 AM

Catalog Statistics:
  Total Books in Catalog: 12,450
  Total Unique Titles: 5,200
  Books Available: 12,435
  Books Currently Borrowed: 15
  Catalog Utilization: 0.12%

Member Statistics:
  Total Registered Members: 342
  Active Members: 328
  Inactive Members: 14
  Members with Active Borrowing: 15

Fine & Account Statistics:
  Members with Fines: 12
  Total Fines Outstanding: $42.00
  Total Fines Collected (YTD): $189.50

Top Categories:
  Fiction: 4,200 books (34%)
  Science: 2,150 books (17%)
  History: 1,900 books (15%)
```

### Acceptance Criteria
- [ ] Total book count accurate
- [ ] Total member count accurate
- [ ] Current borrowing count matches active transactions
- [ ] Statistics update after each transaction
- [ ] Utilization percentages calculated correctly
- [ ] Display clear and easy to understand
- [ ] Statistics access logged with timestamp (FR12)


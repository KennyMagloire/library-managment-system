# System Requirements Document

## Functional Requirements

### FR1: Search Books
The system should allow users to search for books using title, author, or ISBN as criteria.  
**Acceptance Criteria:**
- Results displayed within 2 seconds  
- if the book is available' it should display "Available" and next to it the number of available copy should be displayed eg "(2 of 5)
- if not available it should diplayed "Book is not in the catalog" or "Currently Borrowed"
- Search system should handle partial matches, if user sear for "Art", the system may present return "Art of War"

### FR2: Add Book
The system shall allow librarians to add books.  
**Acceptance Criteria:**
- ISBN must be unique  
- Fields validated  

### FR3: Update Book
The system shall allow updating book details (Author, ISBN, Available stock)  
**Acceptance Criteria:**
- Changes saved correctly  
- Reflected immediately  
- Display the state of a book (e.g.,brand new, damaged, old ...)
- Availability status should be updated after every transaction (e.g., number of copies available)

### FR4: Delete Book
The system shall allow deletion of books from the catalog by librarian only if it meets removal criterias.  
**Acceptance Criteria:**
- Cannot delete borrowed books 
- The system must require a reason for removal (e.g., outdated, damaged, lost)
- The system shall create and store a timestamp of the removal action

### FR5: Register Member
The system shall allow member registration.  
**Acceptance Criteria:**
- Unique member ID shall be provided automatically by the system for members 
- Registration shall require: name, email, phone number, address, date of birth
- Required fields must be completed  
- input formats shall go through validation process before being saved (e.g., email)
- Members' records should not be duplicated
- Librarians shall be able to update member status (active, inactive, suspended)

### FR6: Borrow Book
The system shall allow borrowing.  
**Acceptance Criteria:**
- Book availabiity confirmation  
- Return date assigned  
- The system must ensure the member does not exceed the borrowing limit
- The system must ensure the member does not have outstanding fine
- Check that the member has no overdue books
- Check if the member account is active
- System shall automatically set return date to 14 days from borrowing date
- The system shall create and store a timestamp borrowing transaction with a due date
- The system shall produce a receipt containing member name, book details, and due date clearly


### FR7: Return Book
The system shall allow returns.  
**Acceptance Criteria:**
- Date and Time of Return recorded  
- Availability updated 
- Librarian enters member ID and book ISBN to process return
- System shall automatically identify all books with return date = null AND due date < today

### FR8: Calculate Fine
The system shall calculate overdue fines.  
**Acceptance Criteria:**
- Based on days overdue  

### FR9: View Member History
The system shall display member history.  
**Acceptance Criteria:**
- All transactions visible
- System shall display total unpaid fines for each member  
- System shall show fine history (paid and unpaid)

### FR10: Generate Reports
The system shall generate reports.  
**Acceptance Criteria:**
- Data accurate and current  
- Report shall count total number of times each book has been borrowed (checkout transactions)
- System shall identify top 20 most-borrowed books
- Report shall be generated and viewed  on-demand
- Reports shall display relevant details including member information, book details, and dates

### FR11: Library Authentication

**Description:**  
The system shall require librarian to authenticate (log in) before accessing any library management functionalities.

**Acceptance Criteria:**
- The system shall prompt users to enter a valid username and password before granting access.
- The system shall deny access if the credentials are incorrect and display an appropriate error message.
- The system shall allow access only after successful authentication.
- The system shall prevent unauthenticated users from accessing any system features.
- The system shall allow users to retry login after a failed attempt.


### FR12: Operation Tracking

**Description:**  
The system shall track and record key user operations for monitoring and auditing purposes.

**Acceptance Criteria:**
- The system shall log user login attempts, including successful and failed attempts.
- The system shall record key operations such as book borrowing, returning, and searching.
- Each recorded operation shall include a timestamp and the user involved.
- The system shall store logs in a persistent format for later review.
- The system shall allow administrators to review operation logs when necessary.


### FR13: View System Activity Logs
The system shall allow authorized staff to view logs of system activities.

**Acceptance Criteria:**
- The system shall record actions such as:
  - book additions and removals
  - borrowing and return transactions
- Each log entry shall include:
  - librarian ID
  - date and time of action
- The system shall allow filtering of logs by date or type of action


### FR14: Data Backup and Restore
The system shall allow system administrators to perform data backup and restoration.

**Acceptance Criteria:**
- The system shall allow backup of all system data (books, members, transactions)
- The system shall store backup files for future use
- The system shall allow restoration of data from a selected backup file


### FR15: Manage Librarian Accounts
The system shall allow administrators to manage librarian accounts.

**Acceptance Criteria:**
- The system shall allow creation of new librarian accounts
- The system shall allow updating librarian information
- The system shall allow deactivation of librarian accounts
- Only authorized administrators shall be allowed to perform these actions


### FR16: View Library Statistics
The system shall allow authorized staff to view summary statistics of library operations.

**Acceptance Criteria:**
- The system shall display statistics such as:
  - total number of books
  - total number of members
  - number of borrowed books
- The system shall update statistics automatically when data changes
---


## Non-Functional Requirements

### Usability Requirements

- The system shall provide a command-line interface with clearly numbered menu options (e.g., "Press 1 to Search Book").
- The system shall use simple, non-technical language to ensure ease of use for non-technical users such as librarians.
- The system shall display clear instructions on each screen to guide the user.
- The system shall provide meaningful error messages when invalid input is entered.
- The system shall ensure that all prompts are easy to understand and consistent throughout the system.
- The system shall allow users to navigate through options using simple numeric inputs.

### Performance Requirements

- The system shall respond to user input within 2 seconds under normal operating conditions.
- The system shall process search queries within 3 seconds for a database of up to 10,000 books.
- The system shall support at least 50 concurrent users without significant performance degradation.
- The system shall handle multiple operations efficiently without system crashes.
- The system shall maintain stable performance during peak usage periods.

### Scalability Requirements

- The system shall support a catalog of at least 50,000 books.
- The system shall support up to 5,000 registered users.
- The system shall allow for future expansion of database size without requiring major system redesign.
- The system architecture shall allow integration with larger systems if needed.

### Security Requirements

- The system shall require user authentication before access to system functionalities.
- The system shall ensure that user credentials are stored securely.
- The system shall prevent unauthorized access to sensitive data.
- The system shall restrict access based on user roles (e.g., librarian vs user).
- The system shall protect the system against invalid or malicious inputs.

### Maintainability Requirements

- The system shall follow a modular architecture separating UI, business logic, and data access layers.
- The code shall be well documented using comments and meaningful naming conventions.
- The system shall include a README file with setup and usage instructions.
- The system shall be structured in a way that allows easy updates and modifications.
- New developers shall be able to understand and extend the system with minimal effort.

### Dependability Requirements

- The system shall handle errors gracefully without crashing.
- The system shall ensure that data is not lost during normal operations.
- The system shall provide consistent results for the same input.
- The system shall maintain system stability during extended usage.
- The system shall log important events and errors for troubleshooting purposes.
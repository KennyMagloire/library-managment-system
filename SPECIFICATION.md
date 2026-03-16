# Library Management System - System Specification

## 1. Introduction

### Project Title
**Library Management System**

### Domain
**Library Management** - A library is an institution that  organizes and lends books to members. The library domain contains member management, book catalog, borrowing operations, borrowing tracking.

### Problem Statement

Libraries face significant challenges in managing their operations manually:
- **Inefficient Book Tracking:** In the age of digitalization, physical card are troublesome for tracability and conservability
- **Member Management Overhead:** Manually monitoring and maintaining member records and borrowing history is time-consuming
- **Poor Data Visibility:** Difficult to generate meaningful insight on library usage, popular books and genre, and member activity
- **Limited Search Capabilities:** book tracability is limited if the library has a large catalog

This project will solve these problems by producing a digital, centralized platform for managing all aspects of library operations.

### Scope & Feasibility

This project is  feasible for the following reasons:

1. **Well-Defined Requirements:** Library operations are clearly understood and standardized
2. **Manageable Complexity:** Can be built in phases (core functions → advanced features)
3. **Clear Data Model:** Books, Members, and Borrowing records form a logical, simple schema
4. **Scalable Architecture:** Can start simple and extend features without redesign
5. **No External Dependencies Required:** Can run on file-based persistence 

--

## 2. System Requirements

### 2.1 Functional Requirements

#### F1: Book Management

- Add new books to the system (with ISBN, title, author, category, how many copies, price)
- Update book info 
- Delete books 
- Search for books by title, author, or ISBN 
- See the catalog

#### F2: Member Management

New members can register and create an account
- members can update their information
- members can be deactivated or reactivated
- member's profile and history

#### F3: Borrowing System Management

- When someone borrows a book, the transaction is will be recorded 
- When they return it,it is also record 
- limits on how many books a person can borrow 
- Keep track of when books are due


#### F4: System Administration

- Save and load data from files
- basic login for librarians so not everyone can access it
- Backup the library data

### 2.2 Non-Functional Requirements
- Performance The system should respond be responsive in quickly manner. 
- The system will track and handle data. 
- The system will be user friendly
- The code will be organized and easy to understand and fix 

## 3. Data Model
the system needs to keep track of three main things: Books, Members, and Borrowing Records. Here's what data each one needs:

#### Book
ISBN - the unique code for each book
Title - the name of the book
Author - who wrote it
Category - like, is it fiction, science, history, etc.
Publication Year - when it came out

#### Member
Member ID
Name 
Email
Phone Number
Address
Membership Date 
Membership Expiry 
Status - active or inactive

#### Borrowing Record

Transaction ID 
Member ID 
ISBN 
Borrow Date 
Due Date
Return Date - when they actually returned it (or null if not returned yet)
Status - is it borrowed, returned, or overdue




## 4. Technology Stack
Java 8, ArrayList, HashMap,TreeMap, Interface Command line, TestingJ Unit Build Maven or Gradle

## 5. Use Cases

### Use Case 1: Someone Borrows a Book

Member searches for the book they want
System checks if it's available
Member asks to borrow it
System records the transaction and updates how many copies are left
System sets the due date (like 14 days from today)

### Use Case 2: Book returns

Member brings the book back
System checks if it's a late return
System updates the record to show it's returned

### Use Case 3: Search for Books

Member types what book they're looking for
System searches the catalog
System shows matching books 
Member can see details about each book

### Use Case 4: Librarian Makes an Overdue Report

Librarian asks the system for overdue books
System finds all books that are late
System shows the list with member contact info








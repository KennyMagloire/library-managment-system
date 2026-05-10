package com.library;

import java.time.LocalDate;
import java.util.List;

public class SystemUser {

    private String userId;
    private String username;
    private String passwordHash;
    private UserRole role;
    private LocalDate lastLogin;

    public SystemUser(String userId, String username,
                      String passwordHash, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.lastLogin = null;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public UserRole getRole() { return role; }
    public LocalDate getLastLogin() { return lastLogin; }

    // Methods from diagram
    public boolean authenticate(String password) {
        if (this.passwordHash.equals(password)) {
            this.lastLogin = LocalDate.now();
            AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                    AuditAction.LOGIN, userId, username + " logged in.");
            return true;
        }
        return false;
    }

    public void logout() {
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.LOGOUT, userId, username + " logged out.");
        System.out.println(username + " logged out.");
    }

    public boolean hasPermission(Permission action) {
        switch (action) {
            case GENERATE_REPORT:
                return role == UserRole.HEAD_LIBRARIAN
                        || role == UserRole.UNIVERSITY_ADMINISTRATOR;
            case MANAGE_USERS:
                return role == UserRole.SYSTEM_ADMIN;
            case WAIVE_FINE:
                return role == UserRole.HEAD_LIBRARIAN;
            default:
                return role == UserRole.LIBRARIAN
                        || role == UserRole.HEAD_LIBRARIAN
                        || role == UserRole.SYSTEM_ADMIN;
        }
    }

    public void changePassword(String oldPass, String newPass) {
        if (authenticate(oldPass)) {
            this.passwordHash = newPass;
            AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                    AuditAction.CHANGE_PASSWORD, userId,
                    username + " changed password.");
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public Patron registerPatron(String patronId, String institutionId,
                                 String name, String email, String phone,
                                 AffiliationType affiliationType) {
        Patron patron = new Patron(patronId, institutionId, name,
                email, phone, affiliationType);
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.REGISTER_PATRON, userId,
                "Registered patron: " + name);
        return patron;
    }

    public Patron lookupPatron(String institutionId) {
        System.out.println("Looking up patron: " + institutionId);
        return null;
    }

    public List<Book> searchBook(String query) {
        System.out.println("Searching for: " + query);
        return null;
    }

    public Book addBook(String bookId, String ISBN, String title,
                        String author, String genre,
                        int publicationYear, int totalCopies) {
        Book book = new Book(bookId, ISBN, title, author,
                genre, publicationYear, totalCopies);
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.ADD_BOOK, userId, "Added book: " + title);
        return book;
    }

    public void removeBook(String bookId) {
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.REMOVE_BOOK, userId, "Removed book: " + bookId);
        System.out.println("Removing book: " + bookId);
    }

    public Loan processCheckout(Book book, Patron patron) {
        if (!patron.canBorrow()) {
            System.out.println("Patron cannot borrow — check fines or loan limit.");
            return null;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return null;
        }
        String loanId = "LN-" + System.currentTimeMillis();
        Loan loan = new Loan(loanId, patron, book);
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.CHECKOUT, userId, "Checked out: "
                        + book.getTitle() + " to " + patron.getName());
        return loan;
    }

    public void processReturn(Loan loan) {
        loan.markReturned();
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.RETURN, userId,
                "Returned loan: " + loan.getLoanId());
        System.out.println("Return processed for loan: " + loan.getLoanId());
    }

    public Report generateReport(String reportId, ReportType reportType) {
        if (!hasPermission(Permission.GENERATE_REPORT)) {
            System.out.println("Access denied. Insufficient permissions.");
            return null;
        }
        Report report = new Report(reportId, reportType, this);
        report.generate();
        AuditLog.logAction("LOG-" + System.currentTimeMillis(),
                AuditAction.GENERATE_REPORT, userId,
                "Generated report: " + reportType);
        return report;
    }

}
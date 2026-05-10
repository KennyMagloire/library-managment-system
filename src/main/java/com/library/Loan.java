package com.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {

    private String loanId;
    private Patron patron;
    private Book book;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;

    public Loan(String loanId, Patron patron, Book book) {
        this.loanId = loanId;
        this.patron = patron;
        this.book = book;
        this.checkoutDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(14);
        this.returnDate = null;
        this.status = LoanStatus.ACTIVE;

        this.book.decreaseCopies();
        this.patron.setActiveLoans(this.patron.getActiveLoans() + 1);
        this.patron.addLoan(this);
    }

    // Getters
    public String getLoanId() { return loanId; }
    public Patron getPatron() { return patron; }
    public Book getBook() { return book; }
    public LocalDate getCheckoutDate() { return checkoutDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public LoanStatus getStatus() { return status; }

    // Setters
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }


    public boolean isOverdue() {
        return status == LoanStatus.ACTIVE && LocalDate.now().isAfter(dueDate);
    }

    public void markReturned() {
        this.status = LoanStatus.RETURNED;
        this.returnDate = LocalDate.now();
        this.book.increaseCopies();
        this.patron.setActiveLoans(this.patron.getActiveLoans() - 1);
    }

    public double calculateFine() {
        if (!isOverdue()) {
            return 0.0;
        }
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        double ratePerDay = 2.50;
        return daysOverdue * ratePerDay;
    }

    public void extendDueDate(int days) {
        this.dueDate = this.dueDate.plusDays(days);
    }

}
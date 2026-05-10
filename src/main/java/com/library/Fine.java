package com.library;

public class Fine {

    private String fineId;
    private Loan loan;
    private double amount;
    private String issueDate;
    private String paidDate;
    private FineStatus status;

    public Fine(String fineId, Loan loan, String issueDate) {
        this.fineId = fineId;
        this.loan = loan;
        this.issueDate = issueDate;
        this.paidDate = null;
        this.status = FineStatus.UNPAID;
        this.amount = 0.0;
    }

    // Getters
    public String getFineId() { return fineId; }
    public Loan getLoan() { return loan; }
    public double getAmount() { return amount; }
    public String getIssueDate() { return issueDate; }
    public String getPaidDate() { return paidDate; }
    public FineStatus getStatus() { return status; }

    // Methods from diagram
    public double calculateAmount(int daysOverdue) {
        double ratePerDay = 2.50;
        this.amount = daysOverdue * ratePerDay;
        return this.amount;
    }

    public void markPaid() {
        this.status = FineStatus.PAID;
        this.paidDate = java.time.LocalDate.now().toString();
    }

    public void waive() {
        this.status = FineStatus.WAIVED;
        this.amount = 0.0;
    }

}
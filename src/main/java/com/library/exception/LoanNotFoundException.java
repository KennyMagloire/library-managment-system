package com.library.exception;

public class LoanNotFoundException extends RuntimeException {

    public LoanNotFoundException(String loanId) {
        super("Loan not found with ID: " + loanId);
    }
}
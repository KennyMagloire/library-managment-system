package com.library.repository;

import com.library.Loan;
import java.util.List;

public interface LoanRepository extends Repository<Loan, String> {

    List<Loan> findByPatronId(String patronId);
    List<Loan> findOverdueLoans();
    List<Loan> findActiveLoans();
}
package com.library.service;

import com.library.Loan;
import com.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(String id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found: " + id));
    }

    public Loan addLoan(Loan loan) {
        loanRepository.save(loan);
        return loan;
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findActiveLoans();
    }

    public List<Loan> getOverdueLoans() {
        return loanRepository.findOverdueLoans();
    }

    public List<Loan> getLoansByPatron(String patronId) {
        return loanRepository.findByPatronId(patronId);
    }
}
package com.library.repository.inmemory;

import com.library.Loan;
import com.library.LoanStatus;
import com.library.repository.LoanRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryLoanRepository implements LoanRepository {

    private final Map<String, Loan> storage = new HashMap<>();

    @Override
    public void save(Loan loan) {
        if (loan == null || loan.getLoanId() == null) {
            throw new IllegalArgumentException("Loan or LoanId cannot be null");
        }
        storage.put(loan.getLoanId(), loan);
    }

    @Override
    public Optional<Loan> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public List<Loan> findByPatronId(String patronId) {
        return storage.values().stream()
                .filter(l -> l.getPatron().getPatronId().equals(patronId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findOverdueLoans() {
        return storage.values().stream()
                .filter(Loan::isOverdue)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findActiveLoans() {
        return storage.values().stream()
                .filter(l -> l.getStatus() == LoanStatus.ACTIVE)
                .collect(Collectors.toList());
    }
}
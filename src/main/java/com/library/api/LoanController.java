package com.library.api;

import com.library.Loan;
import com.library.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Loan>> getActiveLoans() {
        return ResponseEntity.ok(loanService.getActiveLoans());
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {
        return ResponseEntity.ok(loanService.getOverdueLoans());
    }

    @GetMapping("/patron/{patronId}")
    public ResponseEntity<List<Loan>> getLoansByPatron(@PathVariable String patronId) {
        return ResponseEntity.ok(loanService.getLoansByPatron(patronId));
    }

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.addLoan(loan));
    }
}
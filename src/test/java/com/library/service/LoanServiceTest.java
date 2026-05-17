package com.library.service;

import com.library.*;
import com.library.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    private Loan testLoan;
    private Patron testPatron;
    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book("B001", "978-0132350884", "Clean Code",
                "Robert Martin", "Programming", 2008, 3);
        testPatron = new Patron("P001", "STU2024001", "John Dlamini",
                "john@uni.ac.za", "0821234567", AffiliationType.STUDENT);
        testLoan = new Loan("L001", testPatron, testBook);
    }

    @Test
    void getAllLoans_returnsAllLoans() {
        when(loanRepository.findAll()).thenReturn(List.of(testLoan));
        List<Loan> result = loanService.getAllLoans();
        assertEquals(1, result.size());
        verify(loanRepository).findAll();
    }

    @Test
    void getLoanById_found() {
        when(loanRepository.findById("L001")).thenReturn(Optional.of(testLoan));
        Loan result = loanService.getLoanById("L001");
        assertNotNull(result);
        assertEquals("L001", result.getLoanId());
    }

    @Test
    void getLoanById_notFound_throwsException() {
        when(loanRepository.findById("L999")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> loanService.getLoanById("L999"));
    }

    @Test
    void addLoan_savesAndReturnsLoan() {
        loanService.addLoan(testLoan);
        verify(loanRepository).save(testLoan);
    }

    @Test
    void getActiveLoans_returnsActiveLoans() {
        when(loanRepository.findActiveLoans()).thenReturn(List.of(testLoan));
        List<Loan> result = loanService.getActiveLoans();
        assertEquals(1, result.size());
        verify(loanRepository).findActiveLoans();
    }

    @Test
    void getOverdueLoans_returnsOverdueLoans() {
        when(loanRepository.findOverdueLoans()).thenReturn(List.of());
        List<Loan> result = loanService.getOverdueLoans();
        assertEquals(0, result.size());
        verify(loanRepository).findOverdueLoans();
    }
}
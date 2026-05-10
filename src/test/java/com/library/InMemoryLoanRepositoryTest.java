package com.library;

import com.library.repository.inmemory.InMemoryLoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryLoanRepositoryTest {

    private InMemoryLoanRepository repository;
    private Patron patron;
    private Book book;
    private Loan loan1;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryLoanRepository();
        patron = new Patron("P001", "STU001", "Thabo Mokoena",
                "thabo@uni.ac.za", "0821234567", AffiliationType.STUDENT);
        book = new Book("BK001", "978-001", "Clean Code",
                "Robert Martin", "CS", 2008, 3);
        loan1 = new Loan("LN001", patron, book);
    }

    @Test
    public void testSaveAndFindById() {
        repository.save(loan1);
        Optional<Loan> found = repository.findById("LN001");

        assertTrue(found.isPresent());
        assertEquals("LN001", found.get().getLoanId());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Loan> found = repository.findById("NONEXISTENT");
        assertFalse(found.isPresent());
    }

    @Test
    public void testFindAll() {
        repository.save(loan1);
        List<Loan> all = repository.findAll();
        assertEquals(1, all.size());
    }

    @Test
    public void testDelete() {
        repository.save(loan1);
        repository.delete("LN001");

        Optional<Loan> found = repository.findById("LN001");
        assertFalse(found.isPresent());
    }

    @Test
    public void testFindByPatronId() {
        repository.save(loan1);
        List<Loan> result = repository.findByPatronId("P001");

        assertEquals(1, result.size());
        assertEquals("LN001", result.get(0).getLoanId());
    }

    @Test
    public void testFindActiveLoans() {
        repository.save(loan1);
        List<Loan> active = repository.findActiveLoans();
        assertEquals(1, active.size());
    }

    @Test
    public void testSaveNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                repository.save(null)
        );
    }
}

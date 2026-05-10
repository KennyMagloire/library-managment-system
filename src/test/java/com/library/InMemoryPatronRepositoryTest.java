package com.library;

import com.library.repository.inmemory.InMemoryPatronRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryPatronRepositoryTest {

    private InMemoryPatronRepository repository;
    private Patron patron1;
    private Patron patron2;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryPatronRepository();
        patron1 = new Patron("P001", "STU001", "Thabo Mokoena",
                "thabo@uni.ac.za", "0821234567", AffiliationType.STUDENT);
        patron2 = new Patron("P002", "LEC001", "Dr. Dlamini",
                "dlamini@uni.ac.za", "0839876543", AffiliationType.LECTURER);
    }

    @Test
    public void testSaveAndFindById() {
        repository.save(patron1);
        Optional<Patron> found = repository.findById("P001");

        assertTrue(found.isPresent());
        assertEquals("Thabo Mokoena", found.get().getName());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Patron> found = repository.findById("NONEXISTENT");
        assertFalse(found.isPresent());
    }

    @Test
    public void testFindAll() {
        repository.save(patron1);
        repository.save(patron2);

        List<Patron> all = repository.findAll();
        assertEquals(2, all.size());
    }

    @Test
    public void testDelete() {
        repository.save(patron1);
        repository.delete("P001");

        Optional<Patron> found = repository.findById("P001");
        assertFalse(found.isPresent());
    }

    @Test
    public void testFindByAffiliationType() {
        repository.save(patron1);
        repository.save(patron2);

        List<Patron> students = repository.findByAffiliationType(AffiliationType.STUDENT);
        assertEquals(1, students.size());
        assertEquals("Thabo Mokoena", students.get(0).getName());
    }

    @Test
    public void testFindActivePatrons() {
        repository.save(patron1);
        repository.save(patron2);

        List<Patron> active = repository.findActivePatrons();
        assertEquals(2, active.size());
    }

    @Test
    public void testSaveNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                repository.save(null)
        );
    }
}
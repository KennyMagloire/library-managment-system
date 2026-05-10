package com.library;

import com.library.repository.inmemory.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryBookRepositoryTest {

    private InMemoryBookRepository repository;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        repository = new InMemoryBookRepository();
        book1 = new Book("BK001", "978-001", "Clean Code",
                "Robert Martin", "CS", 2008, 3);
        book2 = new Book("BK002", "978-002", "Design Patterns",
                "GoF", "CS", 1994, 2);
    }

    @Test
    public void testSaveAndFindById() {
        repository.save(book1);
        Optional<Book> found = repository.findById("BK001");

        assertTrue(found.isPresent());
        assertEquals("Clean Code", found.get().getTitle());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Book> found = repository.findById("NONEXISTENT");
        assertFalse(found.isPresent());
    }

    @Test
    public void testFindAll() {
        repository.save(book1);
        repository.save(book2);

        List<Book> all = repository.findAll();
        assertEquals(2, all.size());
    }

    @Test
    public void testDelete() {
        repository.save(book1);
        repository.delete("BK001");

        Optional<Book> found = repository.findById("BK001");
        assertFalse(found.isPresent());
    }

    @Test
    public void testSaveUpdatesExistingBook() {
        repository.save(book1);
        book1.setTitle("Clean Code Updated");
        repository.save(book1);

        Optional<Book> found = repository.findById("BK001");
        assertEquals("Clean Code Updated", found.get().getTitle());
    }

    @Test
    public void testFindByAuthor() {
        repository.save(book1);
        repository.save(book2);

        List<Book> result = repository.findByAuthor("Robert Martin");
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());
    }

    @Test
    public void testFindAvailable() {
        repository.save(book1);
        repository.save(book2);

        List<Book> available = repository.findAvailable();
        assertEquals(2, available.size());
    }

    @Test
    public void testSaveNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                repository.save(null)
        );
    }
}
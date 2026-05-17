package com.library.service;

import com.library.Book;
import com.library.repository.BookRepository;
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
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book("B001", "978-0132350884", "Clean Code",
                "Robert Martin", "Programming", 2008, 3);
        testBook.setTitle("Clean Code");
        testBook.setAuthor("Robert Martin");
    }

    @Test
    void getAllBooks_returnsAllBooks() {
        when(bookRepository.findAll()).thenReturn(List.of(testBook));
        List<Book> result = bookService.getAllBooks();
        assertEquals(1, result.size());
        verify(bookRepository).findAll();
    }

    @Test
    void getBookById_found() {
        when(bookRepository.findById("B001")).thenReturn(Optional.of(testBook));
        Book result = bookService.getBookById("B001");
        assertNotNull(result);
        assertEquals("Clean Code", result.getTitle());
    }

    @Test
    void getBookById_notFound_throwsException() {
        when(bookRepository.findById("B999")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.getBookById("B999"));
    }

    @Test
    void addBook_savesAndReturnsBook() {
        bookService.addBook(testBook);
        verify(bookRepository).save(testBook);
    }

    @Test
    void getAvailableBooks_returnsAvailableBooks() {
        when(bookRepository.findAvailable()).thenReturn(List.of(testBook));
        List<Book> result = bookService.getAvailableBooks();
        assertEquals(1, result.size());
        verify(bookRepository).findAvailable();
    }
}
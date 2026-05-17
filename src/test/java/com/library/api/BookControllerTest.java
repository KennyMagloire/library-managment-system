package com.library.api;

import com.library.Book;
import com.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book("B001", "978-0132350884", "Clean Code",
                "Robert Martin", "Programming", 2008, 3);
    }

    @Test
    void getAllBooks_returns200() throws Exception {
        when(bookService.getAllBooks()).thenReturn(List.of(testBook));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());

        verify(bookService).getAllBooks();
    }

    @Test
    void getBookById_found_returns200() throws Exception {
        when(bookService.getBookById("B001")).thenReturn(testBook);

        mockMvc.perform(get("/api/books/B001"))
                .andExpect(status().isOk());

        verify(bookService).getBookById("B001");
    }

    @Test
    void getBookById_notFound_returns404() throws Exception {
        when(bookService.getBookById("B999"))
                .thenThrow(new com.library.exception.BookNotFoundException("B999"));

        mockMvc.perform(get("/api/books/B999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAvailableBooks_returns200() throws Exception {
        when(bookService.getAvailableBooks()).thenReturn(List.of(testBook));

        mockMvc.perform(get("/api/books/available"))
                .andExpect(status().isOk());

        verify(bookService).getAvailableBooks();
    }

    @Test
    void addBook_returns201() throws Exception {
        when(bookService.addBook(any(Book.class))).thenReturn(testBook);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"bookID\":\"B001\",\"ISBN\":\"978-0132350884\"," +
                                "\"title\":\"Clean Code\",\"author\":\"Robert Martin\"," +
                                "\"genre\":\"Programming\",\"publicationYear\":2008," +
                                "\"totalCopies\":3}"))
                .andExpect(status().isCreated());

        verify(bookService).addBook(any(Book.class));
    }
}
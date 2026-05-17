package com.library.service;

import com.library.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

   
    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new com.library.exception.BookNotFoundException(id));
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailable();
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
}
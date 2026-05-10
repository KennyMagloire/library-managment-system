package com.library.repository.database;

import com.library.Book;
import com.library.repository.BookRepository;
import com.library.patterns.singleton.DatabaseConnection;

import java.util.List;
import java.util.Optional;

/**
 * STUB — Future implementation of BookRepository using MySQL.
 * Uses the DatabaseConnection Singleton from A10 to connect to the database.
 * All methods throw UnsupportedOperationException until implemented.
 */
public class DatabaseBookRepository implements BookRepository {

    private final DatabaseConnection db = DatabaseConnection.getInstance();

    @Override
    public void save(Book book) {
        // TODO: INSERT INTO books VALUES (?, ?, ?, ?, ?, ?, ?)
        throw new UnsupportedOperationException("DatabaseBookRepository.save() not yet implemented");
    }

    @Override
    public Optional<Book> findById(String id) {
        // TODO: SELECT * FROM books WHERE bookId = ?
        throw new UnsupportedOperationException("DatabaseBookRepository.findById() not yet implemented");
    }

    @Override
    public List<Book> findAll() {
        // TODO: SELECT * FROM books
        throw new UnsupportedOperationException("DatabaseBookRepository.findAll() not yet implemented");
    }

    @Override
    public void delete(String id) {
        // TODO: DELETE FROM books WHERE bookId = ?
        throw new UnsupportedOperationException("DatabaseBookRepository.delete() not yet implemented");
    }

    @Override
    public List<Book> findByAuthor(String author) {
        // TODO: SELECT * FROM books WHERE author = ?
        throw new UnsupportedOperationException("DatabaseBookRepository.findByAuthor() not yet implemented");
    }

    @Override
    public List<Book> findByGenre(String genre) {
        // TODO: SELECT * FROM books WHERE genre = ?
        throw new UnsupportedOperationException("DatabaseBookRepository.findByGenre() not yet implemented");
    }

    @Override
    public List<Book> findAvailable() {
        // TODO: SELECT * FROM books WHERE availableCopies > 0
        throw new UnsupportedOperationException("DatabaseBookRepository.findAvailable() not yet implemented");
    }
}
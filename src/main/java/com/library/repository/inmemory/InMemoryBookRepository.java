package com.library.repository.inmemory;

import com.library.Book;
import com.library.BookStatus;
import com.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> storage = new HashMap<>();

    @Override
    public void save(Book book) {
        if (book == null || book.getBookID() == null) {
            throw new IllegalArgumentException("Book or BookId cannot be null");
        }
        storage.put(book.getBookID(), book);
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return storage.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return storage.values().stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAvailable() {
        return storage.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
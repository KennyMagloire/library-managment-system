package com.library.repository;

import com.library.Book;
import java.util.List;

public interface BookRepository extends Repository<Book, String> {

    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
    List<Book> findAvailable();
}
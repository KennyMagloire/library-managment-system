package com.library.config;

import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;
import com.library.repository.PatronRepository;
import com.library.repository.inmemory.InMemoryBookRepository;
import com.library.repository.inmemory.InMemoryLoanRepository;
import com.library.repository.inmemory.InMemoryPatronRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public BookRepository bookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    public PatronRepository patronRepository() {
        return new InMemoryPatronRepository();
    }

    @Bean
    public LoanRepository loanRepository() {
        return new InMemoryLoanRepository();
    }
}
package com.library.factory;

import com.library.repository.*;
import com.library.repository.inmemory.*;

public class RepositoryFactory {

    public enum StorageType {
        MEMORY,
        DATABASE
    }

    public static BookRepository getBookRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemoryBookRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabaseBookRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }

    public static PatronRepository getPatronRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemoryPatronRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabasePatronRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }

    public static LoanRepository getLoanRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemoryLoanRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabaseLoanRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }

    public static FineRepository getFineRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemoryFineRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabaseFineRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }

    public static SystemUserRepository getSystemUserRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemorySystemUserRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabaseSystemUserRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }

    public static AuditLogRepository getAuditLogRepository(StorageType type) {
        switch (type) {
            case MEMORY:
                return new InMemoryAuditLogRepository();
            case DATABASE:
                throw new UnsupportedOperationException(
                        "DatabaseAuditLogRepository not yet implemented");
            default:
                throw new IllegalArgumentException("Unknown storage type: " + type);
        }
    }
}
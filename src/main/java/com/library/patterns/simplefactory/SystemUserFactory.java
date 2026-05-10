package com.library.patterns.simplefactory;

import com.library.SystemUser;
import com.library.UserRole;

public class SystemUserFactory {

    private SystemUserFactory() {}

    public static SystemUser createUser(UserRole role, String userId,
                                        String username, String passwordHash) {
        switch (role) {
            case LIBRARIAN:
                System.out.println("Creating Librarian: " + username);
                return new SystemUser(userId, username, passwordHash, UserRole.LIBRARIAN);
            case HEAD_LIBRARIAN:
                System.out.println("Creating Head Librarian: " + username);
                return new SystemUser(userId, username, passwordHash, UserRole.HEAD_LIBRARIAN);
            case SYSTEM_ADMIN:
                System.out.println("Creating System Admin: " + username);
                return new SystemUser(userId, username, passwordHash, UserRole.SYSTEM_ADMIN);
            case UNIVERSITY_ADMINISTRATOR:
                System.out.println("Creating University Administrator: " + username);
                return new SystemUser(userId, username, passwordHash, UserRole.UNIVERSITY_ADMINISTRATOR);
            case EXTERNAL_AUDITOR:
                System.out.println("Creating External Auditor: " + username);
                return new SystemUser(userId, username, passwordHash, UserRole.EXTERNAL_AUDITOR);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
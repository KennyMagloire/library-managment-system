package com.library;

import com.library.patterns.simplefactory.SystemUserFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleFactoryTest {

    @Test
    public void testCreateLibrarian() {
        SystemUser user = SystemUserFactory.createUser(
                UserRole.LIBRARIAN, "U001", "alice", "pass123");

        assertNotNull(user);
        assertEquals(UserRole.LIBRARIAN, user.getRole());
        assertEquals("alice", user.getUsername());
    }

    @Test
    public void testCreateSystemAdmin() {
        SystemUser user = SystemUserFactory.createUser(
                UserRole.SYSTEM_ADMIN, "U002", "bob", "pass456");

        assertNotNull(user);
        assertEquals(UserRole.SYSTEM_ADMIN, user.getRole());
    }

    @Test
    public void testCreateHeadLibrarian() {
        SystemUser user = SystemUserFactory.createUser(
                UserRole.HEAD_LIBRARIAN, "U003", "mokoena", "pass789");

        assertNotNull(user);
        assertEquals(UserRole.HEAD_LIBRARIAN, user.getRole());
    }

    @Test
    public void testNullUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                SystemUserFactory.createUser(
                        UserRole.LIBRARIAN, "U004", null, "pass123")
        );
    }
}
package com.library;

import com.library.patterns.abstractfactory.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryTest {

    @Test
    public void testConsoleFactoryCreatesConsoleNotifications() {
        NotificationFactory factory = new ConsoleNotificationFactory();

        BookNotification bookNotif = factory.createBookNotification();
        PatronNotification patronNotif = factory.createPatronNotification();

        assertNotNull(bookNotif);
        assertNotNull(patronNotif);
        assertInstanceOf(ConsoleBookNotification.class, bookNotif);
        assertInstanceOf(ConsolePatronNotification.class, patronNotif);
    }

    @Test
    public void testEmailFactoryCreatesEmailNotifications() {
        NotificationFactory factory = new EmailNotificationFactory();

        BookNotification bookNotif = factory.createBookNotification();
        PatronNotification patronNotif = factory.createPatronNotification();

        assertNotNull(bookNotif);
        assertNotNull(patronNotif);
        assertInstanceOf(EmailBookNotification.class, bookNotif);
        assertInstanceOf(EmailPatronNotification.class, patronNotif);
    }

    @Test
    public void testConsoleAndEmailProduceDifferentTypes() {
        NotificationFactory console = new ConsoleNotificationFactory();
        NotificationFactory email = new EmailNotificationFactory();

        assertNotEquals(
                console.createBookNotification().getClass(),
                email.createBookNotification().getClass()
        );
    }

    @Test
    public void testConsoleNotificationsDoNotThrow() {
        NotificationFactory factory = new ConsoleNotificationFactory();
        BookNotification notif = factory.createBookNotification();

        assertDoesNotThrow(() ->
                notif.notifyOverdue("John", "Design Patterns"));
        assertDoesNotThrow(() ->
                notif.notifyAvailable("John", "Clean Code"));
    }

    @Test
    public void testEmailNotificationsDoNotThrow() {
        NotificationFactory factory = new EmailNotificationFactory();
        PatronNotification notif = factory.createPatronNotification();

        assertDoesNotThrow(() ->
                notif.notifyRegistration("Alice"));
        assertDoesNotThrow(() ->
                notif.notifyFineIssued("Alice", 25.00));
    }
}
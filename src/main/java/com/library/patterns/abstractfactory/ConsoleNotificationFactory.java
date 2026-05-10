package com.library.patterns.abstractfactory;

public class ConsoleNotificationFactory implements NotificationFactory {

    @Override
    public BookNotification createBookNotification() {
        return new ConsoleBookNotification();
    }

    @Override
    public PatronNotification createPatronNotification() {
        return new ConsolePatronNotification();
    }
}
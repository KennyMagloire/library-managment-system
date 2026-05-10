package com.library.patterns.abstractfactory;

public class EmailNotificationFactory implements NotificationFactory {

    @Override
    public BookNotification createBookNotification() {
        return new EmailBookNotification();
    }

    @Override
    public PatronNotification createPatronNotification() {
        return new EmailPatronNotification();
    }
}
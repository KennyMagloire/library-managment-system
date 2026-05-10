package com.library.patterns.abstractfactory;

public interface NotificationFactory {
    BookNotification createBookNotification();
    PatronNotification createPatronNotification();
}
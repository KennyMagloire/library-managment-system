package com.library.patterns.abstractfactory;

public interface BookNotification {
    void notifyOverdue(String patronName, String bookTitle);
    void notifyAvailable(String patronName, String bookTitle);
}
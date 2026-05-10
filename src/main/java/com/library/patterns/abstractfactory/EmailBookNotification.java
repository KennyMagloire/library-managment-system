package com.library.patterns.abstractfactory;

public class EmailBookNotification implements BookNotification {

    @Override
    public void notifyOverdue(String patronName, String bookTitle) {
        System.out.println("[EMAIL] Sending overdue email to: " + patronName
                + " for book: " + bookTitle);
    }

    @Override
    public void notifyAvailable(String patronName, String bookTitle) {
        System.out.println("[EMAIL] Sending availability email to: " + patronName
                + " for book: " + bookTitle);
    }
}
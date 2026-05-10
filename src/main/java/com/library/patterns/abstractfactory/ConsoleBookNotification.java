package com.library.patterns.abstractfactory;

public class ConsoleBookNotification implements BookNotification {

    @Override
    public void notifyOverdue(String patronName, String bookTitle) {
        System.out.println("[CONSOLE] OVERDUE: " + patronName
                + " — " + bookTitle + " is overdue.");
    }

    @Override
    public void notifyAvailable(String patronName, String bookTitle) {
        System.out.println("[CONSOLE] AVAILABLE: " + patronName
                + " — " + bookTitle + " is now available.");
    }
}
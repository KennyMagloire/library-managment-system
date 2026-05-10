package com.library.patterns.abstractfactory;

public class ConsolePatronNotification implements PatronNotification {

    @Override
    public void notifyRegistration(String patronName) {
        System.out.println("[CONSOLE] WELCOME: " + patronName
                + " has been registered.");
    }

    @Override
    public void notifyFineIssued(String patronName, double amount) {
        System.out.println("[CONSOLE] FINE: " + patronName
                + " has been issued a fine of R" + amount);
    }
}
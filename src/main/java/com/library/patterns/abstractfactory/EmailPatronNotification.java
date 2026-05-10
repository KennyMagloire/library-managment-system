package com.library.patterns.abstractfactory;

public class EmailPatronNotification implements PatronNotification {

    @Override
    public void notifyRegistration(String patronName) {
        System.out.println("[EMAIL] Sending welcome email to: " + patronName);
    }

    @Override
    public void notifyFineIssued(String patronName, double amount) {
        System.out.println("[EMAIL] Sending fine notice to: " + patronName
                + " amount: R" + amount);
    }
}
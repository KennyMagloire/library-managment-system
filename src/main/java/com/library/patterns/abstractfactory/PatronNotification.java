package com.library.patterns.abstractfactory;

public interface PatronNotification {
    void notifyRegistration(String patronName);
    void notifyFineIssued(String patronName, double amount);
}
package com.library;

import com.library.patterns.abstractfactory.ConsoleNotificationFactory;
import com.library.patterns.abstractfactory.NotificationFactory;
import com.library.patterns.builder.PatronBuilder;
import com.library.patterns.factorymethod.CirculationReportFactory;
import com.library.patterns.factorymethod.ReportFactory;
import com.library.patterns.prototype.BookPrototypeCache;
import com.library.patterns.simplefactory.SystemUserFactory;
import com.library.patterns.singleton.DatabaseConnection;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Library Management System ===\n");

        // Singleton - database connection
        System.out.println("--- Singleton ---");
        DatabaseConnection db = DatabaseConnection.getInstance();
        System.out.println("Database instance: " + db);

        // Simple Factory - create users
        System.out.println("\n--- Simple Factory ---");
        SystemUser librarian = SystemUserFactory.createUser(
                UserRole.LIBRARIAN, "U001", "alice", "pass123");
        SystemUser admin = SystemUserFactory.createUser(
                UserRole.SYSTEM_ADMIN, "U002", "bob", "pass456");
        SystemUser headLibrarian = SystemUserFactory.createUser(
                UserRole.HEAD_LIBRARIAN, "U003", "mokoena", "pass789");

        // Authenticate librarian
        System.out.println("\n--- Authentication ---");
        boolean authenticated = librarian.authenticate("pass123");
        System.out.println("Librarian authenticated: " + authenticated);

        // Builder - create patron step by step
        System.out.println("\n--- Builder ---");
        Patron patron = new PatronBuilder("P001", "John Dlamini",
                AffiliationType.STUDENT)
                .withInstitutionId("STU2024001")
                .withEmail("john@uni.ac.za")
                .withPhone("0821234567")
                .build();
        System.out.println("Patron created: " + patron.getName());

        // Prototype - clone book templates
        System.out.println("\n--- Prototype ---");
        Book textbook = BookPrototypeCache.getClone("TEXTBOOK");
        textbook.setTitle("Software Engineering");
        textbook.setAuthor("Ian Sommerville");
        System.out.println("Book cloned: " + textbook.getTitle());

        // Factory Method - generate report
        System.out.println("\n--- Factory Method ---");
        ReportFactory reportFactory = new CirculationReportFactory();
        Report report = reportFactory.createReport("R001", headLibrarian);
        report.generate();
        System.out.println("Report generated: " + report.getReportType());

        // Abstract Factory - notifications
        System.out.println("\n--- Abstract Factory ---");
        NotificationFactory notificationFactory = new ConsoleNotificationFactory();
        notificationFactory.createBookNotification()
                .notifyOverdue("John Dlamini", "Software Engineering");
        notificationFactory.createPatronNotification()
                .notifyRegistration("John Dlamini");

        // Process checkout
        System.out.println("\n--- Checkout ---");
        Loan loan = librarian.processCheckout(textbook, patron);
        if (loan != null) {
            System.out.println("Loan created: " + loan.getLoanId());
        }

        System.out.println("\n=== System Ready ===");
    }
}
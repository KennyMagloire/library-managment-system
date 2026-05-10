package com.library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String patronId;
    private String institutionId;
    private String name;
    private String email;
    private String phone;
    private AffiliationType affiliationType;
    private LocalDate registrationDate;
    private int activeLoans;
    private List<Loan> loans;


    public Patron(String patronId, String institutionId, String name,
                  String email, String phone, AffiliationType affiliationType) {
        this.patronId = patronId;
        this.institutionId = institutionId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.affiliationType = affiliationType;
        this.registrationDate =LocalDate.now();
        this.activeLoans = 0;
        this.loans = new ArrayList<>();

    }

    // Getters
    public String getPatronId() { return patronId; }
    public String getInstitutionId() { return institutionId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public AffiliationType getAffiliationType() { return affiliationType; }
    public LocalDate getRegistrationDate() {return registrationDate;}
    public int getActiveLoans() {return activeLoans;}
    public List<Loan> getLoans() {return loans;}

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setActiveLoans(int activeLoans) { this.activeLoans = activeLoans; }


    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }
    public void updateDetails(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean canBorrow() {
        return activeLoans < 5 && !hasOutstandingFines();
    }

    public boolean hasOutstandingFines() {
        for (Loan loan : loans) {
            if (loan.calculateFine() > 0) {
                return true;
            }
        }
        return false;
    }
    public boolean isActive() {
        // In production this would call the university API to validate institutionId
        // e.g. UniversityService.validateId(this.institutionId)
        // For now we assume all registered patrons are active
        return true;
    }


    }



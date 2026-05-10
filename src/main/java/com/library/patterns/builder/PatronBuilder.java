package com.library.patterns.builder;

import com.library.AffiliationType;
import com.library.Patron;

public class PatronBuilder {

    // Required fields
    private final String patronId;
    private final String name;
    private final AffiliationType affiliationType;

    // Optional fields
    private String institutionId = "N/A";
    private String email = "N/A";
    private String phone = "N/A";

    // Constructor only takes required fields
    public PatronBuilder(String patronId, String name,
                         AffiliationType affiliationType) {
        if (patronId == null || patronId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patron ID is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (affiliationType == null) {
            throw new IllegalArgumentException("Affiliation type is required");
        }
        this.patronId = patronId;
        this.name = name;
        this.affiliationType = affiliationType;
    }

    // Fluent setters for optional fields
    public PatronBuilder withInstitutionId(String institutionId) {
        this.institutionId = institutionId;
        return this;
    }

    public PatronBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PatronBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    // Build the final Patron object
    public Patron build() {
        return new Patron(patronId, institutionId, name,
                email, phone, affiliationType);
    }
}
package com.library.service;

import com.library.Patron;
import com.library.AffiliationType;
import com.library.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {

    private final PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(String id) {
        return patronRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patron not found: " + id));
    }

    public Patron addPatron(Patron patron) {
        patronRepository.save(patron);
        return patron;
    }

    public List<Patron> getActivePatrons() {
        return patronRepository.findActivePatrons();
    }

    public List<Patron> getPatronsByAffiliation(AffiliationType type) {
        return patronRepository.findByAffiliationType(type);
    }
}
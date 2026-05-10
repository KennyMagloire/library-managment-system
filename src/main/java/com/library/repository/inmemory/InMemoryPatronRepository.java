package com.library.repository.inmemory;

import com.library.AffiliationType;
import com.library.Patron;
import com.library.repository.PatronRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryPatronRepository implements PatronRepository {

    private final Map<String, Patron> storage = new HashMap<>();

    @Override
    public void save(Patron patron) {
        if (patron == null || patron.getPatronId() == null) {
            throw new IllegalArgumentException("Patron or PatronId cannot be null");
        }
        storage.put(patron.getPatronId(), patron);
    }

    @Override
    public Optional<Patron> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Patron> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public List<Patron> findByAffiliationType(AffiliationType affiliationType) {
        return storage.values().stream()
                .filter(p -> p.getAffiliationType() == affiliationType)
                .collect(Collectors.toList());
    }

    @Override
    public List<Patron> findActivePatrons() {
        return storage.values().stream()
                .filter(Patron::isActive)
                .collect(Collectors.toList());
    }
}
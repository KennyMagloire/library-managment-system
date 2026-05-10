package com.library.repository.inmemory;

import com.library.Fine;
import com.library.FineStatus;
import com.library.repository.FineRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryFineRepository implements FineRepository {

    private final Map<String, Fine> storage = new HashMap<>();

    @Override
    public void save(Fine fine) {
        if (fine == null || fine.getFineId() == null) {
            throw new IllegalArgumentException("Fine or FineId cannot be null");
        }
        storage.put(fine.getFineId(), fine);
    }

    @Override
    public Optional<Fine> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Fine> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public List<Fine> findByPatronId(String patronId) {
        return storage.values().stream()
                .filter(f -> f.getLoan().getPatron().getPatronId().equals(patronId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fine> findByStatus(FineStatus status) {
        return storage.values().stream()
                .filter(f -> f.getStatus() == status)
                .collect(Collectors.toList());
    }
}
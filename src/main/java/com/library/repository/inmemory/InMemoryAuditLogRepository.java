package com.library.repository.inmemory;

import com.library.AuditLog;
import com.library.AuditAction;
import com.library.repository.AuditLogRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryAuditLogRepository implements AuditLogRepository {

    private final Map<String, AuditLog> storage = new HashMap<>();

    @Override
    public void save(AuditLog log) {
        if (log == null || log.getLogId() == null) {
            throw new IllegalArgumentException("AuditLog or LogId cannot be null");
        }
        storage.put(log.getLogId(), log);
    }

    @Override
    public Optional<AuditLog> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<AuditLog> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public List<AuditLog> findByUserId(String userId) {
        return storage.values().stream()
                .filter(l -> l.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditLog> findByAction(AuditAction action) {
        return storage.values().stream()
                .filter(l -> l.getAction() == action)
                .collect(Collectors.toList());
    }
}
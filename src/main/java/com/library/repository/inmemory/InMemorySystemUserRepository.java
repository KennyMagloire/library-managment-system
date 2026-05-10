package com.library.repository.inmemory;

import com.library.SystemUser;
import com.library.UserRole;
import com.library.repository.SystemUserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemorySystemUserRepository implements SystemUserRepository {

    private final Map<String, SystemUser> storage = new HashMap<>();

    @Override
    public void save(SystemUser user) {
        if (user == null || user.getUserId() == null) {
            throw new IllegalArgumentException("User or UserId cannot be null");
        }
        storage.put(user.getUserId(), user);
    }

    @Override
    public Optional<SystemUser> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<SystemUser> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    @Override
    public Optional<SystemUser> findByUsername(String username) {
        return storage.values().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public List<SystemUser> findByRole(UserRole role) {
        return storage.values().stream()
                .filter(u -> u.getRole() == role)
                .collect(Collectors.toList());
    }
}
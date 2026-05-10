package com.library.repository;

import com.library.SystemUser;
import com.library.UserRole;
import java.util.List;
import java.util.Optional;

public interface SystemUserRepository extends Repository<SystemUser, String> {

    Optional<SystemUser> findByUsername(String username);
    List<SystemUser> findByRole(UserRole role);
}
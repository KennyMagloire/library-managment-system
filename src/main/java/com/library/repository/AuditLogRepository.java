package com.library.repository;

import com.library.AuditLog;
import com.library.AuditAction;
import java.util.List;

public interface AuditLogRepository extends Repository<AuditLog, String> {

    List<AuditLog> findByUserId(String userId);
    List<AuditLog> findByAction(AuditAction action);
}
package com.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {

    private String logId;
    private AuditAction action;
    private String userId;
    private LocalDateTime timestamp;
    private String details;

    private static List<AuditLog> entries = new ArrayList<>();

    public AuditLog(String logId, AuditAction action,
                    String userId, String details) {
        this.logId = logId;
        this.action = action;
        this.userId = userId;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }

    // Getters
    public String getLogId() { return logId; }
    public AuditAction getAction() { return action; }
    public String getUserId() { return userId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getDetails() { return details; }


    public static void logAction(String logId, AuditAction action,
                                 String userId, String details) {
        AuditLog entry = new AuditLog(logId, action, userId, details);
        entries.add(entry);
        System.out.println("[" + entry.timestamp + "] "
                + action + " by " + userId + " — " + details);
    }

    public static List<AuditLog> getEntries(LocalDateTime startDate,
                                            LocalDateTime endDate) {
        List<AuditLog> result = new ArrayList<>();
        for (AuditLog entry : entries) {
            if (!entry.timestamp.isBefore(startDate)
                    && !entry.timestamp.isAfter(endDate)) {
                result.add(entry);
            }
        }
        return result;
    }

}
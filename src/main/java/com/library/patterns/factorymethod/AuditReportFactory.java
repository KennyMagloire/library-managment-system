package com.library.patterns.factorymethod;

import com.library.Report;
import com.library.ReportType;
import com.library.SystemUser;

public class AuditReportFactory implements ReportFactory {

    @Override
    public Report createReport(String reportId, SystemUser generatedBy) {
        System.out.println("Creating Audit Report...");
        return new Report(reportId, ReportType.AUDIT, generatedBy);
    }
}
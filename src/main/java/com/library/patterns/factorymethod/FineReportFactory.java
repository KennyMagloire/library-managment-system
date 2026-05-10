package com.library.patterns.factorymethod;

import com.library.Report;
import com.library.ReportType;
import com.library.SystemUser;

public class FineReportFactory implements ReportFactory {

    @Override
    public Report createReport(String reportId, SystemUser generatedBy) {
        System.out.println("Creating Fine Report...");
        return new Report(reportId, ReportType.FINES, generatedBy);
    }
}
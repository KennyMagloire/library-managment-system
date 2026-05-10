package com.library.patterns.factorymethod;

import com.library.Report;
import com.library.ReportType;
import com.library.SystemUser;

public class CirculationReportFactory implements ReportFactory {

    @Override
    public Report createReport(String reportId, SystemUser generatedBy) {
        System.out.println("Creating Circulation Report...");
        return new Report(reportId, ReportType.CIRCULATION, generatedBy);
    }
}
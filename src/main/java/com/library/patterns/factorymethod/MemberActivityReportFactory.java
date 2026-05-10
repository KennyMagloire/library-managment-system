package com.library.patterns.factorymethod;

import com.library.Report;
import com.library.ReportType;
import com.library.SystemUser;

public class MemberActivityReportFactory implements ReportFactory {

    @Override
    public Report createReport(String reportId, SystemUser generatedBy) {
        System.out.println("Creating Member Activity Report...");
        return new Report(reportId, ReportType.MEMBER_ACTIVITY, generatedBy);
    }
}
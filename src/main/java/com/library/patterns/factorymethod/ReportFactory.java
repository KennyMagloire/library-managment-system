package com.library.patterns.factorymethod;

import com.library.Report;
import com.library.SystemUser;

public interface ReportFactory {
    Report createReport(String reportId, SystemUser generatedBy);
}
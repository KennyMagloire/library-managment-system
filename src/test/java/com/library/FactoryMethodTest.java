package com.library;

import com.library.patterns.factorymethod.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryMethodTest {

    private SystemUser headLibrarian;

    @BeforeEach
    public void setUp() {
        headLibrarian = new SystemUser("U001", "mokoena",
                "pass123", UserRole.HEAD_LIBRARIAN);
    }

    @Test
    public void testCirculationReportFactory() {
        ReportFactory factory = new CirculationReportFactory();
        Report report = factory.createReport("R001", headLibrarian);

        assertNotNull(report);
        assertEquals(ReportType.CIRCULATION, report.getReportType());
    }

    @Test
    public void testFineReportFactory() {
        ReportFactory factory = new FineReportFactory();
        Report report = factory.createReport("R002", headLibrarian);

        assertNotNull(report);
        assertEquals(ReportType.FINES, report.getReportType());
    }

    @Test
    public void testAuditReportFactory() {
        ReportFactory factory = new AuditReportFactory();
        Report report = factory.createReport("R003", headLibrarian);

        assertNotNull(report);
        assertEquals(ReportType.AUDIT, report.getReportType());
    }

    @Test
    public void testMemberActivityReportFactory() {
        ReportFactory factory = new MemberActivityReportFactory();
        Report report = factory.createReport("R004", headLibrarian);

        assertNotNull(report);
        assertEquals(ReportType.MEMBER_ACTIVITY, report.getReportType());
    }

    @Test
    public void testDifferentFactoriesProduceDifferentReports() {
        ReportFactory circulation = new CirculationReportFactory();
        ReportFactory audit = new AuditReportFactory();

        Report r1 = circulation.createReport("R005", headLibrarian);
        Report r2 = audit.createReport("R006", headLibrarian);

        assertNotEquals(r1.getReportType(), r2.getReportType());
    }
}
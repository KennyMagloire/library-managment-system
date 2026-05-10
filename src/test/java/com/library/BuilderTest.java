package com.library;

import com.library.patterns.builder.PatronBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    @Test
    public void testBuildWithRequiredFieldsOnly() {
        Patron patron = new PatronBuilder("P001", "John",
                AffiliationType.STUDENT).build();

        assertNotNull(patron);
        assertEquals("P001", patron.getPatronId());
        assertEquals("John", patron.getName());
    }

    @Test
    public void testBuildWithAllFields() {
        Patron patron = new PatronBuilder("P002", "Alice",
                AffiliationType.LECTURER)
                .withInstitutionId("LEC001")
                .withEmail("alice@uni.ac.za")
                .withPhone("0821234567")
                .build();

        assertNotNull(patron);
        assertEquals("LEC001", patron.getInstitutionId());
        assertEquals("alice@uni.ac.za", patron.getEmail());
        assertEquals("0821234567", patron.getPhone());
    }

    @Test
    public void testNullPatronIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new PatronBuilder(null, "John", AffiliationType.STUDENT)
        );
    }

    @Test
    public void testNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new PatronBuilder("P003", null, AffiliationType.STUDENT)
        );
    }

    @Test
    public void testNullAffiliationTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new PatronBuilder("P004", "John", null)
        );
    }
}
package com.library.service;

import com.library.AffiliationType;
import com.library.Patron;
import com.library.repository.PatronRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatronServiceTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

    private Patron testPatron;

    @BeforeEach
    void setUp() {
        testPatron = new Patron("P001", "STU2024001", "John Dlamini",
                "john@univ.ac.za", "0821234567", AffiliationType.STUDENT);
    }

    @Test
    void getAllPatrons_returnsAllPatrons() {
        when(patronRepository.findAll()).thenReturn(List.of(testPatron));
        List<Patron> result = patronService.getAllPatrons();
        assertEquals(1, result.size());
        verify(patronRepository).findAll();
    }

    @Test
    void getPatronById_found() {
        when(patronRepository.findById("P001")).thenReturn(Optional.of(testPatron));
        Patron result = patronService.getPatronById("P001");
        assertNotNull(result);
        assertEquals("John Dlamini", result.getName());
    }

    @Test
    void getPatronById_notFound_throwsException() {
        when(patronRepository.findById("P999")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> patronService.getPatronById("P999"));
    }

    @Test
    void addPatron_savesAndReturnsPatron() {
        patronService.addPatron(testPatron);
        verify(patronRepository).save(testPatron);
    }

    @Test
    void getActivePatrons_returnsActivePatrons() {
        when(patronRepository.findActivePatrons()).thenReturn(List.of(testPatron));
        List<Patron> result = patronService.getActivePatrons();
        assertEquals(1, result.size());
        verify(patronRepository).findActivePatrons();
    }
}
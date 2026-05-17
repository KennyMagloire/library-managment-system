package com.library.api;

import com.library.Patron;
import com.library.AffiliationType;
import com.library.service.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons() {
        return ResponseEntity.ok(patronService.getAllPatrons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable String id) {
        return ResponseEntity.ok(patronService.getPatronById(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Patron>> getActivePatrons() {
        return ResponseEntity.ok(patronService.getActivePatrons());
    }

    @GetMapping("/affiliation/{type}")
    public ResponseEntity<List<Patron>> getPatronsByAffiliation(@PathVariable AffiliationType type) {
        return ResponseEntity.ok(patronService.getPatronsByAffiliation(type));
    }

    @PostMapping
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patronService.addPatron(patron));
    }
}
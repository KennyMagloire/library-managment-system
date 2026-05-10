package com.library.patterns.prototype;

import com.library.Book;
import java.util.HashMap;
import java.util.Map;

public class BookPrototypeCache {

    private static Map<String, Book> prototypes = new HashMap<>();

    static {
        // Pre-configured textbook template
        Book textbook = new Book(
                "TEMPLATE-TXT", "978-000-001",
                "Textbook Template", "Various Authors",
                "Academic", 2024, 1
        );
        prototypes.put("TEXTBOOK", textbook);

        // Pre-configured fiction template
        Book fiction = new Book(
                "TEMPLATE-FIC", "978-000-002",
                "Fiction Template", "Various Authors",
                "Fiction", 2024, 1
        );
        prototypes.put("FICTION", fiction);

        // Pre-configured reference template
        Book reference = new Book(
                "TEMPLATE-REF", "978-000-003",
                "Reference Template", "Various Authors",
                "Reference", 2024, 3
        );
        prototypes.put("REFERENCE", reference);
    }

    public static Book getClone(String templateKey) {
        Book prototype = prototypes.get(templateKey.toUpperCase());
        if (prototype == null) {
            throw new IllegalArgumentException(
                    "No prototype found for key: " + templateKey);
        }
        return prototype.clone();
    }

    public static void addPrototype(String key, Book book) {
        prototypes.put(key.toUpperCase(), book);
    }
}
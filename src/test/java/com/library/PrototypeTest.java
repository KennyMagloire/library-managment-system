package com.library;

import com.library.patterns.prototype.BookPrototypeCache;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {

    @Test
    public void testCloneIsNotSameReference() {
        Book original = BookPrototypeCache.getClone("TEXTBOOK");
        Book clone = BookPrototypeCache.getClone("TEXTBOOK");

        assertNotSame(original, clone);
    }

    @Test
    public void testCloneHasSameCategory() {
        Book textbook = BookPrototypeCache.getClone("TEXTBOOK");
        assertEquals("Academic", textbook.getGenre());

        Book fiction = BookPrototypeCache.getClone("FICTION");
        assertEquals("Fiction", fiction.getGenre());
    }

    @Test
    public void testModifyingCloneDoesNotAffectPrototype() {
        Book clone1 = BookPrototypeCache.getClone("TEXTBOOK");
        clone1.setTitle("Modified Title");

        Book clone2 = BookPrototypeCache.getClone("TEXTBOOK");
        assertEquals("Textbook Template", clone2.getTitle());
    }

    @Test
    public void testInvalidKeyThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                BookPrototypeCache.getClone("INVALID_KEY")
        );
    }

    @Test
    public void testReferencePrototypeHasThreeCopies() {
        Book reference = BookPrototypeCache.getClone("REFERENCE");
        assertEquals(3, reference.getTotalCopies());
    }
}
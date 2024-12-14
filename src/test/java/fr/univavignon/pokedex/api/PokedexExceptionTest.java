package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test class for PokedexException.
 */
public class PokedexExceptionTest {

    /**
     * Tests the PokedexException constructor with a message.
     * Ensures that the correct message is returned.
     */
    @Test
    public void testPokedexExceptionMessage() {
        String errorMessage = "This is a test error message";
        PokedexException exception = new PokedexException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    /**
     * Tests the inheritance of PokedexException.
     * Ensures that PokedexException is an instance of Exception.
     */
    @Test
    public void testPokedexExceptionInheritance() {
        PokedexException exception = new PokedexException("Test");
        assertTrue(exception instanceof Exception);
    }
}
package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class PokedexExceptionTest {

    @Test
    public void testPokedexExceptionMessage() {
        String errorMessage = "This is a test error message";
        PokedexException exception = new PokedexException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testPokedexExceptionInheritance() {
        PokedexException exception = new PokedexException("Test");
        assertTrue(exception instanceof Exception);
    }
}
package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Pokemon.
 */
public class PokemonTest {

    private Pokemon pokemon;

    /**
     * Sets up the test environment by initializing a Pokemon.
     */
    @Before
    public void setUp() {
        pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1115, 100, 3000, 3, 0);
    }


    /**
     * Tests the getIndex method of Pokemon.
     * Ensures that the correct index is returned.
     */
    @Test
    public void testGetCp() {
        assertEquals(1115, pokemon.getCp());
    }

    /**
     * Tests the getHp method of Pokemon.
     * Ensures that the correct hp value is returned.
     */
    @Test
    public void testGetHp() {
        assertEquals(100, pokemon.getHp());
    }

    /**
     * Tests the getDust method of Pokemon.
     * Ensures that the correct dust value is returned.
     */
    @Test
    public void testGetDust() {
        assertEquals(3000, pokemon.getDust());
    }

    /**
     * Tests the getCandy method of Pokemon.
     * Ensures that the correct candy value is returned.
     */
    @Test
    public void testGetCandy() {
        assertEquals(3, pokemon.getCandy());
    }

    /**
     * Tests the toString method of Pokemon.
     * Prints the string representation of the Pokemon.
     */
    @Test
    public void testToString() {
        System.out.println(pokemon);
    }
}
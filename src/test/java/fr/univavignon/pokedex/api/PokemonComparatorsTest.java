package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonComparators.
 */
public class PokemonComparatorsTest {

    private Pokemon bulbasaur;
    private Pokemon ivysaur;
    private Pokemon venusaur;

    /**
     * Sets up the test environment by initializing Pokemon instances.
     */
    @Before
    public void setUp() {
        bulbasaur = new Pokemon(0, "Bulbasaur", 615, 78, 351, 78, 54, 65, 23);
        ivysaur = new Pokemon(1, "Ivysaur", 613, 64, 56, 98, 785, 47, 15);
        venusaur = new Pokemon(2, "Venusaur", 613, 64, 4000, 4, 74, 36, 98);
    }

    /**
     * Tests the getName method of Pokemon.
     * Ensures that the correct name is returned for each Pokemon.
     */
    @Test
    public void testGetName() {
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Ivysaur", ivysaur.getName());
        assertEquals("Venusaur", venusaur.getName());
        System.out.println("Bulbasaur name: " + bulbasaur.getName());
        System.out.println("Ivysaur name: " + ivysaur.getName());
        System.out.println("Venusaur name: " + venusaur.getName());
    }
}
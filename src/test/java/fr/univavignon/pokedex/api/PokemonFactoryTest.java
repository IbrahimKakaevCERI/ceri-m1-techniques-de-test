package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonFactory.
 */
public class PokemonFactoryTest {

    private PokemonFactory pokemonFactory;

    /**
     * Sets up the test environment by initializing the PokemonFactory.
     */
    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    /**
     * Tests the createPokemon method of PokemonFactory.
     * Ensures that the created Pokemon has the correct attributes.
     */
    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 100, 3000, 3);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(500, pokemon.getDefense());
        assertEquals(100, pokemon.getStamina());
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
    }
}
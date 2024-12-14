package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonMetadata.
 */
public class PokemonMetadataTest {

    private PokemonMetadata pokemonMetadata;

    /**
     * Sets up the test environment by initializing a PokemonMetadata instance.
     */
    @Before
    public void setUp() {
        pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
    }

    /**
     * Tests the getIndex method of PokemonMetadata.
     * Ensures that the correct index is returned.
     */
    @Test
    public void testGetIndex() {
        assertEquals(1, pokemonMetadata.getIndex());
    }

    /**
     * Tests the getName method of PokemonMetadata.
     * Ensures that the correct name is returned.
     */
    @Test
    public void testGetName() {
        assertEquals("Bulbasaur", pokemonMetadata.getName());
    }

    /**
     * Tests the getAttack method of PokemonMetadata.
     * Ensures that the correct attack value is returned.
     */
    @Test
    public void testGetAttack() {
        assertEquals(126, pokemonMetadata.getAttack());
    }

    /**
     * Tests the getDefense method of PokemonMetadata.
     * Ensures that the correct defense value is returned.
     */
    @Test
    public void testGetDefense() {
        assertEquals(126, pokemonMetadata.getDefense());
    }

    /**
     * Tests the getStamina method of PokemonMetadata.
     * Ensures that the correct stamina value is returned.
     */
    @Test
    public void testGetStamina() {
        assertEquals(90, pokemonMetadata.getStamina());
    }
}
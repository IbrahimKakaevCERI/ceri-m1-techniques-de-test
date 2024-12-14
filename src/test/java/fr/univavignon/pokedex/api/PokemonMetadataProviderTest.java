package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonMetadataProvider.
 */
public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider provider;

    /**
     * Sets up the test environment by initializing the PokemonMetadataProvider.
     */
    @Before
    public void setUp() {
        provider = new PokemonMetadataProvider();
    }

    /**
     * Tests the getPokemonMetadata method with a valid index.
     * Ensures that the correct metadata is returned for Bulbasaur.
     *
     * @throws PokedexException if the index is invalid
     */
    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    /**
     * Tests the getPokemonMetadata method with an invalid index.
     * Expects a PokedexException to be thrown.
     *
     * @throws PokedexException if the index is invalid
     */
    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        try {
            provider.getPokemonMetadata(-1);
            fail("Expected a PokedexException to be thrown");
        } catch (PokedexException e) {
            // Expected exception
        }
    }
}
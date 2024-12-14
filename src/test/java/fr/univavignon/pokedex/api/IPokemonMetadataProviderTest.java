package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokemonMetadataProvider.
 */
public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider provider;

    /**
     * Sets up the test environment by initializing the mock for IPokemonMetadataProvider.
     */
    @Before
    public void setUp() {
        provider = mock(IPokemonMetadataProvider.class);
    }

    /**
     * Tests the getPokemonMetadata method with a valid index.
     * Ensures that the correct metadata is returned for Bulbizarre.
     *
     * @throws PokedexException if the index is invalid
     */
    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        // Métadonnées pour Bulbizarre
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(provider.getPokemonMetadata(0)).thenReturn(metadata);

        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", result.getName());
    }

    /**
     * Tests the getPokemonMetadata method with an invalid index.
     * Expects a PokedexException to be thrown.
     *
     * @throws PokedexException if the index is invalid
     */
    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        when(provider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));
        provider.getPokemonMetadata(-1);
    }
}

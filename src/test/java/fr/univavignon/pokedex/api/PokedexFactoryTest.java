package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * Test class for PokedexFactory.
 */
public class PokedexFactoryTest {

    private PokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    /**
     * Sets up the test environment by initializing the PokedexFactory and mocks for IPokemonMetadataProvider and IPokemonFactory.
     */
    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    /**
     * Tests the createPokedex method of PokedexFactory.
     * Ensures that the created Pokedex is not null and is an instance of Pokedex.
     */
    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);
    }
}
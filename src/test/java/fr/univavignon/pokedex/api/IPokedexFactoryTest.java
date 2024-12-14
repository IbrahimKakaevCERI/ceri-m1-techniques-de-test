package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokedexFactory.
 */
public class IPokedexFactoryTest {
    private IPokedexFactory factory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    /**
     * Sets up the test environment by initializing the mocks.
     */
    @Before
    public void setUp() {
        factory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    /**
     * Tests the createPokedex method of IPokedexFactory.
     * Ensures that the created Pokedex is not null.
     */
    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = mock(IPokedex.class);
        when(factory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(result);
    }
}

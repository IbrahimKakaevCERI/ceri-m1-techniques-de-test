package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class PokedexFactoryTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    private PokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pokedexFactory = PokedexFactory.getInstance();
    }

    @Test
    public void testGetInstance() {
        PokedexFactory instance1 = PokedexFactory.getInstance();
        PokedexFactory instance2 = PokedexFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);
    }
}
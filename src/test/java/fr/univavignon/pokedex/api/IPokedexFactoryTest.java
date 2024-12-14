package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
    private IPokedexFactory factory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        factory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = mock(IPokedex.class);
        when(factory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(result);
    }
}

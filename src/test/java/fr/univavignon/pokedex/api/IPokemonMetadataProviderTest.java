package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider provider;

    @Before
    public void setUp() {
        provider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(provider.getPokemonMetadata(0)).thenReturn(metadata);

        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertEquals(0, result.getIndex());
        assertEquals("Bulbizarre", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        when(provider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));
        provider.getPokemonMetadata(-1);
    }
}


package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class PokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() {
        pokemonMetadataProvider = PokemonMetadataProvider.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(pokemonMetadataProvider);
        assertEquals(pokemonMetadataProvider, PokemonMetadataProvider.getInstance());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(1);
        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Pokemon1", metadata.getName());
        assertEquals(0, metadata.getAttack());
        assertEquals(0, metadata.getDefense());
        assertEquals(0, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        pokemonMetadataProvider.getPokemonMetadata(-1);
    }
}
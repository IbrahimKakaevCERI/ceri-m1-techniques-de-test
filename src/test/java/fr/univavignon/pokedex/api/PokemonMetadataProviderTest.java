package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;


public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider provider;

    @Before
    public void setUp() {
        provider = new PokemonMetadataProvider();
    }

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

    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        try {
            provider.getPokemonMetadata(999);
            fail("Expected a PokedexException to be thrown");
        } catch (PokedexException e) {
            assertEquals("Pokemon metadata not found for index: 999", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonMetadataAnotherValidIndex() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(1);
        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Ivysaur", metadata.getName());
        assertEquals(156, metadata.getAttack());
        assertEquals(158, metadata.getDefense());
        assertEquals(120, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataYetAnotherValidIndex() throws PokedexException {
        PokemonMetadata metadata = provider.getPokemonMetadata(2);
        assertNotNull(metadata);
        assertEquals(2, metadata.getIndex());
        assertEquals("Venusaur", metadata.getName());
        assertEquals(198, metadata.getAttack());
        assertEquals(200, metadata.getDefense());
        assertEquals(160, metadata.getStamina());
    }
}
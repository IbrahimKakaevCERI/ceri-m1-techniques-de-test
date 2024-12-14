package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class PokemonMetadataTest {

    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() {
        pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
    }

    @Test
    public void testGetIndex() {
        assertEquals(1, pokemonMetadata.getIndex());
    }

    @Test
    public void testGetName() {
        assertEquals("Bulbasaur", pokemonMetadata.getName());
    }

    @Test
    public void testGetAttack() {
        assertEquals(126, pokemonMetadata.getAttack());
    }

    @Test
    public void testGetDefense() {
        assertEquals(126, pokemonMetadata.getDefense());
    }

    @Test
    public void testGetStamina() {
        assertEquals(90, pokemonMetadata.getStamina());
    }
}
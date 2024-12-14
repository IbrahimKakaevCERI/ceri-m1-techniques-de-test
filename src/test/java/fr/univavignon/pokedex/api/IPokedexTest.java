package fr.univavignon.pokedex.api;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokedex.
 */
public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon aquali;

    /**
     * Sets up the test environment by initializing the mocks and creating Pokemon instances.
     */
    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        
        // Création des instances de Pokémon avec les données fournies
        bulbasaur = new Pokemon(613, "Bulbizarre", 613, 64, 4000, 4, 0, 0, 0);
        aquali = new Pokemon(134, "Aquali", 2729, 202, 5000, 4, 0, 0, 0);
    }

    /**
     * Tests the addPokemon method of IPokedex.
     * Ensures that the correct index is returned when a Pokemon is added.
     */
    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
    }

    /**
     * Tests the getPokemon method of IPokedex.
     * Ensures that the correct Pokemon is returned when its index is provided.
     */
    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        Pokemon result = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", result.getName());
    }

    /**
     * Tests the getPokemon method of IPokedex with an invalid index.
     * Ensures that a PokedexException is thrown when an invalid index is provided.
     */
    @Test(expected = PokedexException.class)
    public void testGetPokemon_InvalidId() throws PokedexException {
        when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("Invalid index"));
        pokedex.getPokemon(-1);
    }

    /**
     * Tests the size method of IPokedex.
     * Ensures that the correct number of Pokemon is returned.
     */
    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(List.of(bulbasaur, aquali));
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }
}

package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for Pokedex.
 */
public class PokedexTest {

    private Pokedex pokedex;
    private Pokemon pokemon;

    /**
     * Sets up the test environment by initializing the Pokedex and a Pokemon.
     */
    @Before
    public void setUp() {
        pokedex = new Pokedex();
        pokemon = new Pokemon(0, "Pikachu",1000, 500, 100, 500, 100, 100, 100, 0);
    }

    /**
     * Tests the addPokemon method of IPokedex.
     * Ensures that the Pokemon is correctly added to the Pokedex.
     */
    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    /**
     * Tests the getPokemon method of IPokedex.
     * Ensures that the correct Pokemon is retrieved.
     */
    @Test
    public void testGetPokemon() {
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(pokemon, retrievedPokemon);
    }

    /**
     * Tests the getPokemon method with an invalid index.
     * Expects an IndexOutOfBoundsException to be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPokemonWithInvalidIndex() {
        pokedex.getPokemon(1);
    }

    /**
     * Tests the size method of IPokedex.
     * Ensures that the size is correctly updated when Pokemon are added.
     */
    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    /**
     * Tests the getPokemons method of IPokedex.
     * Ensures that the correct list of Pokemon is retrieved.
     */
    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(pokemon);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
        assertEquals(pokemon, pokemons.get(0));
    }

    /**
     * Tests the getPokemons method with a comparator.
     * Ensures that the list of Pokemon is correctly sorted.
     */
    @Test
    public void testGetPokemonsWithComparator() {
        Pokemon pokemon2 = new Pokemon(1, "Bulbizarre", 1000, 500, 100, 100, 100, 100, 100, 0);
        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(2, pokemons.size());
        assertEquals(pokemon2, pokemons.get(0));
        assertEquals(pokemon, pokemons.get(1));

        pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getIndex));
        assertEquals(2, pokemons.size());
        assertEquals(pokemon, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }


    /**
     * Tests the createPokemon method of IPokedex.
     * Ensures that the created Pokemon has the correct attributes.
     */
    @Test
    public void testCreatePokemon() {
        Pokemon createdPokemon = pokedex.createPokemon(0, 95 , 126, 90, 2000);
        System.out.println(createdPokemon);
        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Pikachu", createdPokemon.getName());
        assertEquals(95, createdPokemon.getCp());
        assertEquals(126, createdPokemon.getHp());
        assertEquals(90, createdPokemon.getDust());
        assertEquals(2000, createdPokemon.getCandy());
        
    }

    /**
     * Tests the getPokemonMetadata method of IPokedex.
     * Ensures that the correct metadata is retrieved.
     */
    @Test
    public void testGetPokemonMetadata() {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
    }
}
package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;



public class PokedexTest {

    private Pokedex pokedex;
    private Pokemon pokemon;

    @Before
    public void setUp() {
        pokedex = new Pokedex();
        pokemon = new Pokemon(0, "Pikachu",1000, 500, 100, 500, 100, 100, 100);
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() {
        pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertEquals(pokemon, retrievedPokemon);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPokemonWithInvalidIndex() {
        pokedex.getPokemon(1);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(pokemon);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(1, pokemons.size());
        assertEquals(pokemon, pokemons.get(0));
    }

    @Test
    public void testGetPokemonsWithComparator() {
        Pokemon pokemon2 = new Pokemon(1, "Bulbizarre", 1000, 500, 100, 100, 100, 100, 100);
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

    @Test
    public void testGetPokemonMetadata() {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
        assertNotNull(metadata);
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizare", metadata.getName());
    }
}
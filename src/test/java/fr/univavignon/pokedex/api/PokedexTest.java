package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;



public class PokedexTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokedex pokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(pokemon, pokedex.getPokemon(index));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokedex.addPokemon(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(0));
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(0);
    }

    @Test
    public void testGetPokemons() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 1000, 123, 5000, 5, 100);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(pokemon1));
        assertTrue(pokemons.contains(pokemon2));
    }

    @Test
    public void testGetPokemonsWithOrder() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(1, "Ivysaur", 156, 158, 120, 1000, 123, 5000, 5, 100);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals(2, pokemons.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(metadata);
        assertEquals(metadata, pokedex.getPokemonMetadata(0));
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("Index out of range"));
        pokedex.getPokemonMetadata(0);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertEquals(pokemon, pokedex.createPokemon(0, 613, 64, 4000, 4));
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        when(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4)).thenThrow(new IllegalArgumentException("Invalid index"));
        try {
            pokedex.createPokemon(-1, 613, 64, 4000, 4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid index", e.getMessage());
        }
    }

    @Test
    public void testCreatePokemonWithInvalidCp() {
        when(pokemonFactory.createPokemon(0, -1, 64, 4000, 4)).thenThrow(new IllegalArgumentException("Invalid CP"));
        try {
            pokedex.createPokemon(0, -1, 64, 4000, 4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid CP", e.getMessage());
        }
    }

    @Test
    public void testCreatePokemonWithInvalidHp() {
        when(pokemonFactory.createPokemon(0, 613, -1, 4000, 4)).thenThrow(new IllegalArgumentException("Invalid HP"));
        try {
            pokedex.createPokemon(0, 613, -1, 4000, 4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid HP", e.getMessage());
        }
    }

    @Test
    public void testCreatePokemonWithInvalidDust() {
        when(pokemonFactory.createPokemon(0, 613, 64, -1, 4)).thenThrow(new IllegalArgumentException("Invalid dust"));
        try {
            pokedex.createPokemon(0, 613, 64, -1, 4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid dust", e.getMessage());
        }
    }

    @Test
    public void testCreatePokemonWithInvalidCandy() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, -1)).thenThrow(new IllegalArgumentException("Invalid candy"));
        try {
            pokedex.createPokemon(0, 613, 64, 4000, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid candy", e.getMessage());
        }
    }
    
}
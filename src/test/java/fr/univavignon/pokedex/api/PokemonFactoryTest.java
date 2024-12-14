package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;



public class PokemonFactoryTest {

    private PokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 100, 3000, 3);
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(500, pokemon.getDefense());
        assertEquals(100, pokemon.getStamina());
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(3000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
    }

    @Test
    public void testCreatePokemonWithDifferentValues() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 600, 200, 4000, 4);
        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(500, pokemon.getDefense());
        assertEquals(100, pokemon.getStamina());
        assertEquals(600, pokemon.getCp());
        assertEquals(200, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
    }
}
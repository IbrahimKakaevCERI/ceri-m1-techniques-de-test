package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PokemonTest {

    private Pokemon pokemon;

    @Before
    public void setUp() {
        pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90, 1115, 100, 3000, 3);
    }

    @Test
    public void testGetCp() {
        assertEquals(1115, pokemon.getCp());
    }

    @Test
    public void testGetHp() {
        assertEquals(100, pokemon.getHp());
    }

    @Test
    public void testGetDust() {
        assertEquals(3000, pokemon.getDust());
    }


    @Test
    public void testGetCandy() {
        assertEquals(3, pokemon.getCandy());
    }

    @Test
    public void testToString() {
        System.out.println(pokemon);
    }
}
package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Test class for RocketPokemonFactory.
 */



public class RocketPokemonFactoryTest {

    private RocketPokemonFactory factory;

    @Before
    public void setUp() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        int index = 1;  // Bulbasaur
        int cp = 1000;
        int hp = 100;
        int dust = 200;
        int candy = 10;
        
        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);
        
        assertNotNull(pokemon);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(index, pokemon.getIndex());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);  // Random stat check
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 1000);  // Random stat check
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 1000);  // Random stat check
    }

    @Test
    public void testCreatePokemonWithMissingIndex() {
        int index = -1;  // Ash's Pikachu (Special case)
        int cp = 1500;
        int hp = 200;
        int dust = 500;
        int candy = 15;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(index, pokemon.getIndex());
        assertEquals(1000, pokemon.getAttack());  // Special case for Ash's Pikachu
        assertEquals(1000, pokemon.getDefense());  // Special case for Ash's Pikachu
        assertEquals(1000, pokemon.getStamina());  // Special case for Ash's Pikachu
    }

    @Test
    public void testCreatePokemonWithUnknownIndex() {
        int index = 999;  // Unknown index
        int cp = 500;
        int hp = 50;
        int dust = 100;
        int candy = 5;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName());  // Default for unknown index
        assertEquals(index, pokemon.getIndex());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);  // Random stat check
    }

    @Test
    public void testCreatePokemonStats() {
        int index = 1;  // Bulbasaur
        int cp = 1000;
        int hp = 100;
        int dust = 200;
        int candy = 10;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        // Ensure random stats are in a reasonable range (you can adjust this threshold as needed)
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 1000);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 1000);
    }
}

package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokemonFactory.
 */
public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    /**
     * Sets up the test environment by initializing the mock for IPokemonFactory.
     */
    @Before
    public void setUp() {
        factory = mock(IPokemonFactory.class);
    }

    /**
     * Tests the createPokemon method of IPokemonFactory.
     * Ensures that the created Pokemon has the correct name.
     */
    @Test
    public void testCreatePokemon() {
        // Création des Pokémon avec les données fournies
        Pokemon bulbasaur = new Pokemon(613, "Bulbizarre", 613, 64, 4000, 4 , 0, 0, 0);
        when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);

        Pokemon result = factory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", result.getName());

        Pokemon aquali = new Pokemon(134, "Aquali", 2729, 202, 5000, 4, 0, 0, 0);
        when(factory.createPokemon(1, 2729, 202, 5000, 4)).thenReturn(aquali);

        result = factory.createPokemon(1, 2729, 202, 5000, 4);
        assertEquals("Aquali", result.getName());
    }
}

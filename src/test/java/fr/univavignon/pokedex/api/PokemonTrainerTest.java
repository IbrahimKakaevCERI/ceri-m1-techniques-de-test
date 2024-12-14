package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;




/**
 * Test class for PokemonTrainer.
 */
public class PokemonTrainerTest {

    private PokemonTrainer pokemonTrainer;
    private final String name = "Ash";
    private final Team team = Team.VALOR;
    private IPokedex pokedex;

    /**
     * Sets up the test environment by initializing the mock for IPokedex and creating a PokemonTrainer instance.
     */
    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer(name, team, pokedex);
    }

    /**
     * Tests the getName method of PokemonTrainer.
     * Ensures that the correct name is returned.
     */
    @Test
    public void testGetName() {
        assertEquals(name, pokemonTrainer.getName());
    }

    /**
     * Tests the getTeam method of PokemonTrainer.
     * Ensures that the correct team is returned.
     */
    @Test
    public void testGetTeam() {
        assertEquals(team, pokemonTrainer.getTeam());
    }

    /**
     * Tests the getPokedex method of PokemonTrainer.
     * Ensures that the correct pokedex is returned.
     */
    @Test
    public void testGetPokedex() {
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
}
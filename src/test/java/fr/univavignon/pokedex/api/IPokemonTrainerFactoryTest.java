package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokemonTrainerFactory.
 */
public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory factory;

    /**
     * Sets up the test environment by initializing the mock for IPokemonTrainerFactory.
     */
    @Before
    public void setUp() {
        factory = mock(IPokemonTrainerFactory.class);
    }

    /**
     * Tests the createTrainer method of IPokemonTrainerFactory.
     * Ensures that the created trainer has the correct name and team.
     */
    @Test
    public void testCreateTrainer() {
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        PokemonTrainer trainer = new PokemonTrainer("Ash", Team.MYSTIC, null);
        when(factory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);

        PokemonTrainer result = factory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertEquals("Ash", result.getName());
        assertEquals(Team.MYSTIC, result.getTeam());
    }
}

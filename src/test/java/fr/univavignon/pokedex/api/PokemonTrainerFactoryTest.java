package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Test class for PokemonTrainerFactory.
 */
public class PokemonTrainerFactoryTest {

    private IPokedexFactory pokedexFactory;
    private PokemonTrainerFactory pokemonTrainerFactory;

    /**
     * Sets up the test environment by initializing the mocks and the PokemonTrainerFactory.
     */
    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    /**
     * Tests the createTrainer method of PokemonTrainerFactory.
     * Ensures that the created trainer has the correct name, team, and pokedex.
     */
    @Test
    public void testCreateTrainer() {
        String trainerName = "Ash";
        Team team = Team.VALOR;
        IPokedex pokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(any(PokemonMetadataProvider.class), any(PokemonFactory.class))).thenReturn(pokedex);

        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }
}
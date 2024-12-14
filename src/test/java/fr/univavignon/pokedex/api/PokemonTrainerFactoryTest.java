package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class PokemonTrainerFactoryTest {

    private IPokedexFactory pokedexFactory;
    private PokemonTrainerFactory pokemonTrainerFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

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
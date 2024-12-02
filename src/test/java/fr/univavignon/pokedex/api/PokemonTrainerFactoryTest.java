package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class PokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private PokemonTrainer trainer;

    @Before
    public void setUp() {
        pokemonTrainerFactory = PokemonTrainerFactory.getInstance();
        pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(PokemonMetadataProvider.getInstance(), PokemonFactory.getInstance())).thenReturn(pokedex);
        trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);
    }

    @Test
    public void testGetInstance() {
        assertNotNull(PokemonTrainerFactory.getInstance());
    }

    @Test
    public void testCreateTrainer() {
        assertNotNull(trainer);
        assertNotNull(trainer.getPokedex());
    }

    @Test
    public void testTrainerName() {
        assertNotNull(trainer.getName());
    }

    @Test
    public void testTrainerTeam() {
        assertNotNull(trainer.getTeam());
    }
}
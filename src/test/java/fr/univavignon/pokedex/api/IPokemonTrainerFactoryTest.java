package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory factory;

    @Before
    public void setUp() {
        factory = mock(IPokemonTrainerFactory.class);
    }

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

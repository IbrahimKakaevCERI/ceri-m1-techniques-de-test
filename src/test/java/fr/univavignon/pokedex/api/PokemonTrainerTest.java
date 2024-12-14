package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;




public class PokemonTrainerTest {

    private PokemonTrainer pokemonTrainer;
    private final String name = "Ash";
    private final Team team = Team.VALOR;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer(name, team, pokedex);
    }

    @Test
    public void testGetName() {
        assertEquals(name, pokemonTrainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertEquals(team, pokemonTrainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
}
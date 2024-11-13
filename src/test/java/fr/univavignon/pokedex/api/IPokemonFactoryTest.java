package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    private IPokemonFactory factory;

    @Before
    public void setUp() {
        factory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        // Création des Pokémon avec les données fournies
        Pokemon bulbasaur = new Pokemon(613, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbasaur);

        Pokemon result = factory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", result.getName());
        assertEquals(613, result.getCp());
        assertEquals(64, result.getHp());
        assertEquals(4000, result.getDust());
        assertEquals(4, result.getCandy());
        assertEquals(0.56, result.getIv(), 0.01);

    }
}

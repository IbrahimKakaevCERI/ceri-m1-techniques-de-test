package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon aquali;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        
        // Création des instances de Pokémon avec les données fournies
        bulbasaur = new Pokemon(613, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        aquali = new Pokemon(2729, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        Pokemon result = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemon_InvalidId() throws PokedexException {
        when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("Invalid index"));
        pokedex.getPokemon(-1);
    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(List.of(bulbasaur, aquali));
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }
}

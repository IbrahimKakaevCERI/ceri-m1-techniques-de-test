package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RocketPokemonFactoryTest {

    private RocketPokemonFactory factory;

    @Before
    public void setUp() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        Pokemon bulbasaur = factory.createPokemon(1, 100, 100, 200, 50);
        assertNotNull(bulbasaur);
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertTrue(bulbasaur.getAttack() >= 0 && bulbasaur.getAttack() <= 1000);
        assertTrue(bulbasaur.getDefense() >= 0 && bulbasaur.getDefense() <= 1000);
        assertTrue(bulbasaur.getStamina() >= 0 && bulbasaur.getStamina() <= 1000);
        assertEquals(1, bulbasaur.getIv(), 0);
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        Pokemon missingno = factory.createPokemon(9999, 100, 100, 200, 50);
        assertNotNull(missingno);
        assertEquals("MISSINGNO", missingno.getName());
    }

    @Test
    public void testCreateAshPikachu() {
        Pokemon ashPikachu = factory.createPokemon(-1, 100, 100, 200, 50);
        assertNotNull(ashPikachu);
        assertEquals("Ash's Pikachu", ashPikachu.getName());
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
        assertEquals(0, ashPikachu.getIv(), 0);
    }

    @Test
    public void testRandomStatGeneration() {
        int stat1 = RocketPokemonFactory.generateRandomStat();
        int stat2 = RocketPokemonFactory.generateRandomStat();
        assertTrue(stat1 >= 0 && stat1 <= 1000);
        assertTrue(stat2 >= 0 && stat2 <= 1000);
        assertNotEquals(stat1, stat2);  // Vérifier que les valeurs générées sont différentes
    }

    @Test
    public void testCreatePokemonConsistency() {
        Pokemon firstCreation = factory.createPokemon(1, 100, 100, 200, 50);
        Pokemon secondCreation = factory.createPokemon(1, 100, 100, 200, 50);
        assertEquals(firstCreation.getAttack(), secondCreation.getAttack());
        assertEquals(firstCreation.getDefense(), secondCreation.getDefense());
        assertEquals(firstCreation.getStamina(), secondCreation.getStamina());
    }
}

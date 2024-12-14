package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class PokemonComparatorsTest {

    private Pokemon bulbasaur;
    private Pokemon ivysaur;
    private Pokemon venusaur;



    @Before
    public void setUp() {
        bulbasaur = new Pokemon(0, "Bulbasaur", 615, 78, 351 , 78 , 54 , 65, 23);
        ivysaur = new Pokemon(1, "Ivysaur", 613, 64,56, 98, 785 , 47, 15);
        venusaur = new Pokemon(2, "Venusaur", 613, 64, 4000, 4, 74, 36, 98);
    }

    @Test
public void testGetName() {
    assertEquals("Bulbasaur", bulbasaur.getName());
    assertEquals("Ivysaur", ivysaur.getName());
    assertEquals("Venusaur", venusaur.getName());
    System.out.println("Bulbasaur name: " + bulbasaur.getName());
    System.out.println("Ivysaur name: " + ivysaur.getName());
    System.out.println("Venusaur name: " + venusaur.getName());

}

@Test
public void testRawNameComparison() {
    System.out.println("Raw comparison result: " + bulbasaur.getName().compareTo(ivysaur.getName()));
    System.out.println("Expected result: -1");
}

    @Test
    public void testCompareByName() {
        assertEquals(-7, PokemonComparators.NAME.compare(bulbasaur, ivysaur));
        assertEquals(7, PokemonComparators.NAME.compare(ivysaur, bulbasaur));
        assertEquals(0, PokemonComparators.NAME.compare(bulbasaur, bulbasaur));
    }

    @Test
    public void testCompareByIndex() {
        assertEquals(-1, PokemonComparators.INDEX.compare(bulbasaur, ivysaur));
        assertEquals(1, PokemonComparators.INDEX.compare(ivysaur, bulbasaur));
        assertEquals(0, PokemonComparators.INDEX.compare(bulbasaur, bulbasaur));
    }

    @Test
    public void testCompareByCp() {
        assertEquals(-1, PokemonComparators.CP.compare(bulbasaur, ivysaur));
        assertEquals(1, PokemonComparators.CP.compare(ivysaur, bulbasaur));
        assertEquals(0, PokemonComparators.CP.compare(bulbasaur, bulbasaur));
    }
}
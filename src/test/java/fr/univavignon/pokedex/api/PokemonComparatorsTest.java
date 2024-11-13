import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test for PokemonComparators.java
 * 
 * @author Youkoulanda
 */
public class PokemonComparatorsTest {

	/**
	 * Test method for {@link fr.univavignon.pokedex.api.PokemonComparators#compare(fr.univavignon.pokedex.api.Pokemon, fr.univavignon.pokedex.api.Pokemon)}.
	 */
	@Test
	public void testCompare() {
		Pokemon p1 = new Pokemon(1, "Bulbizarre", 1, 1, 1, 1, 1, 1, 1, 1);
		Pokemon p2 = new Pokemon(133, "Aquali", 1, 1, 1, 1, 1, 1, 1, 1);
		
		int result = PokemonComparators.NAME.compare(p1, p2);
		assertEquals(-1, result);
		
		result = PokemonComparators.INDEX.compare(p1, p2);
		assertEquals(-132, result);
		
		result = PokemonComparators.CP.compare(p1, p2);
		assertEquals(-2728, result);
	}

}

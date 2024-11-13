import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PokemonComparatorsTest {

    @Test
    public void testCompareByName() {
        Pokemon pokemon1 = new Pokemon(25, "Pikachu", 100, 80, 60, 300, 150, 2000, 50, 0.85);
        Pokemon pokemon2 = new Pokemon(1, "Bulbasaur", 80, 60, 50, 250, 200, 1500, 25, 0.75);

        int result = PokemonComparators.NAME.compare(pokemon1, pokemon2);
        assertTrue(result > 0); // Pikachu comes after Bulbasaur alphabetically
    }

    @Test
    public void testCompareByIndex() {
        Pokemon pokemon1 = new Pokemon(25, "Pikachu", 100, 80, 60, 300, 150, 2000, 50, 0.85);
        Pokemon pokemon2 = new Pokemon(1, "Bulbasaur", 80, 60, 50, 250, 200, 1500, 25, 0.75);

        int result = PokemonComparators.INDEX.compare(pokemon1, pokemon2);
        assertTrue(result > 0); // Pikachu's index is greater than Bulbasaur's
    }

    @Test
    public void testCompareByCp() {
        Pokemon pokemon1 = new Pokemon(25, "Pikachu", 100, 80, 60, 300, 150, 2000, 50, 0.85);
        Pokemon pokemon2 = new Pokemon(1, "Bulbasaur", 80, 60, 50, 250, 200, 1500, 25, 0.75);

        int result = PokemonComparators.CP.compare(pokemon1, pokemon2);
        assertTrue(result > 0); // Pikachu has a higher CP than Bulbasaur
    }
}

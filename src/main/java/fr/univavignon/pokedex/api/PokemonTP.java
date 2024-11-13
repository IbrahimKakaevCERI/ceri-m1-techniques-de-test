import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonTP implements IPokedex, IPokemonMetadataProvider, IPokemonFactory, IPokedexFactory, IPokemonTrainerFactory {

    // Implémentation de IPokedex
    @Override
    public int size() {
        // Implémentation de la méthode size
        return 0;
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        // Implémentation de la méthode addPokemon
        return 0;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        // Implémentation de la méthode getPokemon
        return null;
    }

    @Override
    public List<Pokemon> getPokemons() {
        // Implémentation de la méthode getPokemons
        return Collections.emptyList();
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        // Implémentation de la méthode getPokemons avec un comparateur
        return Collections.emptyList();
    }

    // Implémentation de IPokemonMetadataProvider
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Implémentation de la méthode getPokemonMetadata
        return null;
    }

    // Implémentation de IPokemonFactory
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Implémentation de la méthode createPokemon
        return null;
    }

    // Implémentation de IPokedexFactory
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Implémentation de la méthode createPokedex
        return null;
    }

    // Implémentation de IPokemonTrainerFactory
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Implémentation de la méthode createTrainer
        return null;
    }
}

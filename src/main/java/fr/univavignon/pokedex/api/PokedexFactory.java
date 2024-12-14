package fr.univavignon.pokedex.api;

/**
 * Implementation of the {@link IPokedexFactory} interface to create instances of {@link IPokedex}.
 * This class provides the logic for creating a new Pokedex.
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new instance of {@link IPokedex}.
     *
     * This method initializes a Pokedex using the provided metadata provider and Pokémon factory.
     * 
     * @param metadataProvider The provider for retrieving Pokémon metadata, such as stats and names.
     * @param pokemonFactory The factory responsible for creating Pokémon objects.
     * @return A new instance of {@link IPokedex} initialized with the provided Pokémon metadata and factory.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Using the provided factories and metadata provider to create and return a new Pokedex instance.
        return new Pokedex();
    }
}


package fr.univavignon.pokedex.api;


public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static PokemonMetadataProvider instance;

    private PokemonMetadataProvider() {
    }

    public static PokemonMetadataProvider getInstance() {
        if (instance == null) {
            instance = new PokemonMetadataProvider();
        }
        return instance;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0) {
            throw new PokedexException("Index out of range");
        }
        return new PokemonMetadata(index, "Pokemon" + index, 0, 0, 0);
    }
}
package fr.univavignon.pokedex.api;



public class PokedexFactory implements IPokedexFactory {
    private static PokedexFactory instance;

    private PokedexFactory() {
    }

    public static PokedexFactory getInstance() {
        if (instance == null) {
            instance = new PokedexFactory();
        }
        return instance;
    }

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}


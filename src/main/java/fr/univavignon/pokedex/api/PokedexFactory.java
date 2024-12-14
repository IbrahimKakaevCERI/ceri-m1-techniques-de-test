package fr.univavignon.pokedex.api;


// Implémentation de la classe PokedexFactory
public class PokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex();
    }
}

package fr.univavignon.pokedex.api;

// Implémentation de la classe PokemonTrainerFactory
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex pokedex = pokedexFactory.createPokedex( metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
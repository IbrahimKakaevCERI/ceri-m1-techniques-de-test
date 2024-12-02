package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private static PokemonTrainerFactory instance;

    private PokemonTrainerFactory() {
    }

    public static PokemonTrainerFactory getInstance() {
        if (instance == null) {
            instance = new PokemonTrainerFactory();
        }
        return instance;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(PokemonMetadataProvider.getInstance(), PokemonFactory.getInstance()));
        
    }
}

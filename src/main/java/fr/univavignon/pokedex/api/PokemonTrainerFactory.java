package fr.univavignon.pokedex.api;

/**
 * Implémentation de la classe PokemonTrainerFactory.
 * 
 * Cette classe permet de créer une instance de {@link PokemonTrainer}.
 * Elle fournit un mécanisme de création de dresseurs Pokémon, incluant la génération
 * d'un Pokédex associé à ce dresseur, ainsi qu'une équipe et un nom.
 * 
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Crée une nouvelle instance de PokemonTrainer.
     * 
     * Cette méthode initialise un dresseur avec son nom, son équipe et un Pokédex
     * généré via un factory. Un PokemonMetadataProvider et un PokemonFactory
     * sont créés pour générer le Pokédex du dresseur.
     * 
     * @param name Le nom du dresseur.
     * @param team L'équipe du dresseur (un membre de l'énumération {@link Team}).
     * @param pokedexFactory La factory pour créer des instances de Pokédex.
     * @return Une nouvelle instance de {@link PokemonTrainer} configurée.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Création des objets nécessaires pour générer le Pokédex du dresseur.
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        
        // Création du Pokédex avec les objets de création appropriés.
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        
        // Création du PokemonTrainer avec le nom, l'équipe et le Pokédex.
        return new PokemonTrainer(name, team, pokedex);
    }
}

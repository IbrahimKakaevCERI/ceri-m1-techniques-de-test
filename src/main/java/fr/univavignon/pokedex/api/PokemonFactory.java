package fr.univavignon.pokedex.api;

/**
 * Implémentation de la classe {@link PokemonFactory}, qui permet de créer des instances de Pokémon.
 * Cette classe implémente l'interface {@link IPokemonFactory} et fournit une méthode pour
 * créer un Pokémon avec des caractéristiques spécifiées.
 * 
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Crée un Pokémon avec les caractéristiques spécifiées.
     * 
     * Cette méthode utilise des valeurs par défaut pour certains attributs du Pokémon (comme le nom,
     * l'attaque, la défense, et l'endurance), mais permet de définir les points de combat (CP),
     * les points de vie (HP), la quantité de poussière (dust) et de bonbons (candy) nécessaires pour
     * améliorer le Pokémon.
     * 
     * @param index L'indice du Pokémon dans le Pokédex.
     * @param cp Les points de combat (CP) du Pokémon.
     * @param hp Les points de vie (HP) du Pokémon.
     * @param dust La quantité de poussière nécessaire pour améliorer ce Pokémon.
     * @param candy La quantité de bonbons nécessaire pour améliorer ce Pokémon.
     * @return Le Pokémon créé avec les caractéristiques spécifiées.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Création d'un Pokémon avec des valeurs par défaut pour certains attributs (nom, attaque, défense, endurance).
        return new Pokemon(index, "Pikachu", 1000, 500, 100, cp, hp, dust, candy);
    }
}

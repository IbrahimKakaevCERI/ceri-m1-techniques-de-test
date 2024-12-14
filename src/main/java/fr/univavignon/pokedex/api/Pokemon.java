package fr.univavignon.pokedex.api;

/**
 * Représente un Pokémon avec des informations détaillées.
 * Cette classe étend {@link PokemonMetadata} et ajoute des informations spécifiques
 * au Pokémon telles que les points de combat (CP), les points de vie (HP), les ressources nécessaires
 * pour l'améliorer et le calcul de l'IV.
 * 
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /** Points de combat (CP) du Pokémon. **/
    private final int cp;

    /** Points de vie (HP) du Pokémon. **/
    private final int hp;

    /** Poussière nécessaire pour améliorer ce Pokémon. **/
    private final int dust;

    /** Bonbons nécessaires pour améliorer ce Pokémon. **/
    private final int candy;

    /** Pourcentage de perfection de l'IV du Pokémon. **/
    private final double iv;

    /**
     * Constructeur par défaut pour initialiser un Pokémon avec toutes les informations nécessaires.
     * Le calcul de l'IV est effectué automatiquement en prenant la moyenne des attributs de base.
     * 
     * @param index L'indice du Pokémon dans le Pokédex.
     * @param name Le nom du Pokémon.
     * @param attack Le niveau d'attaque du Pokémon.
     * @param defense Le niveau de défense du Pokémon.
     * @param stamina Le niveau d'endurance du Pokémon.
     * @param cp Les points de combat (CP) du Pokémon.
     * @param hp Les points de vie (HP) du Pokémon.
     * @param dust La poussière nécessaire pour améliorer ce Pokémon.
     * @param candy Les bonbons nécessaires pour améliorer ce Pokémon.
     */
    public Pokemon(
            final int index,
            final String name,
            final int attack,
            final int defense,
            final int stamina,
            final int cp,
            final int hp,
            final int dust,
            final int candy) {
        super(index, name, attack, defense, stamina); // Appel du constructeur parent pour initialiser les métadonnées
        this.cp = cp;
        this.hp = hp;
        this.dust = dust;
        this.candy = candy;
        // Calcul automatique de l'IV en pourcentage comme la moyenne des trois statistiques de base
        double averageValue = (double) (attack + defense + stamina) / 3.0; // Moyenne des valeurs
        this.iv = averageValue; // L'IV devient la moyenne directe des attributs
    }

    /**
     * Retourne les points de combat (CP) du Pokémon.
     * 
     * @return Les points de combat du Pokémon.
     */
    public int getCp() {
        return cp;
    }

    /**
     * Retourne les points de vie (HP) du Pokémon.
     * 
     * @return Les points de vie du Pokémon.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Retourne la quantité de poussière nécessaire pour améliorer ce Pokémon.
     * 
     * @return La poussière nécessaire pour améliorer ce Pokémon.
     */
    public int getDust() {
        return dust;
    }

    /**
     * Retourne la quantité de bonbons nécessaire pour améliorer ce Pokémon.
     * 
     * @return Les bonbons nécessaires pour améliorer ce Pokémon.
     */
    public int getCandy() {
        return candy;
    }

    /**
     * Retourne le pourcentage de perfection de l'IV du Pokémon.
     * L'IV est calculé comme la moyenne des valeurs d'attaque, de défense et d'endurance.
     * 
     * @return Le pourcentage de perfection de l'IV du Pokémon.
     */
    public double getIv() {
        return iv;
    }
}

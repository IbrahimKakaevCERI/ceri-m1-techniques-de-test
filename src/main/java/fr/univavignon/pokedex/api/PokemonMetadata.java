package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 * Cette classe représente les métadonnées d'un Pokémon, y compris son index, son nom, et ses statistiques de combat.
 * 
 * @author fv
 */
public class PokemonMetadata {

    /** Index du Pokémon. **/
    private final int index;

    /** Nom du Pokémon. **/
    private final String name;

    /** Niveau d'attaque du Pokémon. **/
    private final int attack;

    /** Niveau de défense du Pokémon. **/
    private final int defense;

    /** Niveau d'endurance (stamina) du Pokémon. **/
    private final int stamina;

    /**
     * Constructeur par défaut pour initialiser les métadonnées du Pokémon.
     * 
     * @param index L'indice unique du Pokémon dans le Pokédex.
     * @param name Le nom du Pokémon.
     * @param attack Le niveau d'attaque du Pokémon.
     * @param defense Le niveau de défense du Pokémon.
     * @param stamina Le niveau d'endurance du Pokémon.
     */
    public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
        this.index = index;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.stamina = stamina;
    }

    /**
     * Retourne l'indice du Pokémon dans le Pokédex.
     * 
     * @return L'indice du Pokémon.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Retourne le nom du Pokémon.
     * 
     * @return Le nom du Pokémon.
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le niveau d'attaque du Pokémon.
     * 
     * @return Le niveau d'attaque du Pokémon.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Retourne le niveau de défense du Pokémon.
     * 
     * @return Le niveau de défense du Pokémon.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Retourne le niveau d'endurance (stamina) du Pokémon.
     * 
     * @return Le niveau d'endurance du Pokémon.
     */
    public int getStamina() {
        return stamina;
    }

}

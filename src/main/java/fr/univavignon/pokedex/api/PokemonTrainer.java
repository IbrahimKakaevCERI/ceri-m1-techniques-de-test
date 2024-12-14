package fr.univavignon.pokedex.api;

/**
 * Classe représentant un dresseur Pokémon (trainer).
 * 
 * Cette classe contient des informations sur le nom du dresseur, son équipe et son Pokédex.
 * Elle est utilisée pour gérer un dresseur dans l'univers du Pokedex et interagir avec son équipe
 * ainsi que ses Pokémon.
 * 
 * @author fv
 */
public class PokemonTrainer {

    /** Nom du dresseur. **/
    private final String name;

    /** Équipe du dresseur. **/
    private final Team team;
    
    /** Le Pokédex du dresseur. **/
    private final IPokedex pokedex;
    
    /**
     * Constructeur par défaut.
     * 
     * Ce constructeur initialise les attributs du dresseur (nom, équipe et Pokédex).
     * 
     * @param name Le nom du dresseur.
     * @param team L'équipe du dresseur (une valeur de l'énumération {@link Team}).
     * @param pokedex Le Pokédex associé au dresseur (implémentation de {@link IPokedex}).
     */
    public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
        this.name = name;
        this.team = team;
        this.pokedex = pokedex;
    }
    

    /**
     * Getter pour le nom du dresseur.
     * 
     * @return Le nom du dresseur.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter pour l'équipe du dresseur.
     * 
     * @return L'équipe du dresseur.
     */

    public Team getTeam() {
        return team;
    }
    
    /**
     * Getter pour le Pokédex du dresseur.
     * 
     * @return Le Pokédex du dresseur.
     */
    
    public IPokedex getPokedex() {
        return pokedex;
    }
    
}

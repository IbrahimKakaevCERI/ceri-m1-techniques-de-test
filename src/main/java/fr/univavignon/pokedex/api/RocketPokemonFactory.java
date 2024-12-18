package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;

/**
 * Factory class for creating Pokémon instances with random stats.
 * 
 * This factory creates Pokémon instances with random stats, except for Ash's Pikachu
 * which has fixed stats:
 * - Attack, Defense, and Stamina are random values between 0 and 1000.
 * - IV (Individual Value) is 0 for Ash's Pikachu and 1 for all other Pokémon.
 * 
 * This class implements the {@link IPokemonFactory} interface and provides the logic to create
 * Pokémon with various stats such as CP, HP, dust, candy, and IV.
 * 
 * @see Pokemon
 */
public class RocketPokemonFactory implements IPokemonFactory {

    /** A map of Pokémon index to Pokémon name */
    private static Map<Integer, String> index2name;

    static {
        /**
         * Initializes the map of Pokémon index to Pokémon name.
         * This map contains some predefined Pokémon like Ash's Pikachu and MISSINGNO.
         * The map can be extended to include more Pokémon in the future.
         */
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Add more Pokémon names to the map
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    /**
     * Generates a random stat value between 0 and 1000.
     * The generated value is the sum of random values (0 or 1) averaged over 1,000,000 iterations.
     * 
     * @return a random stat value between 0 and 1000
     */
    static int generateRandomStat() {
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    /**
     * Creates a new Pokémon instance with the specified index and stats.
     * 
     * @param index the index of the Pokémon to create
     * @param cp the CP (combat power) of the Pokémon
     * @param hp the HP (hit points) of the Pokémon
     * @param dust the amount of Stardust for the Pokémon
     * @param candy the amount of candy for the Pokémon
     * 
     * @return a new {@link Pokemon} object with the specified index and generated stats
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        // Get the name of the Pokémon based on the index
        if (!index2name.containsKey(index)) {
            name = index2name.get(0); // Default to MISSINGNO if the index is not in the map
        } else {
            name = index2name.get(index); // Get the name for the given index
        }

        int attack;
        int defense;
        int stamina;
        double iv;

        // Special case for Ash's Pikachu (index < 0)
        if (index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0; // Ash's Pikachu has an IV of 0
        } else {
            // Generate random stats for other Pokémon
            attack = RocketPokemonFactory.generateRandomStat();
            defense = RocketPokemonFactory.generateRandomStat();
            stamina = RocketPokemonFactory.generateRandomStat();
            iv = 1; // Other Pokémon have an IV of 1
        }

        // Return the newly created Pokémon
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }
}

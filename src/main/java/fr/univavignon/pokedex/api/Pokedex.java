package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the Pokedex class.
 * This class manages a collection of Pokémon.
 */
public class Pokedex implements IPokedex, IPokemonMetadataProvider, IPokemonFactory {
    /**
     * The list of Pokémon in the Pokedex.
     */
    private final List<Pokemon> pokemons;

    /**
     * Constructor for the Pokedex class.
     * Initializes a new list of Pokémon.
     */
    public Pokedex() {
        this.pokemons = new ArrayList<>();
    }

    /**
     * Creates a Pokémon with the specified characteristics.
     *
     * @param index The index of the Pokémon.
     * @param cp The combat points of the Pokémon.
     * @param hp The hit points of the Pokémon.
     * @param dust The amount of stardust required to upgrade the Pokémon.
     * @param candy The amount of candy required to upgrade the Pokémon.
     * @return The created Pokémon.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Implementation of the method
        // This is a placeholder implementation, you should replace it with the actual logic
        return new Pokemon(index, "Pikachu", 1000, 500, 100, cp, hp, dust, candy);
    }

    /**
     * Retrieves the metadata of a Pokémon by its index.
     *
     * @param index The index of the Pokémon.
     * @return The metadata of the Pokémon.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) {
        // Implementation of the method
        // This is a placeholder implementation, you should replace it with the actual logic
        return new PokemonMetadata(index, "Bulbasaur", 0, 0, 0);
    }

    /**
     * Retrieves the metadata of a Pokémon by its name.
     * This method is not implemented.
     * @return The size of the Pokémon.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds a Pokémon to the Pokedex.
     *
     * @param pokemon The Pokémon to add.
     * @return The index of the Pokémon in the Pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }


    /**
     * Retrieves a Pokémon from the Pokedex by its index.
     *
     * @param index The index of the Pokémon.
     * @return The Pokémon at the specified index.
     */
    @Override
    public Pokemon getPokemon(int index) {
        if (index < 0 || index >= pokemons.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return pokemons.get(index);
    }

    /**
     * Retrieves all the Pokémon in the Pokedex.
     *
     * @return A list of all the Pokémon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

    /**
     * Retrieves all the Pokémon in the Pokedex, sorted by the specified order.
     *
     * @param order The order in which to sort the Pokémon.
     * @return A list of all the Pokémon in the Pokedex, sorted by the specified order.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        Collections.sort(sortedList, order);
        return sortedList;
    }
}
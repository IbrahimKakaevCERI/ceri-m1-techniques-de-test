package fr.univavignon.pokedex.api;
// Implémentation de la classe Pokedex
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex, IPokemonMetadataProvider, IPokemonFactory {
    private List<Pokemon> pokemons;

    public Pokedex() {
        this.pokemons = new ArrayList<>();
    
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Implementation of the method
        // This is a placeholder implementation, you should replace it with the actual logic
        return new Pokemon(index, "Pikachu", 1000, 500, 100, cp, hp, dust, candy);
    }
    
    @Override
    public PokemonMetadata getPokemonMetadata(int index) {
            // Implementation of the method
            // This is a placeholder implementation, you should replace it with the actual logic
        return new PokemonMetadata(index, "Bulbizare", 0, 0, 0);
    }
    

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int index) {
        if (index < 0 || index >= pokemons.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return pokemons.get(index);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        Collections.sort(sortedList, order);
        return sortedList;
    }
}
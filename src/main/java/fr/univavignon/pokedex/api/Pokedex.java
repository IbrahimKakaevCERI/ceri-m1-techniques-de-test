package fr.univavignon.pokedex.api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Pokedex implements IPokedex{
    private final List<Pokemon> pokemons;
    private  IPokemonMetadataProvider metadataProvider;
    private  IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        pokemons = new ArrayList<>();
    }
    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Return the index of the added Pokemon
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id >= 0 && id < pokemons.size()) {
            return pokemons.get(id);
        } else {
            throw new PokedexException("Index out of range");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        Collections.sort(sortedPokemons, order);
        return sortedPokemons;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
    
    
}
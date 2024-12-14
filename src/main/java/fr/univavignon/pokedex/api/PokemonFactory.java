package fr.univavignon.pokedex.api;
// Implémentation de la classe PokemonFactory
public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Assuming the other parameters are calculated or default values
        return new Pokemon(index, "Pikachu", 1000, 500,100, cp, hp, dust, candy);
    }
}
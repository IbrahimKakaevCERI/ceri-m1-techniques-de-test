
package fr.univavignon.pokedex.api;


public class PokemonFactory implements IPokemonFactory {
    private static PokemonFactory instance;

    private PokemonFactory() {
    }

    public static PokemonFactory getInstance() {
        if (instance == null) {
            instance = new PokemonFactory();
        }
        return instance;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new Pokemon(index, "Pokemon" + index, cp, hp, dust, candy, 0, 0, 0 , 0);
    }
}

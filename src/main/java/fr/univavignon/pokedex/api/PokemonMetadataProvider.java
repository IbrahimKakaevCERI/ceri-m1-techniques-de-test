package fr.univavignon.pokedex.api;
// Implémentation de la classe PokemonMetadataProvider
import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();
        // Initialiser les métadonnées des Pokémon (exemple)
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        metadataMap.put(1, new PokemonMetadata(1, "Ivysaur", 156, 158, 120));
        metadataMap.put(2, new PokemonMetadata(2, "Venusaur", 198, 200, 160));
        // Ajouter d'autres Pokémon ici
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Pokemon metadata not found for index: " + index);
        }
        return metadataMap.get(index);
    }
}
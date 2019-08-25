package pl.vanthus.pokemonsAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vanthus.pokemonsAPI.Model.Pokemon;
import pl.vanthus.pokemonsAPI.Repository.PokemonRepository;

import java.util.List;

@Service
public class PokemonService {

    PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAll(){
        return pokemonRepository.findAll();
    }

    public List<Pokemon> getLegendaries() {
        return pokemonRepository.findByIsLegendary(true);
    }
}

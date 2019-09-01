package pl.vanthus.pokemonsAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.vanthus.pokemonsAPI.Model.Pokemon;
import pl.vanthus.pokemonsAPI.Model.Type;
import pl.vanthus.pokemonsAPI.Repository.PokemonRepository;
import pl.vanthus.pokemonsAPI.Repository.TypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    PokemonRepository pokemonRepository;
    TypeRepository typeRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, TypeRepository typeRepository) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
    }

    public Pokemon getPokemonById(Long id){
        return pokemonRepository.getOne(id);
    }

    public List<Pokemon> getAll(){
        return pokemonRepository.findAll();
    }

    public List<Pokemon> getByLegendaries(boolean isLegendary) {
        return pokemonRepository.findByIsLegendary(isLegendary);
    }

    public List<Pokemon> getPokemonByType(String typeName){

        Type type = typeRepository.findByName(typeName);

        return  pokemonRepository.findAll().stream()
                .filter(p -> p.getTypes().contains(type))
                .collect(Collectors.toList());
    }


}

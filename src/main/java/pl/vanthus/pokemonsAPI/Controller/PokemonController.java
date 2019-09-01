package pl.vanthus.pokemonsAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.vanthus.pokemonsAPI.Model.Pokemon;
import pl.vanthus.pokemonsAPI.Service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("")
    public Pokemon getPokemonById(@RequestParam Long id){
        return pokemonService.getPokemonById(id);
    }

    @RequestMapping("/all")
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @RequestMapping("/legendaries")
    public List<Pokemon> getLegendaries(@RequestParam boolean isLegendary){
        return pokemonService.getByLegendaries(isLegendary);
    }

    @RequestMapping("/type")
    public List<Pokemon> getByType(@RequestParam String name){
        System.out.println(name);
        return pokemonService.getPokemonByType(name);
    }


}

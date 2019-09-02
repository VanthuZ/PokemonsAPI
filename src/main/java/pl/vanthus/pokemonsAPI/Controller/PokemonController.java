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

    @RequestMapping(value = "", params = "id")
    public Pokemon getPokemonById(@RequestParam Long id){
            return pokemonService.getPokemonById(id);
    }

    @RequestMapping(value = "", params = "name")
    public List<Pokemon> getPokemonByName(@RequestParam String name) {
        return pokemonService.getPokemonByName(name);
    }

    @RequestMapping(value = "", params = "number")
    public Pokemon getPokemonByNumber(@RequestParam int number) {
        return pokemonService.getPokemonByNumber(number);
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
        return pokemonService.getPokemonByType(name);
    }

    @RequestMapping("/generation")
    public List<Pokemon> getByGeneration(@RequestParam int number){
        return pokemonService.getByGeneration(number);
    }
}

package pl.vanthus.pokemonsAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.vanthus.pokemonsAPI.Model.Pokemon;
import pl.vanthus.pokemonsAPI.Repository.PokemonRepository;
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

    @RequestMapping("/all")
    public List<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @RequestMapping("/legendaries")
    public List<Pokemon> getLegendaries(){
        return pokemonService.getLegendaries();
    }


}

package pl.vanthus.pokemonsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.vanthus.pokemonsAPI.Model.Pokemon;

import java.util.List;


@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

     List<Pokemon> findByIsLegendary(boolean isLegendary);
     List<Pokemon> findByGeneration(int generation);
     List<Pokemon> findByName(String name);
     Pokemon findByNumber(int number);
}

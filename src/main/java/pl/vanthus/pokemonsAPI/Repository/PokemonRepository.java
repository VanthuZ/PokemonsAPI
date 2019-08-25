package pl.vanthus.pokemonsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.vanthus.pokemonsAPI.Model.Pokemon;

import java.util.List;


@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    public List<Pokemon> findByIsLegendary(boolean isLegendary);
}

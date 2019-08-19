package pl.vanthus.pokemonsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.vanthus.pokemonsAPI.Model.Pokemon;


@Repository
public interface PokemonRepository extends JpaRepository<Long, Pokemon> {
}

package pl.vanthus.pokemonsAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vanthus.pokemonsAPI.Model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    public Type findByName(String name);
}

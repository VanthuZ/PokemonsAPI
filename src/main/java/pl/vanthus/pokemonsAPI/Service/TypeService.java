package pl.vanthus.pokemonsAPI.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vanthus.pokemonsAPI.Model.Type;
import pl.vanthus.pokemonsAPI.Repository.TypeRepository;

@Service
public class TypeService {

    TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getTypeByName(String name){
       return typeRepository.findByName(name);
    }
}

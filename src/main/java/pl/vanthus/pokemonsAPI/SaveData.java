package pl.vanthus.pokemonsAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import pl.vanthus.pokemonsAPI.Model.Pokemon;
import pl.vanthus.pokemonsAPI.Model.Type;
import pl.vanthus.pokemonsAPI.Repository.PokemonRepository;
import pl.vanthus.pokemonsAPI.Repository.TypeRepository;
import pl.vanthus.pokemonsAPI.Service.TypeService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class SaveData {

    PokemonRepository pokemonRepository;
    TypeRepository typeRepository;
    TypeService typeService;

    @Autowired
    public SaveData(PokemonRepository pokemonRepository, TypeRepository typeRepository, TypeService typeService) {
        this.pokemonRepository = pokemonRepository;
        this.typeRepository = typeRepository;
        this.typeService = typeService;
    }

    public void parseAndSaveData(){

        String csvFile = "C:\\Users\\Vanthus\\dev\\pokemonAPI\\src\\main\\resources\\Pokemon.csv";
        String line = "";
        Pokemon pokemon;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            //just for skipping first line in csv file
            String headerLine = bufferedReader.readLine();

           Long idCounter = 1L;
            while((line = bufferedReader.readLine()) !=null) {

                String[] pokemonData = line.split(",");

                pokemon = new Pokemon();

                pokemon.setId(idCounter);
                pokemon.setNumber(Integer.parseInt(pokemonData[0]));
                pokemon.setName(pokemonData[1]);
                pokemon.setTypes(setType(pokemonData[2], pokemonData[3]));
                pokemon.setTotal(Integer.parseInt(pokemonData[4]));
                pokemon.setHealthPoints(Integer.parseInt(pokemonData[5]));
                pokemon.setAttack(Integer.parseInt(pokemonData[6]));
                pokemon.setDefense(Integer.parseInt(pokemonData[7]));
                pokemon.setSpecialAttack(Integer.parseInt(pokemonData[8]));
                pokemon.setSpecialDefence(Integer.parseInt(pokemonData[9]));
                pokemon.setSpeed(Integer.parseInt(pokemonData[10]));
                pokemon.setGeneration(Integer.parseInt(pokemonData[11]));
                pokemon.setLegendary(Boolean.parseBoolean(pokemonData[12]));

                pokemonRepository.save(pokemon);

                idCounter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public List<Type> setType(String type1, String type2){

       List<Type> typeList = new ArrayList<>();
       typeList.add(typeService.getTypeByName(type1));
       typeList.add(typeService.getTypeByName(type2));

       return typeList;
   }


    public HashSet<String> parseType(String csvFile, String line){

        HashSet<String> typeList = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            //just for skipping first line in csv file
            String headerLine = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) !=null){

                String[] lineArray = line.split(",");

                typeList.add(lineArray[2]);
                typeList.add(lineArray[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return typeList;
    }

    public void saveType(HashSet<String> typeList){

        Type typeObj;
        Long idTypeCounter = 1L;
        for (String type : typeList){

            if(!type.isEmpty()){
                typeObj = new Type(idTypeCounter, type);
                typeRepository.save(typeObj);

                idTypeCounter++;
            }
        }
    }
}

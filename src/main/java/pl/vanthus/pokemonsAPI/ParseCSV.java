package pl.vanthus.pokemonsAPI;

import pl.vanthus.pokemonsAPI.Model.Pokemon;

import java.io.*;


public class ParseCSV
{

    public static void main(String[] args) {
        parseAndSaveData();
    }

    public static void parseAndSaveData(){
        String csvFile = "..\\pokemonsAPI\\src\\main\\resources\\Pokemon.csv";
        String line = "";
        Pokemon pokemon;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            //just for skipping first line in csv file
            String headerLine = bufferedReader.readLine();

            while((line = bufferedReader.readLine()) !=null){

                String[] pokemonData = line.split(",");

                pokemon = new Pokemon();

                pokemon.setNumber(Integer.parseInt(pokemonData[0]));
                pokemon.setName(pokemonData[1]);
                String[] types = {pokemonData[2], pokemonData[3]};
                pokemon.setTypes(types);
                pokemon.setTotal(Integer.parseInt(pokemonData[4]));
                pokemon.setHealthPoints(Integer.parseInt(pokemonData[5]));
                pokemon.setAttack(Integer.parseInt(pokemonData[6]));
                pokemon.setDefense(Integer.parseInt(pokemonData[7]));
                pokemon.setSpecialAttack(Integer.parseInt(pokemonData[8]));
                pokemon.setSpecialDefence(Integer.parseInt(pokemonData[9]));
                pokemon.setSpeed(Integer.parseInt(pokemonData[10]));
                pokemon.setGeneration(Integer.parseInt(pokemonData[11]));
                pokemon.setLegendary(Boolean.parseBoolean(pokemonData[12]));
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

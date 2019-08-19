package pl.vanthus.pokemonsAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private String name;
    private String[] types;
    private int total;
    private int healthPoints;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefence;
    private int speed;
    private int generation;
    private boolean isLegendary;



}

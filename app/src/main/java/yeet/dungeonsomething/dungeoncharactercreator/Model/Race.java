package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Race implements Serializable {
    String name;
    int speed;
    int[] ability_bonuses;
    String alignment;
    String age;
    String size;
    String size_description;
    APIResource[] starting_proficiencies;
    APIResource[] languages;
    String language_desc;
    APIResource[] traits;
    APIResource subraces;



}

package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable {
    String name;
    Statistics stats;
    Race race;
    Class myclass;
    int level;
    int experience;
    int healthPoints;
    int speed;
    int armorClass;
    ArrayList<Proficiency> proficiencies;
    ArrayList<Note> notes;
    ArrayList<Item> inventory;
    ArrayList<Spell> knownspells;

    public String getName() {
        return name;
    }
}

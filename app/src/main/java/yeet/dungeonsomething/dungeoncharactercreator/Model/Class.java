package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Class implements Serializable {
    String name;
    int hit_die;//the die type
    ProficiencyChoice[] proficiency_choices;
    APIResource[] proficiencies;
    APIResource[] saving_throws;
    APIResource class_levels;
    APIResource[] subclasses;
    APIResource starting_equipment;
    APIResource spellcasting;
    String url;



}

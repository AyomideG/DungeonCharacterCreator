package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Class implements Serializable {
    private String name;
    private int hit_die;//the die type
    private ProficiencyChoice[] proficiency_choices;
    private APIResource[] proficiencies;
    private APIResource[] saving_throws;
    private APIResource class_levels;
    private APIResource[] subclasses;
    private APIResource starting_equipment;
    private APIResource spellcasting;
    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHit_die() {
        return hit_die;
    }

    public void setHit_die(int hit_die) {
        this.hit_die = hit_die;
    }

    public ProficiencyChoice[] getProficiency_choices() {
        return proficiency_choices;
    }

    public void setProficiency_choices(ProficiencyChoice[] proficiency_choices) {
        this.proficiency_choices = proficiency_choices;
    }

    public APIResource[] getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(APIResource[] proficiencies) {
        this.proficiencies = proficiencies;
    }

    public APIResource[] getSaving_throws() {
        return saving_throws;
    }

    public void setSaving_throws(APIResource[] saving_throws) {
        this.saving_throws = saving_throws;
    }

    public APIResource getClass_levels() {
        return class_levels;
    }

    public void setClass_levels(APIResource class_levels) {
        this.class_levels = class_levels;
    }

    public APIResource[] getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(APIResource[] subclasses) {
        this.subclasses = subclasses;
    }

    public APIResource getStarting_equipment() {
        return starting_equipment;
    }

    public void setStarting_equipment(APIResource starting_equipment) {
        this.starting_equipment = starting_equipment;
    }

    public APIResource getSpellcasting() {
        return spellcasting;
    }

    public void setSpellcasting(APIResource spellcasting) {
        this.spellcasting = spellcasting;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

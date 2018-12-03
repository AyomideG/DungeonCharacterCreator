package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Race implements Serializable {
    private String name;
    private int speed;
    private int[] ability_bonuses;
    private String alignment;
    private String age;
    private String size;
    private String size_description;
    private APIResource[] starting_proficiencies;
    private APIResource[] languages;
    private String language_desc;
    private APIResource[] traits;
    private APIResource[] subraces;
    private String url;


    public String getFullDescription(){
        String ret = new String();
        ret+= getAlignment()+"\n";
        ret+= getSize_description()+"\n";
        ret+= getLanguage_desc()+"\n";
        return ret;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int[] getAbility_bonuses() {
        return ability_bonuses;
    }

    public void setAbility_bonuses(int[] ability_bonuses) {
        this.ability_bonuses = ability_bonuses;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize_description() {
        return size_description;
    }

    public void setSize_description(String size_description) {
        this.size_description = size_description;
    }

    public APIResource[] getStarting_proficiencies() {
        return starting_proficiencies;
    }

    public void setStarting_proficiencies(APIResource[] starting_proficiencies) {
        this.starting_proficiencies = starting_proficiencies;
    }

    public APIResource[] getLanguages() {
        return languages;
    }

    public void setLanguages(APIResource[] languages) {
        this.languages = languages;
    }

    public String getLanguage_desc() {
        return language_desc;
    }

    public void setLanguage_desc(String language_desc) {
        this.language_desc = language_desc;
    }

    public APIResource[] getTraits() {
        return traits;
    }

    public void setTraits(APIResource[] traits) {
        this.traits = traits;
    }

    public APIResource[] getSubraces() {
        return subraces;
    }

    public void setSubraces(APIResource[] subraces) {
        this.subraces = subraces;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

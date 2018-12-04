package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerInfo implements Serializable {

    String backGround;
    String alignment;
    ArrayList<Trait> traits;
    ArrayList<Feature> features;
    ArrayList<String> ideals;
    ArrayList<String> bonds;
    ArrayList<String> flaws;
    ArrayList<Language> languages;

    public PlayerInfo(){
        traits = new ArrayList<>();
        features = new ArrayList<>();
        ideals = new ArrayList<>();
        bonds = new ArrayList<>();
        flaws = new ArrayList<>();
        languages = new ArrayList<>();

    }

    public String getBackGround() {
        return backGround;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public ArrayList<Trait> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<Trait> traits) {
        this.traits = traits;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }

    public ArrayList<String> getIdeals() {
        return ideals;
    }

    public void setIdeals(ArrayList<String> ideals) {
        this.ideals = ideals;
    }

    public ArrayList<String> getBonds() {
        return bonds;
    }

    public void setBonds(ArrayList<String> bonds) {
        this.bonds = bonds;
    }

    public ArrayList<String> getFlaws() {
        return flaws;
    }

    public void setFlaws(ArrayList<String> flaws) {
        this.flaws = flaws;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }



}

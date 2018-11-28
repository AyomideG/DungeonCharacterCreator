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

}

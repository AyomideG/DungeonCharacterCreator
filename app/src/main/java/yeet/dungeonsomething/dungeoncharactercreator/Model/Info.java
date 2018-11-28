package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Info implements Serializable {
    String backGround;
    String alignment;
    ArrayList<APIResource> traits;
    ArrayList<Feature> features;
    ArrayList<String> ideals;
    ArrayList<String> bonds;
    ArrayList<String> flaws;
    ArrayList<Language> languages;

}

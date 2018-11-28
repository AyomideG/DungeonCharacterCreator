package yeet.dungeonsomething.dungeoncharactercreator;

import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import yeet.dungeonsomething.dungeoncharactercreator.Model.AbilityScore;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Class;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Equipment;
import yeet.dungeonsomething.dungeoncharactercreator.Model.EquipmentCategory;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Feature;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Info;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Language;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Proficiency;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Race;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Skill;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Spell;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Spellcasting;
import yeet.dungeonsomething.dungeoncharactercreator.Model.StartingEquipment;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Trait;

public class APIDataManager {
    private static APIDataManager instance;
    private Gson gson;
    private AssetManager assetManager;
    private APIDataManager(AssetManager assets){
        gson = new Gson();
        assetManager = assets;

    }
    public static APIDataManager getInstance(AssetManager assets){
        if(instance == null)
            instance = new APIDataManager(assets);
        return instance;
    }

    public Class[] getClasses(){
        String json = loadJSON("5eAPIData/5e-SRD-Classes.json");
        return gson.fromJson(json,Class[].class);
    }
    public Race[] getRaces(){
        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
        return gson.fromJson(json,Race[].class);
    }
    public AbilityScore[] getAbilityScores(){
        String json = loadJSON("5eAPIData/5e-SRD-Ability-Scores.json");
        return gson.fromJson(json,AbilityScore[].class);
    }
    //skipped
//    public Condition[] getRaces(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    public Info[] getDamageTypes(){
        String json = loadJSON("5eAPIData/5e-SRD-Damage-Types.json");
        return gson.fromJson(json,Info[].class);
    }
    public Equipment[] getEquipments(){
        String json = loadJSON("5eAPIData/5e-SRD-Equipment.json");
        return gson.fromJson(json,Equipment[].class);
    }
    public EquipmentCategory[] getEquipmentCategories(){
        String json = loadJSON("5eAPIData/5e-SRD-Equipment-Categories.json");
        return gson.fromJson(json,EquipmentCategory[].class);
    }
    public Feature[] getFeatures(){
        String json = loadJSON("5eAPIData/5e-SRD-Features.json");
        return gson.fromJson(json,Feature[].class);
    }
    public Language[] getLanguages(){
        String json = loadJSON("5eAPIData/5e-SRD-Languages.json");
        return gson.fromJson(json,Language[].class);
    }
    //skipped levels
//    public Level[] getLevels(){
//        String json = loadJSON("5eAPIData/5e-SRD-Levels.json");
//        return gson.fromJson(json,Level[].class);
//    }
    //skipped magic schools
//    public MagicSchool[] getMagicSchools(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    //skipped monsters
//    public Race[] getRaces(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    public Proficiency[] getProficiencies(){
        String json = loadJSON("5eAPIData/5e-SRD-Proficiencies.json");
        return gson.fromJson(json,Proficiency[].class);
    }
    public Skill[] getSkills(){
        String json = loadJSON("5eAPIData/5e-SRD-Skills.json");
        return gson.fromJson(json,Skill[].class);
    }
    public Spellcasting[] getSpellcasting(){
        String json = loadJSON("5eAPIData/5e-SRD-Spellcasting.json");
        return gson.fromJson(json,Spellcasting[].class);
    }
    public Spell[] getSpells(){
        String json = loadJSON("5eAPIData/5e-SRD-Spells.json");
        return gson.fromJson(json,Spell[].class);
    }
    public StartingEquipment[] getStartingEquipment(){
        String json = loadJSON("5eAPIData/5e-SRD-StartingEquipment.json");
        return gson.fromJson(json,StartingEquipment[].class);
    }
    //skip subclasses
//    public Race[] getRaces(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    //skip subraces
//    public Race[] getRaces(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    //skip test, wtf is it?
//    public Race[] getRaces(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }
    public Trait[] getTraits(){
        String json = loadJSON("5eAPIData/5e-SRD-Traits.json");
        return gson.fromJson(json,Trait[].class);
    }
    //skip weapon properties
//    public WeaponProperty[] getWeaponProperties(){
//        String json = loadJSON("5eAPIData/5e-SRD-Races.json");
//        return gson.fromJson(json,Race[].class);
//    }


    private String loadJSON(String filename){
        try{
            InputStream inputStream = assetManager.open(filename);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }



}

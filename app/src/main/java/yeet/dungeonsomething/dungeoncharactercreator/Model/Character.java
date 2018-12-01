package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable {
    private String name;
    private Statistics stats;
    private Race race;
    private Class myclass;
    private int level;
    private int experience;
    private int healthPoints;
    private int speed;
    private int armorClass;
    private ArrayList<Proficiency> proficiencies;
    private ArrayList<Note> notes;
    private ArrayList<Item> inventory;
    private ArrayList<Spell> knownspells;

    public Character(){
        name = "No one";
        stats = new Statistics();
        race = new Race();
        myclass = new Class();
        level = 0;
        experience = 0;
        healthPoints = 0;
        speed = 0;
        armorClass = 0;
        proficiencies = new ArrayList<>();
        notes = new ArrayList<>();
        inventory = new ArrayList<>();
        knownspells = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Statistics getStats() {
        return stats;
    }

    public void setStats(Statistics stats) {
        this.stats = stats;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
        this.speed = race.getSpeed();
    }

    public Class getMyclass() {
        return myclass;
    }

    public void setMyclass(Class myclass) {
        this.myclass = myclass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public ArrayList<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(ArrayList<Proficiency> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Spell> getKnownspells() {
        return knownspells;
    }

    public void setKnownspells(ArrayList<Spell> knownspells) {
        this.knownspells = knownspells;
    }
}

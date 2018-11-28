package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    String type;
    String subtype;
    Cost cost;
    Damage damage;
    int weight;
    String[] properties;
}

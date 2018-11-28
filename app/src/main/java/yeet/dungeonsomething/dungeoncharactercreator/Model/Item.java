package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    int quantity;
    String type;
    String subtype;
    Cost cost;
    Damage damage;
    double weight;
    APIResource[] properties;
    String url;
}

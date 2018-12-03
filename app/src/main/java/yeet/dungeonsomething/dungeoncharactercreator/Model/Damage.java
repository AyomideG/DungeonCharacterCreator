package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Damage implements Serializable {
    public int getDice_count() {
        return dice_count;
    }

    public void setDice_count(int dice_count) {
        this.dice_count = dice_count;
    }

    public int getDice_value() {
        return dice_value;
    }

    public void setDice_value(int dice_value) {
        this.dice_value = dice_value;
    }

    int dice_count;
    int dice_value;
    APIResource damage_type;
}

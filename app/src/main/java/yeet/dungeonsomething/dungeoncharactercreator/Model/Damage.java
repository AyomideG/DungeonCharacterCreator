package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.Random;

public class Damage implements Serializable {

    private int dice_count;
    private int dice_value;
    private APIResource damage_type;

    public Damage(){}

    public Damage(int n, int t){
        dice_value = t;
        dice_count = n;
    }

    public int getRoll(){
        int result = 0;
        Random r = new Random();
        for (int i = 0; i < getDice_count(); i++) {
            result += r.nextInt() % getDice_value();
        }
        return result;
    }

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

    public APIResource getDamage_type() {
        return damage_type;
    }

    public void setDamage_type(APIResource damage_type) {
        this.damage_type = damage_type;
    }
}

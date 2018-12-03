package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;
import java.util.Random;

public class Damage implements Serializable {
    int dice_count;
    int dice_value;
    APIResource damage_type;

    public int getRoll(){
        int result = 0;
        Random r = new Random();
        for (int i = 0; i < dice_count; i++) {
            result += r.nextInt() % dice_value;
        }
        return result;
    }
}

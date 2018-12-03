package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Cost implements Serializable {
    int quantity;
    String unit;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

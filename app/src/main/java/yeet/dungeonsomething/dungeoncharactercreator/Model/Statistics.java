package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Statistics implements Serializable {
    //conforming to the api
    public static final int STR_INDEX = 0;
    public static final int DEX_INDEX = 1;
    public static final int CON_INDEX = 2;
    public static final int INT_INDEX = 3;
    public static final int WIS_INDEX = 4;
    public static final int CHR_INDEX = 5;

    private int[] abilityValues;

    public Statistics(){
        abilityValues = new int[6];
    }

    /**
     * Get the calculated modifier value of an attribute
     * @param value
     * @return
     */
    public int getModifier(int value){
        return (value - 10) /2;
    }

    public int getSTR(){
        return abilityValues[STR_INDEX];
    }
    public int getDEX(){
        return abilityValues[DEX_INDEX];
    }
    public int getCON(){
        return abilityValues[CON_INDEX];
    }
    public int getWIS(){
        return abilityValues[WIS_INDEX];
    }
    public int getINT(){
        return abilityValues[INT_INDEX];
    }
    public int getCHR(){
        return abilityValues[CHR_INDEX];
    }
}

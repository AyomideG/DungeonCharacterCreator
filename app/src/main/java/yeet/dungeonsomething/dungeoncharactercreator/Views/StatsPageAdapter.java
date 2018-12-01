package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;

public class StatsPageAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    //constructor

    public StatsPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    //TDB THIS SHOULD READ FROM THE CHARACTER DATA
    //define switching activities, cases are position of tabs left to right, return teh activity you want to load for that position
    @Override
    public Fragment getItem(int position) {
        Fragment f =  new CharStatsFragment();
        Character character = CharacterManager.getInstance(null).getCharacter();
        Bundle data = new Bundle();
        switch(position) {
            case 0:
                data.putString("data", "Strength");
                data.putInt("value", character.getStats().getSTR());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getSTR()));
                data.putInt("save", character.getStats().getSTR());
                break;
            case 1:
                data.putString("data", "Dexterity");
                data.putInt("value", character.getStats().getDEX());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getDEX()));
                data.putInt("save", character.getStats().getDEX());
                break;
            case 2:
                data.putString("data", "Constitution");
                data.putInt("value", character.getStats().getCON());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getCON()));
                data.putInt("save", character.getStats().getCON());
                break;
            case 3:
                data.putString("data", "Intelligence");
                data.putInt("value", character.getStats().getINT());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getINT()));
                data.putInt("save", character.getStats().getINT());
                break;
            case 4:
                data.putString("data", "Wisdom");
                data.putInt("value", character.getStats().getWIS());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getWIS()));
                data.putInt("save", character.getStats().getWIS());
                break;
            case 5:
                data.putString("data", "Charisma");
                data.putInt("value", character.getStats().getCHR());
                data.putInt("mod", character.getStats().getModifier(character.getStats().getCHR()));
                data.putInt("save", character.getStats().getCHR());
                break;


        }
        f.setArguments(data);
        return f;
    }

    //number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

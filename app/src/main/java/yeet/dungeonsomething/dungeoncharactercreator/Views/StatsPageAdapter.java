package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
        Bundle data = new Bundle();
        switch(position) {
            case 0:
                data.putString("data", "Strength");
                break;
            case 1:
                data.putString("data", "Dexterity");
                break;
            case 2:
                data.putString("data", "Constitution");
                break;
            case 3:
                data.putString("data", "Intelligence");
                break;
            case 4:
                data.putString("data", "Wisdom");
                break;
            case 5:
                data.putString("data", "Charisma");
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

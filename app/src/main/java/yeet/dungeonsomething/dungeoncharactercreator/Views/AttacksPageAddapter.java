package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AttacksPageAddapter extends FragmentStatePagerAdapter {
    //the number of tabs

    int mNumOfTabs;

    //constructor

    public AttacksPageAddapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    //define switching activities, cases are position of tabs left to right, return teh activity you want to load for that position
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new PhysicalAttacksFragment();
            case 1:
                return new SpellcastingAttacksFragment();
            default:
                return null;
        }
    }

    //number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

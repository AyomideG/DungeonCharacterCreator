package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    //Page Adapter -- this connects the tabs to the fragments
    //Defines what fragment is loaded when a tab is clicked -- synchronize tab order between this and wizardtabsactivity

    //the number of tabs

    int mNumOfTabs;

    //constructor

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    //define switching activities, cases are position of tabs left to right, return teh activity you want to load for that position
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new RaceFragment();
            case 1:
                return new ClassFragment();
            case 2:
                return new LevelFragment();
            case 3:
                return new SkillsProficienciesFragment();
            case 4:
                return new TraitsFragment();
            case 5:
                return new BackgroundFragment();
            case 6:
                return new InventoryFragment();
            default:
                return new RaceFragment();
        }
    }

    //number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

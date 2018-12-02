package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class NotePageAdapter extends FragmentStatePagerAdapter {

    //constructor

    public NotePageAdapter(FragmentManager fm) {
        super(fm);
    }


    //define switching activities, cases are position of tabs left to right, return teh activity you want to load for that position
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NoteFragment();
            default: return null;
        }
    }

    //number of tabs
    @Override
    public int getCount() {
        return 1;
    }
}

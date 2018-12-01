package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class WizardTabsActivity extends AppCompatActivity {

    //This is the actual activity being launched, we're defining the tabs here
    //Actual content on these different parts of the wizard go in the fragments
    //One fragment per page, also a PageAdapter class
    //This Activity and Fragments each have layout files
    //when creating a Fragment, create Blank Fragment -- uncheck "include fragment factory methods
    // and interface callbacks
    //Content on wizard fragments is currently TEMPORARY, definitely needs to change
    //Can work on fragments pretty much the same way as activities it's just not a full thing

    //Most of this activity and its layout file shouldn't need to be changed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_tabs);
        //Get toolbar from activity_wizard_tabs
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        //Get the tablayout -- Define tab text...
        TabLayout layout = (TabLayout) findViewById(R.id.tab_layout);
        //Making the tabs scrollable so text can all be seen -- probably not necessary for character sheet part
        layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //add tabs in the same order defined by page adapter, name tabs
        layout.addTab(layout.newTab().setText(R.string.race));
        layout.addTab(layout.newTab().setText(R.string.charclass));
        layout.addTab(layout.newTab().setText(R.string.level));
        layout.addTab(layout.newTab().setText(R.string.statistics));
        layout.addTab(layout.newTab().setText(R.string.skillsprof));
        layout.addTab(layout.newTab().setText(R.string.traits));
        layout.addTab(layout.newTab().setText(R.string.background));
        layout.addTab(layout.newTab().setText(R.string.inventory));
        //get viewpager and page adapter -- can copy and paste the rest of this
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), layout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(layout));
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}

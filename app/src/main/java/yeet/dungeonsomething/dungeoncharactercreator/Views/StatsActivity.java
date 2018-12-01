package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class StatsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        TabLayout layout = (TabLayout) findViewById(R.id.stats_layout);
        layout.getTabAt(0).setText("STR");
        layout.getTabAt(1).setText("DEX");
        layout.getTabAt(2).setText("CON");
        layout.getTabAt(3).setText("INT");
        layout.getTabAt(4).setText("WIS");
        layout.getTabAt(5).setText("CHR");

        final ViewPager viewPager = (ViewPager) findViewById(R.id.stats_pager);
        final StatsPageAdapter adapter = new StatsPageAdapter(
                getSupportFragmentManager(), layout.getTabCount());
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

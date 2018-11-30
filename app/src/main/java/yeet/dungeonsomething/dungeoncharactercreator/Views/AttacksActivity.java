package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class AttacksActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attacks);

        TabLayout layout = (TabLayout) findViewById(R.id.attacks_layout);
        layout.getTabAt(0).setText("Physical Abilities").setIcon(R.drawable.attacks);
        layout.getTabAt(1).setText("Spellcasting").setIcon(R.drawable.attacks);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.attacks_pager);
        final AttacksPageAddapter adapter = new AttacksPageAddapter
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

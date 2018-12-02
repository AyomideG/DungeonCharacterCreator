package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class StatsActivity extends AppCompatActivity {
    Character myCharacter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);

        myCharacter = CharacterManager.getInstance(null).getCharacter();

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

        findViewById(R.id.backContainer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHome(v);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.character_home_name)).setText(myCharacter.getName());
        ((TextView) findViewById(R.id.character_home_race)).setText(myCharacter.getRace().getName());
        ((TextView) findViewById(R.id.character_home_class)).setText(myCharacter.getMyclass().getName());
        ((TextView) findViewById(R.id.character_home_level)).setText(String.valueOf(myCharacter.getLevel()));
    }

    public void showAttacks(View view){
        Intent intent = new Intent(this, AttacksActivity.class);
        startActivity(intent);
    }
    public void showStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
    public void showBackground(View view) {
        Intent intent = new Intent(this, CharacterBGActivity.class);
        startActivity(intent);
    }
    public void showNotes(View view) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }
    public void showInventory(View view) {
        Intent intent = new Intent(this, CharacterInventoryActivity.class);
        startActivity(intent);
    }
    public void showHome(View view){
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
}

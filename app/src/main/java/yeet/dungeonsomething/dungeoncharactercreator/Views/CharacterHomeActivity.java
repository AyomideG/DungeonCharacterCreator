package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharacterHomeActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_home);



    }
    public void showAttacks(View view){
        Intent intent = new Intent(this, AttacksActivity.class);
        startActivity(intent);
    }
    public void showStats(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void showBG(View view){
        Intent intent = new Intent(this, CharacterBGActivity.class);
        startActivity(intent);
    }
}

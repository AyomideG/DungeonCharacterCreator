package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Statistics;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharacterHomeActivity extends AppCompatActivity {

    private Character myCharacter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_home);

        Bundle b = getIntent().getExtras();
        if(b != null){
            myCharacter = loadMyCharacterData(b);
        } else if(savedInstanceState != null){
            myCharacter = loadMyCharacterData(savedInstanceState);
        }

        if(myCharacter == null){
            Log.e("ERROR","Character data null on create");
            //create a BS new character so the app doesnt die
            myCharacter = new Character();
            myCharacter.setRace(APIDataManager.getInstance(getAssets()).getRaces()[0]);
            myCharacter.setMyclass(APIDataManager.getInstance(getAssets()).getClasses()[0]);
            myCharacter.setStats(new Statistics());
            CharacterManager.getInstance(getAssets()).newCharacter(myCharacter);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.character_home_name)).setText(myCharacter.getName());
        ((TextView) findViewById(R.id.character_home_race)).setText(myCharacter.getRace().getName());
        ((TextView) findViewById(R.id.character_home_class)).setText(myCharacter.getMyclass().getName());
        ((TextView) findViewById(R.id.character_home_level)).setText(String.valueOf(myCharacter.getLevel()));
        ((TextView) findViewById(R.id.character_home_armor_class)).setText(String.valueOf(myCharacter.getArmorClass()));
        ((TextView) findViewById(R.id.character_home_initative)).setText(String.valueOf("TBD"));
        ((TextView) findViewById(R.id.character_home_speed)).setText(myCharacter.getRace().getSpeed() + "ft");
        ((TextView) findViewById(R.id.character_home_hp)).setText(String.valueOf(myCharacter.getHealthPoints()));
    }

    private Character loadMyCharacterData(Bundle b){
        String name = b.getString("CHARACTER_NAME");
        Character c = null;
        if(name != null)
            c =  CharacterManager.getInstance(getAssets()).getCharacter(name);
        return c;
    }


    public void showAttacks(View view){
        Intent intent = new Intent(this, AttacksActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
    public void showStats(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }

    public void showBG(View view){
        Intent intent = new Intent(this, CharacterBGActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
}

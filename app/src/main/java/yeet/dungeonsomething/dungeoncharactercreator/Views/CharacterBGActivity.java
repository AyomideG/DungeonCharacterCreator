package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.PlayerInfo;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Statistics;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Trait;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharacterBGActivity extends AppCompatActivity {

    private Character myCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_bg);

        Bundle b = getIntent().getExtras();
        if(b != null){
            myCharacter = loadMyCharacterData(b);
        } else if(savedInstanceState != null){
            myCharacter = loadMyCharacterData(savedInstanceState);
        }

        if(myCharacter == null){
            Log.e("ERROR","Character data null on create");
            myCharacter = new Character();
            myCharacter.setRace(APIDataManager.getInstance(getAssets()).getRaces()[0]);
            myCharacter.setMyclass(APIDataManager.getInstance(getAssets()).getClasses()[0]);
            myCharacter.setLevel(1);
            myCharacter.setPlayerInfo(new PlayerInfo());
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.character_bg_name)).setText(myCharacter.getName());
        ((TextView) findViewById(R.id.character_bg_race)).setText(myCharacter.getRace().getName());
        ((TextView) findViewById(R.id.character_bg_class)).setText(myCharacter.getMyclass().getName());
        ((TextView) findViewById(R.id.character_bg_Level)).setText(String.valueOf(myCharacter.getLevel()));
        ((TextView) findViewById(R.id.character_bg_background)).setText(myCharacter.getPlayerInfo().getBackGround());
        ((TextView) findViewById(R.id.character_bg_alignment)).setText(myCharacter.getPlayerInfo().getAlignment());
        TextView traitsView = findViewById(R.id.character_bg_traits);
        for (Trait t : myCharacter.getPlayerInfo().getTraits()) {
            if (t.getName().equals(myCharacter.getPlayerInfo().getTraits().get(0))) {
                traitsView.setText(traitsView.getText() + t.getName());
            } else {
                traitsView.setText(traitsView.getText() + "\n" + t.getName());
            }
        }
    }

    public void showAttacks(View v) {
        Intent intent = new Intent(this, AttacksActivity.class);
        startActivity(intent);
    }

    public void showStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    private Character loadMyCharacterData(Bundle b){
        String name = b.getString("CHARACTER_NAME");
        Character c = null;
        if(name != null)
            c =  CharacterManager.getInstance(getAssets()).getCharacter(name);
        return c;
    }
}

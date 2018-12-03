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
import yeet.dungeonsomething.dungeoncharactercreator.Model.Feature;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Language;
import yeet.dungeonsomething.dungeoncharactercreator.Model.PlayerInfo;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Statistics;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Trait;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharacterBGActivity extends AppCompatActivity {

    private Character myCharacter;
    private boolean ifNull = false;

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
            CharacterManager.getInstance(getAssets()).newCharacter(myCharacter);
            ifNull = true;
        }

        findViewById(R.id.titlerow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHome(v);
            }
        });

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
        if (myCharacter.getPlayerInfo().getTraits() == null) {
            if (myCharacter.getPlayerInfo().getFeatures() == null) {
                if (myCharacter.getPlayerInfo().getBonds() == null) {
                    if (myCharacter.getPlayerInfo().getFlaws() == null) {
                        if (myCharacter.getPlayerInfo().getIdeals() == null) {
                            if (myCharacter.getPlayerInfo().getLanguages() == null) {
                                ifNull = true;
                            }
                        }
                    }
                }
            }
        }
        if (!ifNull) {
            TextView traitsView = findViewById(R.id.character_bg_traits);
            for (Trait t : myCharacter.getPlayerInfo().getTraits()) {
                if (t.getName().equals(myCharacter.getPlayerInfo().getTraits().get(0))) {
                    traitsView.setText(traitsView.getText() + t.getName());
                } else {
                    traitsView.setText(traitsView.getText() + "\n" + t.getName());
                }
            }
            TextView featureView = findViewById(R.id.character_bg_features);
            for (Feature f : myCharacter.getPlayerInfo().getFeatures()) {
                if (f.getName().equals(myCharacter.getPlayerInfo().getFeatures().get(0))) {
                    featureView.setText(featureView.getText() + f.getName());
                } else {
                    featureView.setText(featureView.getText() + "\n" + f.getName());
                }
            }
            TextView idealsView = findViewById(R.id.character_bg_ideals);
            for (String i : myCharacter.getPlayerInfo().getIdeals()) {
                if (i.equals(myCharacter.getPlayerInfo().getIdeals().get(0))) {
                    idealsView.setText(idealsView.getText() + i);
                } else {
                    idealsView.setText(idealsView.getText() + "\n" + i);
                }
            }
            TextView bondsView = findViewById(R.id.character_bg_bonds);
            for (String b : myCharacter.getPlayerInfo().getBonds()) {
                if (b.equals(myCharacter.getPlayerInfo().getBonds().get(0))) {
                    bondsView.setText(bondsView.getText() + b);
                } else {
                    bondsView.setText(bondsView.getText() + "\n" + b);
                }
            }
            TextView flawsView = findViewById(R.id.character_bg_flaws);
            for (String f : myCharacter.getPlayerInfo().getFlaws()) {
                if (f.equals(myCharacter.getPlayerInfo().getFlaws().get(0))) {
                    flawsView.setText(flawsView.getText() + f);
                } else {
                    flawsView.setText(flawsView.getText() + "\n" + f);
                }
            }
            TextView languageView = findViewById(R.id.character_bg_languages);
            for (Language l : myCharacter.getPlayerInfo().getLanguages()) {
                if (l.getName().equals(myCharacter.getPlayerInfo().getLanguages().get(0))) {
                    languageView.setText(languageView.getText() + l.getName());
                } else if (l.getName() != null && !l.getName().isEmpty()) {
                } else {
                    languageView.setText(languageView.getText() + "\n" + l.getName());
                }
            }
        }
    }

    public void showAttacks(View view){
        Intent intent = new Intent(this, AttacksActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
    public void showStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
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
    public void showHome(View view) {
        Intent intent = new Intent(this, CharacterHomeActivity.class);
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

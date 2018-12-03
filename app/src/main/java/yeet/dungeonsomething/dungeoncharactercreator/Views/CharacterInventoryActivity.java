package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Item;
import yeet.dungeonsomething.dungeoncharactercreator.Model.PlayerInfo;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs.HomeData;
import yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs.NewInventoryData;

public class CharacterInventoryActivity extends AppCompatActivity {

    private Character myCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_inventory);
        final String[] sorting = new String[]{"Name", "Value", "Tag"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, sorting);
        BetterSpinner textView = (BetterSpinner)
                findViewById(R.id.sortSpinner);
        textView.setAdapter(adapter);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            myCharacter = loadMyCharacterData(b);
        } else if (savedInstanceState != null) {
            myCharacter = loadMyCharacterData(savedInstanceState);
        }

        if (myCharacter == null) {
            Log.e("ERROR", "Character data null on create");
            myCharacter = new Character();
            myCharacter.setRace(APIDataManager.getInstance(getAssets()).getRaces()[0]);
            myCharacter.setMyclass(APIDataManager.getInstance(getAssets()).getClasses()[0]);
            myCharacter.setLevel(1);
            myCharacter.setInventory(new ArrayList<Item>());
            CharacterManager.getInstance(getAssets()).newCharacter(myCharacter);
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
        updateView();
    }

    public void updateView() {
        ((TextView) findViewById(R.id.character_inv_name)).setText(myCharacter.getName());
        ((TextView) findViewById(R.id.character_inv_race)).setText(myCharacter.getRace().getName());
        ((TextView) findViewById(R.id.character_inv_class)).setText(myCharacter.getMyclass().getName());
        ((TextView) findViewById(R.id.character_inv_Level)).setText(String.valueOf(myCharacter.getLevel()));
        ArrayList<Item> items = myCharacter.getInventory();

        if (items != null) {
            TextView[] tv = new TextView[items.size()];
            TextView temp;
            LinearLayout invlist = findViewById(R.id.invlist);

            for (int i = 0; i < items.size(); i++) {
                temp = new TextView(this);
                temp.setGravity(Gravity.LEFT);
                temp.setText(items.get(i).getName() + "         " + items.get(i).getCost());
                invlist.addView(temp);
                tv[i] = temp;
            }

        }
    }

    public void newItem(View view){
        NewInventoryData nid = new NewInventoryData();
        nid.show(getFragmentManager(),"Edit");

    }

    public void showAttacks(View v) {
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
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
    public void showNotes(View view) {
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
    public void showInventory(View view) {
        Intent intent = new Intent(this, CharacterInventoryActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }
    public void showHome(View view) {
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        intent.putExtra("CHARACTER_NAME", myCharacter.getName());
        startActivity(intent);
    }

    private Character loadMyCharacterData(Bundle b) {
        String name = b.getString("CHARACTER_NAME");
        Character c = null;
        if (name != null)
            c = CharacterManager.getInstance(getAssets()).getCharacter(name);
        return c;
    }
}


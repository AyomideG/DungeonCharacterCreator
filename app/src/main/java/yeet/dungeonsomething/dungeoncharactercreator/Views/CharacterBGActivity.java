package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharacterBGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_bg);

        ListView listview = (ListView) findViewById(R.id.persview);
        String [] traits = new String[] {"kind", "clever", "honest"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, traits);
        listview.setAdapter(adapter);

    }

    public void showAttacks(View v) {
        Intent intent = new Intent(this, AttacksActivity.class);
        startActivity(intent);
    }
}

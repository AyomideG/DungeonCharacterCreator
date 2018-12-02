package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Note;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class NoteActivity extends AppCompatActivity {

    private ArrayList<Note> notes;
    private ExpandableListView listView;
    private ExpandableListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        final Intent intent = new Intent(this, NoteFragment.class);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        notes = getNotes();
        listView = findViewById(R.id.explistNotes);
        listView.setAdapter(adapter);
    }

    private ArrayList<Note> getNotes() {
        return CharacterManager.getInstance(getAssets()).getCharacter().getNotes();
    }
}

package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Note;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class NoteActivity extends AppCompatActivity {

    private ArrayList<Note> notes;
    private ArrayList<String> titles;
    private ArrayList<String> details;
    private ExpandableListView listView;
    private ExpandableListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        titles = new ArrayList<>();
        details = new ArrayList<>();
        notes = getNotes();
        parseNotes();
        final Intent intent = new Intent(this, NoteFragment.class);
        Button button = findViewById(R.id.button);
        intent.putExtra("NOTES", notes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteFragment nf = new NoteFragment();
                nf.show(getFragmentManager(), "Note");
            }
        });
        listView = findViewById(R.id.explistNotes);
        adapter = new CustomExpandableListAdapter(getBaseContext(), titles, details);
        listView.setAdapter(adapter);

        findViewById(R.id.backContainer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHome(v);
            }
        });

    }

    private ArrayList<Note> getNotes() {
        return CharacterManager.getInstance(getAssets()).getCharacter().getNotes();
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
    public void showInventory(View view) {
        Intent intent = new Intent(this, CharacterInventoryActivity.class);
        startActivity(intent);
    }
    public void showHome(View view) {
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        startActivity(intent);
    }

    public static class CustomExpandableListAdapter extends BaseExpandableListAdapter {
        private Context context;
        private LayoutInflater inf;
        private List<String> expandableListTitle;
        private ArrayList<String> expandableListDetail;

        public CustomExpandableListAdapter(Context context, ArrayList<String> expandableListTitle,
                                           ArrayList<String> expandableListDetail) {
            this.context = context;
            inf = LayoutInflater.from(context);
            Collections.sort(expandableListTitle, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });
            this.expandableListTitle = expandableListTitle;
            this.expandableListDetail = expandableListDetail;
        }

        @Override
        public Object getChild(int listPosition, int expandedListPosition) {
            return this.expandableListDetail.get(expandedListPosition);
        }

        @Override
        public long getChildId(int listPosition, int expandedListPosition) {
            return expandedListPosition;
        }

        @Override
        public View getChildView(int listPosition, final int expandedListPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            final String expandedListText = (String) getChild(listPosition, expandedListPosition);
            if (convertView == null) {
                convertView = inf.inflate(R.layout.note_item, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.expandedListNotes);
            expandedListTextView.setText(expandedListText);
            return convertView;
        }

        @Override
        public int getChildrenCount(int listPosition) {
            return this.expandableListDetail.size();
        }

        @Override
        public Object getGroup(int listPosition) {
            return this.expandableListTitle.get(listPosition);
        }

        @Override
        public int getGroupCount() {

            return this.expandableListTitle.size();
        }

        @Override
        public long getGroupId(int listPosition) {

            return listPosition;
        }

        @Override
        public View getGroupView(int listPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String listTitle = (String) getGroup(listPosition);
            if (convertView == null) {
                convertView = inf.inflate(R.layout.note_group, null);
            }
            TextView listTitleTextView = (TextView) convertView
                    .findViewById(R.id.listTitle2);
            listTitleTextView.setText(listTitle);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int listPosition, int expandedListPosition) {
            return true;
        }
    }

    public void parseNotes(){
        if(notes.size() > 0) {
            for (Note n : notes) {
                String title = n.getTitle();
                String content = n.getContent();
                titles.add(title);
                details.add(content);
            }
        }
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public void addToList(String title, String detail){
        details.add(detail);
        titles.add(title);
        listView.setAdapter(adapter);
    }

}

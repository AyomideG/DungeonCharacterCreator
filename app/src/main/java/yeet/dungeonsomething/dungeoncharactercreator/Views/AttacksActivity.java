package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Spell;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class AttacksActivity extends AppCompatActivity {
    //Spells list stuff
    Character myCharacter;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attacks);

//        Bundle b = getIntent().getExtras();
//        if(b != null){
//            myCharacter = CharacterManager.getInstance(getAssets()).getCharacter(b.getShort("CHARACTER_NAME"));
//        } else if(savedInstanceState != null){
//            myCharacter = CharacterManager.getInstance(getAssets()).getCharacter(savedInstanceState.getShort("CHARACTER_NAME"));
//        }
        myCharacter = CharacterManager.getInstance(getAssets()).getCharacter();

        //Fragment stuff
        TabLayout layout = (TabLayout) findViewById(R.id.attacks_layout);
        layout.getTabAt(0).setText("Physical Abilities").setIcon(R.drawable.attacks);
        layout.getTabAt(1).setText("Spellcasting").setIcon(R.drawable.magic);
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

    @Override
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.character_home_name)).setText(myCharacter.getName());
        ((TextView) findViewById(R.id.character_home_race)).setText(myCharacter.getRace().getName());
        ((TextView) findViewById(R.id.character_home_class)).setText(myCharacter.getMyclass().getName());
        ((TextView) findViewById(R.id.character_home_level)).setText(String.valueOf(myCharacter.getLevel()));
    }

    public static class CustomExpandableListAdapter extends BaseExpandableListAdapter {
        private Context context;
        private LayoutInflater inf;
        private List<String> expandableListTitle;
        private HashMap<String, List<String>> expandableListDetail;

        public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                           HashMap<String, List<String>> expandableListDetail) {
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
            return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                    .get(expandedListPosition);
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
                convertView = inf.inflate(R.layout.spell_list_item, null);
            }
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.expandedListItem);
            expandedListTextView.setText(expandedListText);
            return convertView;
        }

        @Override
        public int getChildrenCount(int listPosition) {
            return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                    .size();
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
                convertView = inf.inflate(R.layout.spelllist_group, null);
            }
            TextView listTitleTextView = (TextView) convertView
                    .findViewById(R.id.listTitle);
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
}

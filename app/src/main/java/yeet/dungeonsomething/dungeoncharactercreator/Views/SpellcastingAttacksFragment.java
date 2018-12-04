package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Spell;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class SpellcastingAttacksFragment extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public SpellcastingAttacksFragment(){
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        expandableListDetail = getAllSpells();
        expandableListTitle = new ArrayList<>(expandableListDetail.keySet());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spellcasting_attacks, container, false);
        // Inflate the layout for this fragment

        //set the data
        Character data = CharacterManager.getInstance(getActivity().getAssets()).getCharacter();
        ((TextView) view.findViewById(R.id.spellcastingLevel)).setText(String.valueOf("TBD"));
        ((TextView) view.findViewById(R.id.spellcastingBonus)).setText(String.valueOf("TBD"));
        ((TextView) view.findViewById(R.id.spellcastingDC)).setText("TBD");


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        //Spell list stuff
//        ExpandableListView expandableListView = (ExpandableListView) getView().findViewById(R.id.expandableKnownSpellsListView);
        HashMap<String, List<String>> allSpells = getAllSpells();
//        Log.d("NUMSPELLS", "#keys =" + allSpells.keySet().size());
//        expandableListView.setAdapter(new AttacksActivity.CustomExpandableListAdapter(getContext(), new ArrayList<String>(allSpells.keySet()), allSpells));
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableKnownSpellsListView);
        expandableListAdapter = new AttacksActivity.CustomExpandableListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

    }


    private HashMap<String,List<String>> getAllSpells(){
        HashMap<String,List<String>> transformedSpells = new HashMap<>();
        Spell[] apiSpells = APIDataManager.getInstance(getContext().getAssets()).getSpells();

        for(int i = 0; i < 10; i++){
            ArrayList<String> levelsSpells = new ArrayList<>();
            for(int j = 0; j < apiSpells.length; j++){
                if(apiSpells[j].getLevel() == i) {
                    Log.d("SPELL", "adding " + apiSpells[j].getName() + " of level " + i);
                    levelsSpells.add(apiSpells[j].getName());
                }
            }
            String name;
            if(i == 0)
                name = "Cantrips";
            else
                name = "Level "+i;
            transformedSpells.put(name, levelsSpells);
        }
//        ArrayList<String> list0 = new ArrayList<>();
//        list0.add("test 0");
//        list0.add("tets 1");
//        ArrayList<String> list1 = new ArrayList<>();
//        list1.add("test 0");
//        list1.add("tets 1");
//        transformedSpells.put("test 0",list0);
//        transformedSpells.put("test 1",list1);


        return transformedSpells;
    }

}

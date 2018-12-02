package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;


import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Race;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RaceFragment extends Fragment {
    ArrayList<String> list = new ArrayList<>();
    ImageView raceImages;


    public RaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        list = getRace();

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_race, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.raceSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        raceImages = (ImageView) v.findViewById(R.id.raceImage);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getSelectedItem().toString();

                if (name.equals("Dwarf")) {
                    raceImages.setImageResource(R.drawable.dwarf);
                }else if (name.equals("Elf")){
                    raceImages.setImageResource(R.drawable.elf);
                }else if (name.equals("Halfling")){
                    raceImages.setImageResource(R.drawable.halfling);
                }else if (name.equals("Human")){
                    raceImages.setImageResource(R.drawable.human);
                }else if (name.equals("Dragonborn")){
                    raceImages.setImageResource(R.drawable.dragonborn);
                }else if (name.equals("Gnome")){
                    raceImages.setImageResource(R.drawable.gnome);
                }else if (name.equals("Half-Elf")){
                    raceImages.setImageResource(R.drawable.halfelf);
                }else if (name.equals("Half-Orc")){
                    raceImages.setImageResource(R.drawable.halforc);
                }else if (name.equals("Tiefling")){
                    raceImages.setImageResource(R.drawable.tiefling);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }



    private ArrayList<String> getRace(){
        ArrayList<String> race = new ArrayList<>();
        Race[] apiRace = APIDataManager.getInstance(getContext().getAssets()).getRaces();

        for(int i = 0; i < apiRace.length; i++){
                    Log.d("RACE", "adding " + apiRace[i].getName() + " to list" + i);
            race.add(apiRace[i].getName());
        }


        return race;
    }

}

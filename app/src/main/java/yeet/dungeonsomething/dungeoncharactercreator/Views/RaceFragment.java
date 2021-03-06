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
import android.widget.TextView;


import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Race;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RaceFragment extends Fragment {
    ArrayList<String> list = new ArrayList<>();
    ImageView raceImages;
    TextView raceDescription;
    Character data;


    public RaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        list = getRace();

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_race, container, false);

        data = CharacterManager.getInstance(getActivity().getAssets()).getCharacter();
        if (data == null) {
            data = new Character();
        }

        Spinner spinner = (Spinner) v.findViewById(R.id.raceSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        raceImages = (ImageView) v.findViewById(R.id.raceImage);

        raceDescription = (TextView) v.findViewById(R.id.raceDescription);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getSelectedItem().toString();

                if (name.equals("Dwarf")) {
                    raceImages.setImageResource(R.drawable.dwarf);
                    raceDescription.setText(getDescription().get(0));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[0]);
                }else if (name.equals("Elf")){
                    raceImages.setImageResource(R.drawable.elf);
                    raceDescription.setText(getDescription().get(1));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[1]);
                }else if (name.equals("Halfling")){
                    raceImages.setImageResource(R.drawable.halfling);
                    raceDescription.setText(getDescription().get(2));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[2]);
                }else if (name.equals("Human")){
                    raceImages.setImageResource(R.drawable.human);
                    raceDescription.setText(getDescription().get(3));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[3]);
                }else if (name.equals("Dragonborn")){
                    raceImages.setImageResource(R.drawable.dragonborn);
                    raceDescription.setText(getDescription().get(4));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[4]);
                }else if (name.equals("Gnome")){
                    raceImages.setImageResource(R.drawable.gnome);
                    raceDescription.setText(getDescription().get(5));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[5]);
                }else if (name.equals("Half-Elf")){
                    raceImages.setImageResource(R.drawable.halfelf);
                    raceDescription.setText(getDescription().get(6));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[6]);
                }else if (name.equals("Half-Orc")){
                    raceImages.setImageResource(R.drawable.halforc);
                    raceDescription.setText(getDescription().get(7));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[7]);
                }else if (name.equals("Tiefling")){
                    raceImages.setImageResource(R.drawable.tiefling);
                    raceDescription.setText(getDescription().get(8));
                    CharacterManager.getInstance(null).getCharacter().setRace(APIDataManager.getInstance(null).getRaces()[8]);
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

    private ArrayList<String> getDescription(){
        ArrayList<String> ds = new ArrayList<>();

        Race[] apiRace = APIDataManager.getInstance(getContext().getAssets()).getRaces();
        for(int i = 0; i < apiRace.length; i++){
            Log.d("RACE", "adding " + apiRace[i].getName() + " to list" + i);
            ds.add("Name: " + apiRace[i].getName() + "\n" +
            "Speed: " + apiRace[i].getSpeed() + "\n" +
            "Alignment: " + apiRace[i].getAlignment() + "\n" +
            "Age: " + apiRace[i].getAge() + "\n" +
            "Size: " + apiRace[i].getSize() + "\n" +
            "Size Description: " + apiRace[i].getSize_description() + "\n");

        }

        return ds;
    }

}

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
import yeet.dungeonsomething.dungeoncharactercreator.Model.Class;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends Fragment {
    ArrayList<String> list = new ArrayList<>();
    ImageView classImages;

    public ClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        list = getCharClass();

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_class, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.classSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        classImages = (ImageView) v.findViewById(R.id.classImage);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getSelectedItem().toString();

                if (name.equals("Barbarian")) {
                    classImages.setImageResource(R.drawable.barbarian);
                }else if (name.equals("Bard")){
                    classImages.setImageResource(R.drawable.bard);
                }else if (name.equals("Cleric")){
                    classImages.setImageResource(R.drawable.cleric);
                }else if (name.equals("Druid")){
                    classImages.setImageResource(R.drawable.druid);
                }else if (name.equals("Fighter")){
                    classImages.setImageResource(R.drawable.fighter);
                }else if (name.equals("Monk")){
                    classImages.setImageResource(R.drawable.monk);
                }else if (name.equals("Paladin")){
                    classImages.setImageResource(R.drawable.paladin);
                }else if (name.equals("Ranger")){
                    classImages.setImageResource(R.drawable.ranger);
                }else if (name.equals("Rogue")){
                    classImages.setImageResource(R.drawable.rogue);
                }else if (name.equals("Sorcerer")){
                    classImages.setImageResource(R.drawable.sorcerer);
                }else if (name.equals("Warlock")){
                    classImages.setImageResource(R.drawable.warlock);
                }else if (name.equals("Wizard")){
                    classImages.setImageResource(R.drawable.wizard);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;

    }

    private ArrayList<String> getCharClass(){
        ArrayList<String> charClass = new ArrayList<>();
        Class[] apiClass = APIDataManager.getInstance(getContext().getAssets()).getClasses();

        for(int i = 0; i < apiClass.length; i++){
            Log.d("CLASS", "adding " + apiClass[i].getName() + " to list" + i);
            charClass.add(apiClass[i].getName());
        }


        return charClass;
    }

}


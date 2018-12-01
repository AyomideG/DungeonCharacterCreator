package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends Fragment {

    public ClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String [] classList = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin",
                "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_class, container, false);

        BetterSpinner spinner = (BetterSpinner) v.findViewById(R.id.classSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, classList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return v;

    }

}

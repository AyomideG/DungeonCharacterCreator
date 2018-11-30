package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.R;

public class CharStatsFragment extends Fragment {


    public CharStatsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_char_stat, container, false);
        TextView test = (TextView) view.findViewById(R.id.ability_name);
        if(test == null)
            Log.e("NULL", "test textvie wis null");
        if(getArguments() == null)
            Log.e("NULL", "saved state is null");
        test.setText(getArguments().getString("data"));
        return view;
    }
}

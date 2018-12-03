package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LevelFragment extends Fragment {


    public LevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        int start = 1;
        int end = 20;
        ArrayList<String> list = forLoopRange(start, end);

        View v = inflater.inflate(R.layout.fragment_level, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.levelSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        return v;
    }

    ArrayList<String> forLoopRange(int from, int limit) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int to = from+limit; from < to; ++from) {
            String s = Integer.toString(from);
            numbers.add(s);
        }
        return numbers;
    }

}

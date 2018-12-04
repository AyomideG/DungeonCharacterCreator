package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinalizeFragment extends Fragment {


    private Character myCharacter;

    public FinalizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment_finalize, container, false);

        myCharacter = CharacterManager.getInstance(getActivity().getAssets()).getCharacter();
        if (myCharacter == null) {
            myCharacter = new Character();
        }

        return v;
    }



}

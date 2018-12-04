package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundFragment extends Fragment {
    EditText screen;

    //This should be the default fragment stuff if you've unchecked the options under the layout part of new fragment screen
    //should probably be able to edit this like an activity
    //fragments also have their own layout files separate from wizardtabsactivity and pageradapter

    public BackgroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_background, container, false);

        screen = (EditText) v.findViewById(R.id.backgroundText);

        if(CharacterManager.getInstance(null).getCharacter().getPlayerInfo().getBackGround() == null) {
            screen.setText("");
        } else {
            screen.setText(CharacterManager.getInstance(null).getCharacter().getPlayerInfo().getBackGround());
        }

        return v;

    }

    @Override
    public void onDetach() {
        CharacterManager.getInstance(null).getCharacter().getPlayerInfo().setBackGround(screen.getText().toString());
        super.onDetach();
    }
}


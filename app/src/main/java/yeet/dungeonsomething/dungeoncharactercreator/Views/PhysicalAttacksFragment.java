package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class PhysicalAttacksFragment extends Fragment {
    public PhysicalAttacksFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_physical_attacks, container, false);

        //set the data
        Character data = CharacterManager.getInstance(getActivity().getAssets()).getCharacter();
        ((TextView) view.findViewById(R.id.proficency)).setText(String.valueOf("TBD"));
        ((TextView) view.findViewById(R.id.strengthBonus)).setText(String.valueOf(data.getStats().getModifier(data.getStats().getSTR())));

        View atkLayout = (LinearLayout) view.findViewById(R.id.attacks_layout);
        View attack = inflater.inflate(R.layout.attack_item, container, false);
//        ((CheckBox)profItem.findViewById(R.id.prof_check)).setText(profs[i].getName());
        ((LinearLayout) atkLayout).addView(attack);

        return view;
    }


}

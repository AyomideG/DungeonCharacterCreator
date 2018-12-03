package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Attack;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs.HomeData;
import yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs.NewAttackItem;

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
        ((TextView) view.findViewById(R.id.proficency)).setText(String.valueOf(CharacterManager.getInstance(null).getCharacter().getProficiencyBonus()));
        ((TextView) view.findViewById(R.id.strengthBonus)).setText(String.valueOf(data.getStats().getModifier(data.getStats().getSTR())));

        View atkLayout = (LinearLayout) view.findViewById(R.id.attacks_layout);
        ArrayList<Attack> attacks = CharacterManager.getInstance(null).getCharacter().getAttacks();
        for (int i = 0; i < attacks.size(); i++) {
            View attack = inflater.inflate(R.layout.attack_item, container, false);

            ((TextView)attack.findViewById(R.id.attack_name)).setText(attacks.get(i).getName());
//            ((TextView)attack.findViewById(R.id.attack_modifier)).setText(attacks.get(i).get());
            ((TextView)attack.findViewById(R.id.attack_range)).setText(attacks.get(i).getRange());
            ((TextView)attack.findViewById(R.id.attack_type)).setText(attacks.get(i).getType());
            ((TextView)attack.findViewById(R.id.attack_damage)).setText(attacks.get(i).getDamage().getDice_count()+"d"+attacks.get(i).getDamage().getDice_value());

            ((LinearLayout) atkLayout).addView(attack);
        }


        return view;
    }




}

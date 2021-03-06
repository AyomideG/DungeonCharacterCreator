package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Proficiency;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Skill;
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
        ((TextView) view.findViewById(R.id.ability_name)).setText(getArguments().getString("data"));
        ((TextView) view.findViewById(R.id.player_ability)).setText(String.valueOf(getArguments().getInt("value")));
        ((TextView) view.findViewById(R.id.abilityModifier)).setText(String.valueOf(getArguments().getInt("mod")));
        ((TextView) view.findViewById(R.id.ability_save)).setText(String.valueOf(getArguments().getInt("save")));

        //Add proficiencies
        Skill[] profs = APIDataManager.getInstance(getContext().getAssets()).getSkills();
        for(int i = 0; i < profs.length; i++){
            String one = profs[i].getAbility_score().getIdentifier().toLowerCase();
            String two = getArguments().getString("data").toLowerCase();
            if(two.contains(one)){//that skill is in this tab
                View profFayout = (LinearLayout) view.findViewById(R.id.proficiencies_layout);
                View profItem = inflater.inflate(R.layout.proficency_item, container, false);
                ((CheckBox)profItem.findViewById(R.id.prof_check)).setText(profs[i].getName());
                for (int j = 0; j < profs[i].getDesc().length; j++) {//set description text
                    ((TextView)profItem.findViewById(R.id.skill_description)).append(profs[i].getDesc()[j]);
                }
                //set the proficiency bonus
                int modValue = getArguments().getInt("mod");
                //check character stats. TBD This is not efficient, make faster
                for(Skill s : CharacterManager.getInstance(null).getCharacter().getSkillsProficentIn()){
                    if(s.getName().compareToIgnoreCase(profs[i].getName()) == 0) {
                        modValue += 2;
                        ((CheckBox)profItem.findViewById(R.id.prof_check)).setChecked(true);
                    }
                }

                ((TextView)profItem.findViewById(R.id.prof_bomus)).setText(String.valueOf(modValue));
                ((LinearLayout) profFayout).addView(profItem);

            }
        }
        return view;
    }
}

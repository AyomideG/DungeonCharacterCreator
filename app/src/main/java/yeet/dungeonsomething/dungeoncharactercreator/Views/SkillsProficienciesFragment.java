package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Proficiency;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Skill;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Statistics;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsProficienciesFragment extends Fragment {

    Character data;

    public SkillsProficienciesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skills_proficiencies, container, false);

        data = CharacterManager.getInstance(getActivity().getAssets()).getCharacter();
        if (data == null) {
            data = new Character();
        }


        //****STRENGTH*****

        EditText str = view.findViewById(R.id.strEdit);
        str.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }


            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setSTR(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox str_save = view.findViewById(R.id.str_save_throws_check);
        str_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Strength Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox ath = view.findViewById(R.id.athletics_check);
        ath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Athletics");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        //****DEXTERITY****

        EditText dex = view.findViewById(R.id.dexText);
        dex.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setDEX(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox dex_save = view.findViewById(R.id.dex_save_throws_check);
        dex_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Dexterity Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox acro = view.findViewById(R.id.acrobatics_check);
        acro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Acrobatics");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox sleight = view.findViewById(R.id.sleight_hand_check);
        sleight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Sleight of Hand");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox stealth = view.findViewById(R.id.stealth_check);
        stealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Stealth");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        //*****CONSTITUTION******

        EditText con = view.findViewById(R.id.conText);
        con.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setCON(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox const_save = view.findViewById(R.id.const_save_throws_check);
        const_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Constitution Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        //***********INTELLIGENCE**************

        EditText inte = view.findViewById(R.id.intText);
        inte.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setINT(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox int_save = view.findViewById(R.id.int_save_throws_check);
        int_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Intelligence Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox arcana = view.findViewById(R.id.arcana_check);
        arcana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Arcana");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox hist_c = view.findViewById(R.id.history_check);
        hist_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("History");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox invest = view.findViewById(R.id.invest_check);
        invest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Investigation");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox nature = view.findViewById(R.id.nature_check);
        nature.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Nature");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox religion = view.findViewById(R.id.religion_check);
        religion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Religion");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        //*********WISDOM************

        EditText wis = view.findViewById(R.id.wisText);
        wis.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setWIS(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox wisCheck = view.findViewById(R.id.wis_save_throw_check);
        wisCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Wisdom Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox animal = view.findViewById(R.id.animal_check);
        animal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Animal Handling");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox insight = view.findViewById(R.id.insight_check);
        insight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Insight");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox medicine = view.findViewById(R.id.medicine_check);
        medicine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Medicine");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox percep = view.findViewById(R.id.perception_check);
        percep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Perception");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox survival = view.findViewById(R.id.survival_check);
        survival.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Survival");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        //*************CHARISMA*****************

        EditText cha = view.findViewById(R.id.chaText);
        cha.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (data.getStats() == null) {
                    data.setStats(new Statistics());
                }
                if (!s.toString().isEmpty()) {
                    data.getStats().setCHR(Integer.parseInt(s.toString()));
                }
            }
        });

        CheckBox chaCheck = view.findViewById(R.id.cha_save_throw_check);
        chaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Charisma Saving Throw");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox deception = view.findViewById(R.id.deception_check);
        deception.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Deception");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox intim = view.findViewById(R.id.intimidation_check);
        intim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Intimidation");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox perform = view.findViewById(R.id.perform_check);
        perform.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Performance");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        CheckBox persuasion = view.findViewById(R.id.persuasion_check);
        persuasion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Skill s = new Skill();
                s.setName("Charisma");
                if (data.getSkillsProficentIn() == null) {
                    data.setSkillsProficentIn(new ArrayList<Skill>());
                }
                data.getSkillsProficentIn().add(s);
            }
        });

        return view;
    }

}

package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
                Proficiency p = new Proficiency();
                p.setName("Strength Saving Throws");
                p.setType("Strength");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox ath = view.findViewById(R.id.athletics_check);
        ath.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Athletics");
                p.setType("Strength");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
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
                data.getStats().setDEX(Integer.parseInt(s.toString()));}
            }
        });

        CheckBox dex_save = view.findViewById(R.id.dex_save_throws_check);
        dex_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Dexterity Saving Throws");
                p.setType("Dexterity");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox acro = view.findViewById(R.id.acrobatics_check);
        acro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Acrobatics");
                p.setType("Dexterity");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox sleight = view.findViewById(R.id.sleight_hand_check);
        sleight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Sleight of Hand");
                p.setType("Dexterity");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox stealth = view.findViewById(R.id.stealth_check);
        stealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Stealth");
                p.setType("Dexterity");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
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
                data.getStats().setCON(Integer.parseInt(s.toString()));}
            }
        });

        CheckBox const_save = view.findViewById(R.id.const_save_throws_check);
        const_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Constitution Saving Throws");
                p.setType("Constitution");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
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
                } if (!s.toString().isEmpty()) {
                data.getStats().setINT(Integer.parseInt(s.toString()));}
            }
        });

        CheckBox int_save = view.findViewById(R.id.int_save_throws_check);
        int_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Intelligence Saving Throws");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox arcana = view.findViewById(R.id.arcana_check);
        arcana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Arcana");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox hist_c = view.findViewById(R.id.history_check);
        hist_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("History");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox invest = view.findViewById(R.id.invest_check);
        invest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Investigation");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox nature = view.findViewById(R.id.nature_check);
        nature.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Nature");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox religion = view.findViewById(R.id.religion_check);
        religion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Religion");
                p.setType("Intelligence");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
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
                } if (!s.toString().isEmpty()) {
                data.getStats().setWIS(Integer.parseInt(s.toString())); }
            }
        });

        CheckBox wisCheck = view.findViewById(R.id.wis_save_throw_check);
        wisCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Wisdom Saving Throws");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox animal = view.findViewById(R.id.animal_check);
        animal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Animal Handling");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox insight = view.findViewById(R.id.insight_check);
        insight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Insight");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox medicine = view.findViewById(R.id.medicine_check);
        medicine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Medicine");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox percep = view.findViewById(R.id.perception_check);
        percep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Perception");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox survival = view.findViewById(R.id.survival_check);
        survival.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Survival");
                p.setType("Wisdom");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
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
                } if (!s.toString().isEmpty()) {
                data.getStats().setCHR(Integer.parseInt(s.toString())); }
            }
        });

        CheckBox chaCheck = view.findViewById(R.id.cha_save_throw_check);
        chaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Charisma Saving Throws");
                p.setType("Charisma");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox deception = view.findViewById(R.id.deception_check);
        deception.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Deception");
                p.setType("Charisma");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox intim = view.findViewById(R.id.intimidation_check);
        intim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Inimidation");
                p.setType("Charisma");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox perform = view.findViewById(R.id.perform_check);
        perform.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Performance");
                p.setType("Charisma");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        CheckBox persuasion = view.findViewById(R.id.persuasion_check);
        persuasion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Proficiency p = new Proficiency();
                p.setName("Persuasion");
                p.setType("Charisma");
                if (data.getProficiencies() == null) {
                    data.setProficiencies(new ArrayList<Proficiency>());
                }
                if (b) {
                    data.getProficiencies().add(p);
                } else {
                    data.getProficiencies().remove(p);
                }
            }
        });

        return view;
    }

}

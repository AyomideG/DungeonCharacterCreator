package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

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

        View atkLayout = (LinearLayout) view.findViewById(R.id.attacks_layout);
        View attack = inflater.inflate(R.layout.attack_item, container, false);
//        ((CheckBox)profItem.findViewById(R.id.prof_check)).setText(profs[i].getName());
        ((LinearLayout) atkLayout).addView(attack);

        return view;
    }


}

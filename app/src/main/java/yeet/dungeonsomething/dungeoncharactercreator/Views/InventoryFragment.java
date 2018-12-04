package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Equipment;
import yeet.dungeonsomething.dungeoncharactercreator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    public HashMap<String, List<String>> children;

    public String name;

    ExpandableListView expandableListView;
    ArrayList<Group> groups;
    EListAdapter adapter;


    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inventory, container, false);

        groups = new ArrayList<>();
        getEquipmentValues();
        expandableListView = (ExpandableListView) v.findViewById(R.id.inventory);
        adapter = new EListAdapter(getActivity(), groups);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnChildClickListener(adapter);

        return v;
    }

    public void getEquipmentValues() {
        for (String s : getEquipmentCategory()) {
            Group g = new Group(s);
            for (String k : getEquipment()) {
                Child c = new Child(k);
                g.addChildrenItem(c);
            }
            groups.add(g);
        }
    }

    private ArrayList<String> getEquipment() {
        ArrayList<String> equipment = new ArrayList<>();
        Equipment[] apiEquipment = APIDataManager.getInstance(getContext().getAssets()).getEquipments();
        for (int i = 0; i < apiEquipment.length; i++) {
            Log.d("EQUIPMENT", "adding " + apiEquipment[i].getName() + " to list ");
            equipment.add(apiEquipment[i].getName());
        }

        return equipment;
    }

    private ArrayList<String> getEquipmentCategory() {
        ArrayList<String> equipmentCategory = new ArrayList<>();
        equipmentCategory.add("Weapons and Armors");
        return equipmentCategory;
    }

}


class Child {
    private String value;
    private boolean isChecked;

    public Child(String value) {
        this.value = value;
        this.isChecked = false;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void toggle() {
        this.isChecked = !this.isChecked;
    }

    public boolean getChecked() {
        return this.isChecked;
    }

    public String getValuess() {
        return value;
    }
}


class Group {
    private String parent;
    private ArrayList<Child> children;
    private boolean isChecked;

    public Group(String parent) {
        this.parent = parent;
        children = new ArrayList<>();
        this.isChecked = false;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void toggle() {
        this.isChecked = !this.isChecked;
    }

    public boolean getChecked() {
        return this.isChecked;
    }

    public String getParent() {
        return parent;
    }

    public void addChildrenItem(Child child) {
        children.add(child);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public Child getChildItem(int index) {
        return children.get(index);
    }
}

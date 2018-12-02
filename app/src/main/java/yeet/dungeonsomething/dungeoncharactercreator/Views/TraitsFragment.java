package yeet.dungeonsomething.dungeoncharactercreator.Views;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Feature;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Language;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Trait;
import yeet.dungeonsomething.dungeoncharactercreator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TraitsFragment extends Fragment {
    ArrayList<String> languagesList = new ArrayList<>();
    ArrayList<String> traitsList = new ArrayList<>();
    ArrayList<String> featureList = new ArrayList<>();

    MyAdapter adapter, adapter2, adapter3;

    public TraitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_traits, container, false);

        Spinner languagesSpinner = (Spinner) v.findViewById(R.id.languagesSpinner);
        Spinner traitsSpinner = (Spinner) v.findViewById(R.id.traitsSpinner);
        Spinner featureSpinner = (Spinner) v.findViewById(R.id.featureSpinner);


        languagesList = getLanguages();
        String[] languagesArray = new String[languagesList.size()];
        for(int j =0;j<languagesList.size();j++){
            languagesArray[j] = languagesList.get(j);
        }

        ArrayList<StateVO> languagesListVOs = new ArrayList<>();
        for (int i = 0; i < languagesArray.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(languagesArray[i]);
            stateVO.setSelected(false);
            languagesListVOs.add(stateVO);
        }

        traitsList = getTraits();
        String[] traitsArray = new String[traitsList.size()];
        for(int j =0;j<traitsList.size();j++){
            traitsArray[j] = traitsList.get(j);
        }

        ArrayList<StateVO> traitsListVOs = new ArrayList<>();
        for (int i = 0; i < traitsArray.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(traitsArray[i]);
            stateVO.setSelected(false);
            traitsListVOs.add(stateVO);
        }

        featureList = getFeature();
        String[] featureArray = new String[featureList.size()];
        for(int j =0;j<featureList.size();j++){
            featureArray[j] = featureList.get(j);
        }

        ArrayList<StateVO> featureListVOs = new ArrayList<>();
        for (int i = 0; i < featureArray.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(featureArray[i]);
            stateVO.setSelected(false);
            featureListVOs.add(stateVO);
        }


        adapter = new MyAdapter(this.getActivity(), 0, languagesListVOs);
        adapter2 = new MyAdapter(this.getActivity(), 0, traitsListVOs);
        adapter3 = new MyAdapter(this.getActivity(), 0, featureListVOs);
        languagesSpinner.setAdapter(adapter);
        traitsSpinner.setAdapter(adapter2);
        featureSpinner.setAdapter(adapter3);

        return v;

    }

    private ArrayList<String> getLanguages(){
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Select Language");
        Language[] apiLanguages = APIDataManager.getInstance(getContext().getAssets()).getLanguages();

        for(int i = 0; i < apiLanguages.length; i++){
            Log.d("LANGUAGES", "adding " + apiLanguages[i].getName() + " to list" + i);
            languages.add(apiLanguages[i].getName());
        }


        return languages;
    }

    private ArrayList<String> getTraits(){
        ArrayList<String> traits = new ArrayList<>();
        traits.add("Select Personality Traits");
        Trait[] apiTraits = APIDataManager.getInstance(getContext().getAssets()).getTraits();

        for(int i = 0; i < apiTraits.length; i++){
            Log.d("TRAITS", "adding " + apiTraits[i].getName() + " to list" + i);
            traits.add(apiTraits[i].getName());
        }


        return traits;
    }

    private ArrayList<String> getFeature(){
        ArrayList<String> feature = new ArrayList<>();
        feature.add("Select Feature");
        Feature[] apiFeature = APIDataManager.getInstance(getContext().getAssets()).getFeatures();

        for(int i = 0; i < apiFeature.length; i++){
            Log.d("FEATURE", "adding " + apiFeature[i].getName() + " to list" + i);
            feature.add(apiFeature[i].getName());
        }


        return feature;
    }

}

class StateVO {
    private String title;
    private boolean selected;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

class MyAdapter extends ArrayAdapter<StateVO> {
    private Context mContext;
    private ArrayList<StateVO> listState;
    private MyAdapter myAdapter;
    private boolean isFromView = false;

    public MyAdapter(Context context, int resource, List<StateVO> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listState = (ArrayList<StateVO>) objects;
        this.myAdapter = this;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(final int position, View convertView,
                              ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            convertView = layoutInflator.inflate(R.layout.spinner_item, null);
            holder = new ViewHolder();
            holder.mTextView = (TextView) convertView
                    .findViewById(R.id.text);
            holder.mCheckBox = (CheckBox) convertView
                    .findViewById(R.id.checkbox);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(listState.get(position).getTitle());

        // To check weather checked event fire from getview() or user input
        isFromView = true;
        holder.mCheckBox.setChecked(listState.get(position).isSelected());
        isFromView = false;

        if ((position == 0)) {
            holder.mCheckBox.setVisibility(View.INVISIBLE);
        } else {
            holder.mCheckBox.setVisibility(View.VISIBLE);
        }
        holder.mCheckBox.setTag(position);
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (Integer) buttonView.getTag();

                if (!isFromView) {
                    listState.get(position).setSelected(isChecked);
                }
            }
        });
        return convertView;
    }

    private class ViewHolder {
        private TextView mTextView;
        private CheckBox mCheckBox;
    }
}

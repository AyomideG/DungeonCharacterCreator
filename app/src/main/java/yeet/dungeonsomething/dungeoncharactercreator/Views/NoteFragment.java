package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import yeet.dungeonsomething.dungeoncharactercreator.Model.Note;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class NoteFragment extends Fragment {

    Note note;
    EditText titleHolder;
    EditText descriptionHolder;
    Button saveButton;
    Intent intent;
    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_spellcasting_attacks, container, false);
        titleHolder = view.findViewById(R.id.title);
        descriptionHolder = view.findViewById(R.id.description);
        saveButton = view.findViewById(R.id.button2);
        return view;
    }

    public void save(){
        // Saves the note and goes back
        String title = titleHolder.getText().toString();
        String description = descriptionHolder.getText().toString();
        note = new Note(title, description);
        intent = new Intent(getActivity(), NoteActivity.class);
        intent.putExtra("NOTE", note);
        startActivity(intent);
    }
}

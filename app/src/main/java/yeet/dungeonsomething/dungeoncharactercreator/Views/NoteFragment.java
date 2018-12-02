package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import yeet.dungeonsomething.dungeoncharactercreator.Model.Note;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class NoteFragment extends DialogFragment {

    private Note note;
    private EditText titleHolder;
    private EditText descriptionHolder;
    private Button saveButton;
    private Intent intent;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_note, container, false);
        view.bringToFront();
        view.
        titleHolder = view.findViewById(R.id.title);
        descriptionHolder = view.findViewById(R.id.description);
        saveButton = view.findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

    }

    public void save(){
        // Saves the note and goes back
        String title = titleHolder.getText().toString();
        String description = descriptionHolder.getText().toString();
        note = new Note(title, description);
        intent = new Intent(getActivity(), NoteActivity.class);
        intent.putExtra("NOTE", note); // add to char notes instead of this
        startActivity(intent);
    }
}

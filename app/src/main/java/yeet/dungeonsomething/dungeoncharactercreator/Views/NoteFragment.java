package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Note;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class NoteFragment extends DialogFragment {
    View view;
    EditText title;
    EditText description;
    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        view = inflater.inflate(R.layout.fragment_note, null);
        builder.setMessage("")
                .setView(view)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // apply and render?
                        title = view.findViewById(R.id.title);
                        description = view.findViewById(R.id.description);
                        String titStr = title.getText().toString();
                        String descStr = description.getText().toString();
                        Note note = new Note(titStr, descStr);
                        Log.d("Yeet", "titleString: " + titStr + "\n descriptionString: " + descStr);
                        CharacterManager.getInstance(getActivity().getAssets()).getCharacter().getNotes().add(note);
                        ((NoteActivity)getActivity()).addToList(titStr, descStr);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //dont apply changes
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

<<<<<<< HEAD
=======

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_note, container, false);
        view.bringToFront();
        //view.
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
>>>>>>> b7ec7159ea0fd940d8e0991272e61f9d75361347
}

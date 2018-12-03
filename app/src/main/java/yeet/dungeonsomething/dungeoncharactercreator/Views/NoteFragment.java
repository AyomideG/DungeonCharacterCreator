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
                        ((NoteActivity) getActivity()).addToList(titStr, descStr);
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
}

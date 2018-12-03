package yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.CharacterHomeActivity;

public class HomeData extends DialogFragment {
    View dialogContent;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //set the data in the dialog
        dialogContent = inflater.inflate(R.layout.dialog_character_home, null);
        ((TextView)dialogContent.findViewById(R.id.editHealth)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getHealthPoints()));
        ((EditText)dialogContent.findViewById(R.id.numDice)).setText("2");
        ((EditText)dialogContent.findViewById(R.id.diceType)).setText("6");

        builder.setMessage("Edit")
                .setView(dialogContent)
                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // apply and render?
                        saveData();
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

    public void saveData(){
        String newHealth = String.valueOf(((TextView)dialogContent.findViewById(R.id.editHealth)).getText());
        CharacterManager.getInstance(null).getCharacter().setHealthPoints(Integer.parseInt(newHealth));

        ((CharacterHomeActivity)getActivity()).updateView();
    }
}

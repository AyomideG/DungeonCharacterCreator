package yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.CharacterHomeActivity;
import yeet.dungeonsomething.dungeoncharactercreator.Views.StatsActivity;

public class StatsData extends DialogFragment {
    View dialogContent;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //set the data in the dialog
        dialogContent = inflater.inflate(R.layout.dialog_character_stats, null);
        ((TextView)dialogContent.findViewById(R.id.editStr)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getSTR()));
        ((TextView)dialogContent.findViewById(R.id.editDex)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getDEX()));
        ((TextView)dialogContent.findViewById(R.id.editCon)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getCON()));
        ((TextView)dialogContent.findViewById(R.id.editInt)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getINT()));
        ((TextView)dialogContent.findViewById(R.id.editWis)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getWIS()));
        ((TextView)dialogContent.findViewById(R.id.editCha)).setText(String.valueOf(
                CharacterManager.getInstance(null).getCharacter().getStats().getCHR()));


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
        String str = String.valueOf(((TextView)dialogContent.findViewById(R.id.editStr)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setSTR(Integer.parseInt(str));

        String dex = String.valueOf(((TextView)dialogContent.findViewById(R.id.editDex)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setDEX(Integer.parseInt(dex));

        String con = String.valueOf(((TextView)dialogContent.findViewById(R.id.editCon)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setCON(Integer.parseInt(con));

        String _int = String.valueOf(((TextView)dialogContent.findViewById(R.id.editInt)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setINT(Integer.parseInt(_int));

        String wis = String.valueOf(((TextView)dialogContent.findViewById(R.id.editWis)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setWIS(Integer.parseInt(wis));

        String cha = String.valueOf(((TextView)dialogContent.findViewById(R.id.editCha)).getText());
        CharacterManager.getInstance(null).getCharacter().getStats().setCHR(Integer.parseInt(cha));

        ((StatsActivity)getActivity()).updateView();
    }
}

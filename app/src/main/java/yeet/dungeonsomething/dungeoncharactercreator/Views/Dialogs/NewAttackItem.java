package yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.APIDataManager;
import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Attack;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Damage;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Info;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.AttacksActivity;
import yeet.dungeonsomething.dungeoncharactercreator.Views.CharacterHomeActivity;

public class NewAttackItem extends DialogFragment {
    View dialogContent;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //set the data in the dialog
        dialogContent = inflater.inflate(R.layout.dialog_new_attack, null);

        ArrayList<String> damageTypes = new ArrayList<>();
        Info[] damages = APIDataManager.getInstance(getActivity().getAssets()).getDamageTypes();
        for (int i = 0; i < damages.length; i++) {
            damageTypes.add(damages[i].getName());
        }
        Spinner spinner = (Spinner) dialogContent.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, damageTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


//        ((EditText)dialogContent.findViewById(R.id.diceType)).setText(String.valueOf(
//                CharacterManager.getInstance(null).getCharacter().getHitDice().getDice_value()
//        ));

        builder.setMessage("Edit")
                .setView(dialogContent)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
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
        String damageType = (String)((Spinner)dialogContent.findViewById(R.id.spinner)).getSelectedItem();
        String name = String.valueOf(((TextView)dialogContent.findViewById(R.id.editName)).getText());
        String range = String.valueOf(((TextView)dialogContent.findViewById(R.id.editRange)).getText());
        String dNum = String.valueOf(((TextView)dialogContent.findViewById(R.id.numDice)).getText());
        String dType = String.valueOf(((TextView)dialogContent.findViewById(R.id.diceType)).getText());
        Attack attack = new Attack();
        attack.setName(name);
        attack.setDamage(new Damage(Integer.valueOf(dNum),Integer.valueOf(dType)));
        attack.setRange(range);
        attack.setType(damageType);
        CharacterManager.getInstance(null).getCharacter().getAttacks().add(attack);
//        String newHealth = String.valueOf(((TextView)dialogContent.findViewById(R.id.editHealth)).getText());
//        CharacterManager.getInstance(null).getCharacter().setHealthPoints(Integer.parseInt(newHealth));


        ((AttacksActivity)getActivity()).updateView();
    }
}

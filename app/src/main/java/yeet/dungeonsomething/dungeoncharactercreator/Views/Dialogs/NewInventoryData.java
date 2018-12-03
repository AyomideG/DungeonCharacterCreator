package yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Cost;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Damage;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Item;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.CharacterInventoryActivity;

public class NewInventoryData extends DialogFragment {

    View dialogContent;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //set the data in the dialog
        dialogContent = inflater.inflate(R.layout.dialog_character_inventory_add, null);

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

    public void saveData() {
        if (CharacterManager.getInstance(null).getCharacter().getInventory() == null) {
            CharacterManager.getInstance(null).getCharacter().setInventory(new ArrayList<Item>());
        }
        String newName = String.valueOf(((EditText) dialogContent.findViewById(R.id.editName)).getText());
        String newCost = String.valueOf(((EditText) dialogContent.findViewById(R.id.editCost)).getText());
        String newDamage = String.valueOf(((EditText) dialogContent.findViewById(R.id.editDamage)).getText());
        String newQuantity = String.valueOf(((EditText) dialogContent.findViewById(R.id.editQuantity)).getText());
        String newWeight = String.valueOf(((EditText) dialogContent.findViewById(R.id.editWeight)).getText());
        String newType = String.valueOf(((EditText) dialogContent.findViewById(R.id.typeSpinner)).getText());
        Item i = new Item();
        Cost c = new Cost();
        c.setQuantity(Integer.parseInt(newCost));
        i.setCost(c);
        Damage d = new Damage();
        d.setDice_value(Integer.parseInt(newDamage));
        i.setDamage(d);
        i.setName(newName);
        i.setQuantity(Integer.parseInt(newQuantity));
        i.setType(newType);
        i.setWeight(Double.parseDouble(newWeight));
        CharacterManager.getInstance(null).getCharacter().getInventory().add(i);

        ((CharacterInventoryActivity) getActivity()).updateView();
    }
}


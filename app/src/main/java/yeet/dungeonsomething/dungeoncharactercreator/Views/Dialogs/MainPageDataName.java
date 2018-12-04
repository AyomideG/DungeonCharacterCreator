package yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.MainActivity;
import yeet.dungeonsomething.dungeoncharactercreator.Views.WizardTabsActivity;


public class MainPageDataName extends DialogFragment {
    View view;
    EditText name;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        view = inflater.inflate(R.layout.character_name, null);
        builder.setMessage("")
                .setView(view)
                .setPositiveButton("Begin Creation", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // apply and render?
                        name = view.findViewById(R.id.character_name);
                        ((MainActivity)getActivity()).addCharacterName(name.getText().toString());
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void dismiss() {
        Intent intent = new Intent(getActivity(), WizardTabsActivity.class);
        super.dismiss();
        startActivity(intent);
    }
}

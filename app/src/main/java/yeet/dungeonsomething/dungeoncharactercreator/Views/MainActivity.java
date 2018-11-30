package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;

public class MainActivity extends AppCompatActivity {

    Character[] chars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Character [] chars = new Character[5];
    }

    public void showCharacter(View view) {
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        Intent intent1 = new Intent(this, WizardTabsActivity.class);
        EditText editText = findViewById(R.id.CharacterName);
        String message = editText.getText().toString();
        if(message.equals("New Character")){
            startActivity(intent1);
        } else {
            for (int i = 0; i < chars.length; ++i) {
                if (message.equals(chars[i].getName())) {
                    intent.putExtra("CHARACTER_NAME", chars[i]);
                    startActivity(intent);
                }
            }
        }

//        intent.putExtra(EXTRA_MESSAGE, message);
    }

    public void toWizard(View view ) {
        Intent intent = new Intent(this, WizardTabsActivity.class);
        startActivity(intent);
    }

    public void toCharacterSheet(View view){
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        startActivity(intent);
    }
}

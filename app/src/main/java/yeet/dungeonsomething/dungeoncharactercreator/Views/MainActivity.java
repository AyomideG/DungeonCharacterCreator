package yeet.dungeonsomething.dungeoncharactercreator.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;


import yeet.dungeonsomething.dungeoncharactercreator.CharacterManager;
import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;
import yeet.dungeonsomething.dungeoncharactercreator.R;
import yeet.dungeonsomething.dungeoncharactercreator.Views.Dialogs.MainPageDataName;

public class MainActivity extends AppCompatActivity {

    Character[] chars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, CharacterHomeActivity.class);
       // final Intent intent1 = new Intent(this, WizardTabsActivity.class);
        final AppCompatEditText editText = findViewById(R.id.CharacterName);
        final AppCompatEditText editText1 = findViewById(R.id.CharacterName2);
        final AppCompatEditText editText2 = findViewById(R.id.CharacterName3);
        final AppCompatEditText editText3 = findViewById(R.id.CharacterName4);
        final AppCompatEditText editText4 = findViewById(R.id.CharacterName5);

        chars = new Character[5];
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                if(message.equals("New Character")){
                    MainPageDataName mpdn = new MainPageDataName();
                    mpdn.show(getFragmentManager(), "Name");
                }
                else {
                    intent.putExtra("CHARACTER_NAME", chars[0].getName());
                    startActivity(intent);
                }
            }
        });

        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText1.getText().toString();
                if(message.equals("New Character")) {
                    MainPageDataName mpdn = new MainPageDataName();
                    mpdn.show(getFragmentManager(), "Name");                }
                else {
                    intent.putExtra("CHARACTER_NAME", chars[1].getName());
                    startActivity(intent);
                }
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText2.getText().toString();
                if(message.equals("New Character")){
                    MainPageDataName mpdn = new MainPageDataName();
                    mpdn.show(getFragmentManager(), "Name");                }
                else {
                    intent.putExtra("CHARACTER_NAME", chars[2].getName());
                    startActivity(intent);
                }
            }
        });

        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText3.getText().toString();
                if(message.equals("New Character")){
                    MainPageDataName mpdn = new MainPageDataName();
                    mpdn.show(getFragmentManager(), "Name");                }
                else {
                    intent.putExtra("CHARACTER_NAME", chars[3].getName());
                    startActivity(intent);
                }
            }
        });

        editText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText4.getText().toString();
                if(message.equals("New Character")){
                    MainPageDataName mpdn = new MainPageDataName();
                    mpdn.show(getFragmentManager(), "Name");
                }
                else {
                    intent.putExtra("CHARACTER_NAME", chars[4].getName());
                    startActivity(intent);
                }
            }
        });
    }

    public void toWizard(View view ) {
        Intent intent = new Intent(this, WizardTabsActivity.class);
        startActivity(intent);
    }

    public void toCharacterSheet(View view){
        Intent intent = new Intent(this, CharacterHomeActivity.class);
        startActivity(intent);
    }

    public void addCharacterName(String name){
        CharacterManager.getInstance(getAssets()).newCharacter().setName(name);
    }
}

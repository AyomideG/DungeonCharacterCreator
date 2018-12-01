package yeet.dungeonsomething.dungeoncharactercreator;

import android.content.res.AssetManager;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;

public class CharacterManager {
    private static CharacterManager instance;
    private ArrayList<Character> characterList;
    private AssetManager assetManager;

    public static CharacterManager getInstance(AssetManager assetManager){
        if(instance == null){
            instance = new CharacterManager(assetManager);
        }
        if(instance.assetManager == null)
            instance.SetAssetManager(assetManager);

        return instance;
    }

    private CharacterManager(AssetManager assetManager){
        characterList = new ArrayList<>();

        if(this.assetManager != null){
            this.assetManager = assetManager;
            //TBD should load files
        }

    }
    private void SetAssetManager(AssetManager assetManager){
        if(assetManager != null){
            this.assetManager = assetManager;
        }
    }

    public Character getCharacter(int i){
        if(i < 0 || i >= characterList.size())
            return null;
        return characterList.get(i);
    }

    public Character getCharacter(String name){
        for (Character c: characterList) {
            if(c.getName().compareToIgnoreCase(name) == 0)
                return c;
        }
        return null;
    }

    public Character newCharacter(){
        Character newCharacter = new Character();
        characterList.add(newCharacter);
        return newCharacter;
    }
    public Character newCharacter(Character newCharacter){
        characterList.add(newCharacter);
        Save();
        return newCharacter;
    }

    public void Save(){
        //persist them
    }
}

package yeet.dungeonsomething.dungeoncharactercreator;

import android.content.res.AssetManager;

import java.util.ArrayList;

import yeet.dungeonsomething.dungeoncharactercreator.Model.Character;

public class CharacterManager {
    private static CharacterManager instance;
    private ArrayList<Character> characterList;
    private AssetManager assetManager;
    private Character currentCharacter;

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

    /**
     * WIZARD SHOULD NOT USE THIS.
     * Selects the first character if one is not set already.
     *
     * @return the currently selected character
     */
    public Character getCharacter(){
        if(currentCharacter == null && characterList.size() > 0)
            currentCharacter = characterList.get(0);
        return currentCharacter;
    }

    public String[] getCharacterNames(){
        String[] names = new String[characterList.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = characterList.get(i).getName();
        }
        return names;
    }


    public Character getCharacter(int i){
        if(i < 0 || i >= characterList.size())
            return null;
        return characterList.get(i);
    }


    public Character getCharacter(String name){
        for (Character c: characterList) {
            if(c.getName().compareToIgnoreCase(name) == 0) {
                currentCharacter = c;
                return c;
            }
        }
        return null;
    }

    public Character newCharacter(){
        Character newCharacter = new Character();
        characterList.add(newCharacter);
        currentCharacter = newCharacter;
        return newCharacter;
    }
    public Character newCharacter(Character newCharacter){
        characterList.add(newCharacter);
        currentCharacter = newCharacter;
        Save();
        return newCharacter;
    }

    public void Save(){
        //persist them
    }
}

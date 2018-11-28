package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class APIResource implements Serializable {
    String name;
    String _class;
    String url;

    public String getIdentifier(){
        if(name != null)
            return name;
        return _class;
    }
}

package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Feature implements Serializable {
    String name;
    int level;
    String[] desc;
    APIResource _class;
    APIResource subclass;
    String url;
}

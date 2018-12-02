package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Proficiency implements Serializable {
    private String type;
    private String name;
    private APIResource[] classes;
    private APIResource[] races;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public APIResource[] getClasses() {
        return classes;
    }

    public void setClasses(APIResource[] classes) {
        this.classes = classes;
    }

    public APIResource[] getRaces() {
        return races;
    }

    public void setRaces(APIResource[] races) {
        this.races = races;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

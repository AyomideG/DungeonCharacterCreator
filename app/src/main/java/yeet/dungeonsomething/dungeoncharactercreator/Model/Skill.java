package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Skill implements Serializable {
    private String name;
    private String[] desc;
    private APIResource ability_score;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public APIResource getAbility_score() {
        return ability_score;
    }

    public void setAbility_score(APIResource ability_score) {
        this.ability_score = ability_score;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

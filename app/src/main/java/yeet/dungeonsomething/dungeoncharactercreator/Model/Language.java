package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Language implements Serializable {
    String name;
    String type;
    String[] typical_speakers;
    String script;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getTypical_speakers() {
        return typical_speakers;
    }

    public void setTypical_speakers(String[] typical_speakers) {
        this.typical_speakers = typical_speakers;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Feature implements Serializable {
    String name;
    int level;
    String[] desc;
    APIResource _class;
    APIResource subclass;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public APIResource get_class() {
        return _class;
    }

    public void set_class(APIResource _class) {
        this._class = _class;
    }

    public APIResource getSubclass() {
        return subclass;
    }

    public void setSubclass(APIResource subclass) {
        this.subclass = subclass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

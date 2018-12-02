package yeet.dungeonsomething.dungeoncharactercreator.Model;

import java.io.Serializable;

public class Note implements Serializable {
    String title;
    String content;

    public Note(final String title, final String content){
        this.content = content;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}

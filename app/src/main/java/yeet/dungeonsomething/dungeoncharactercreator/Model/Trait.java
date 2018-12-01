package yeet.dungeonsomething.dungeoncharactercreator.Model;

public class Trait {
    public APIResource[] getRaces() {
        return races;
    }

    public void setRaces(APIResource[] races) {
        this.races = races;
    }

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

    APIResource[] races;
    String name;
    String[] desc;
}

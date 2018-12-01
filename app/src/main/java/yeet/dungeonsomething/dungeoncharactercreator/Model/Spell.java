package yeet.dungeonsomething.dungeoncharactercreator.Model;

public class Spell {
    String name;
    String[] desc;
    String[] higher_level;
    String range;
    String[] components;
    String material;
    String ritual;
    String duration;
    String concentration;
    String casting_time;
    int level;
    APIResource school;
    APIResource[] classes;
    String url;

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

    public String[] getHigher_level() {
        return higher_level;
    }

    public void setHigher_level(String[] higher_level) {
        this.higher_level = higher_level;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String[] getComponents() {
        return components;
    }

    public void setComponents(String[] components) {
        this.components = components;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRitual() {
        return ritual;
    }

    public void setRitual(String ritual) {
        this.ritual = ritual;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getCasting_time() {
        return casting_time;
    }

    public void setCasting_time(String casting_time) {
        this.casting_time = casting_time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public APIResource getSchool() {
        return school;
    }

    public void setSchool(APIResource school) {
        this.school = school;
    }

    public APIResource[] getClasses() {
        return classes;
    }

    public void setClasses(APIResource[] classes) {
        this.classes = classes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

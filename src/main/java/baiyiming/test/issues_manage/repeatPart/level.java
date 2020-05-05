package baiyiming.test.issues_manage.repeatPart;

import java.util.logging.Level;

public enum level {
    Level1("致命缺陷",1,"red"),
    Level2("致命缺陷",2,"orange"),
    Level3("一般缺陷",3,"yellow"),
    Level4("值得关注的缺陷",4,"blue"),
    Level5("可以忽略的缺陷",5,"green");
    private String level;
    private int value;
    private String color;

    level(String level, int value, String color) {
        this.level = level;
        this.value = value;
        this.color = color;
    }
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
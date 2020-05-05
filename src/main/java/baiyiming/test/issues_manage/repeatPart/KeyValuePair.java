package baiyiming.test.issues_manage.repeatPart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyValuePair {
    @JsonProperty("name")
    String name;
    @JsonProperty("value")
    int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValuePair{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

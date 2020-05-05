package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class GetPercentage {
    @JsonProperty("pecentage")
    public ArrayList<List> pecentage;
    @JsonProperty("meta")
    public meta Meta;



    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }

    public ArrayList<List> getPecentage() {
        return pecentage;
    }

    public void setPecentage(ArrayList<List> pecentage) {
        this.pecentage = pecentage;
    }

    @Override
    public String
    toString() {
        return "GetPercentage{" +
                "pecentage=" + pecentage +
                ", Meta=" + Meta +
                '}';
    }
}

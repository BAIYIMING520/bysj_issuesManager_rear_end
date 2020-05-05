package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.repeatPart.dataUnit;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class totalAnalysis {
    @JsonProperty("dataList")
    public ArrayList<dataUnit> dataList;
    @JsonProperty("typeNames")
    public ArrayList<String> typeNames;
    @JsonProperty("meta")
    public meta Meta;

    public ArrayList<dataUnit> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<dataUnit> dataList) {
        this.dataList = dataList;
    }

    public ArrayList<String> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(ArrayList<String> typeNames) {
        this.typeNames = typeNames;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

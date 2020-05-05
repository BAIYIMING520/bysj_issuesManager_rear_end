package baiyiming.test.issues_manage.dto;
import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GetTag {
    //这里是 返回的内容是
    @JsonProperty("TagList")
    public List<tag> tagList;
    @JsonProperty("meta")
    public meta Meta;

    public List<tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<tag> tagList) {
        this.tagList = tagList;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

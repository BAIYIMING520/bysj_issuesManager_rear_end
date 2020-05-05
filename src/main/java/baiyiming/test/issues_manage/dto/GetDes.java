package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class GetDes {
    @JsonProperty("des")
    public Page<description> descriptionSet;
    @JsonProperty("meta")
    public meta Meta;

    public Page<description> getDescriptionSet() {
        return descriptionSet;
    }

    public void setDescriptionSet(Page<description> descriptionSet) {
        this.descriptionSet = descriptionSet;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

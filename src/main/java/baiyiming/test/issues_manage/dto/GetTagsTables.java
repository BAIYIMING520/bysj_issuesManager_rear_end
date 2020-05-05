package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.entity.tables;
import baiyiming.test.issues_manage.entity.tag;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class GetTagsTables {
    @JsonProperty("tags")
    Page<tag> tags;
    @JsonProperty("meta")
    meta Meta;

    public Page<tag> getTags() {
        return tags;
    }

    public void setTags(Page<tag> tags) {
        this.tags = tags;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

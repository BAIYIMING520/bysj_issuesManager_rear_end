package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.entity.data;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

public class GetTablesToIssues {
    @JsonProperty("issueData")
    Page<data> dataArray;
    @JsonProperty("meta")
    meta meta;

    public Page<data> getDataArray() {
        return dataArray;
    }

    public void setDataArray(Page<data> dataArray) {
        this.dataArray = dataArray;
    }

    public baiyiming.test.issues_manage.repeatPart.meta getMeta() {
        return meta;
    }

    public void setMeta(baiyiming.test.issues_manage.repeatPart.meta meta) {
        this.meta = meta;
    }
}

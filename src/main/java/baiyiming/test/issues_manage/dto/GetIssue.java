package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetIssue {
    //三部分显示 这了准备写成发送三个帧 这样是否会写的快一点
    @JsonProperty("issue")
    public data issue;
    @JsonProperty("meta")
    public meta Meta;

    public data getIssue() {
        return issue;
    }

    public void setIssue(data issue) {
        this.issue = issue;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

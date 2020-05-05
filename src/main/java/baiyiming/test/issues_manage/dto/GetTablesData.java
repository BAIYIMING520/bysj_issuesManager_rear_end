package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.entity.tables;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public class GetTablesData {
    //这里是用来返回 第一个数据列表生成的
    @JsonProperty("tables")
    Page<tables> Tables;
    @JsonProperty("meta")
    meta Meta;

    public Page<tables> getTables() {
        return Tables;
    }

    public void setTables(Page<tables> tables) {
        Tables = tables;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

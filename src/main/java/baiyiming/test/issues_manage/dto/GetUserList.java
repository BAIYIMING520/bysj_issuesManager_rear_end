package baiyiming.test.issues_manage.dto;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GetUserList {
    @JsonProperty("userList")
    ArrayList<user> userList;
    @JsonProperty("meta")
    meta Meta;

    public ArrayList<user> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<user> userList) {
        this.userList = userList;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

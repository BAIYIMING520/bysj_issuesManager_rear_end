package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GetUserMessage {
    @JsonProperty("messageList")
    public ArrayList<List> messageList;
    @JsonProperty("meta")
    public meta Meta;

    public ArrayList<List> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<List> messageList) {
        this.messageList = messageList;
    }

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }
}

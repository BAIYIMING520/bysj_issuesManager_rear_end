package baiyiming.test.issues_manage.dto;

import baiyiming.test.issues_manage.repeatPart.meta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class GetRecentUser {
    @JsonProperty("meta")
    public meta Meta;
    @JsonProperty("thisUser")
    public Date date;
    @JsonProperty("recentUser")
    public int recentUser;
    @JsonProperty("pageNum")
    public int pageNum;

    public meta getMeta() {
        return Meta;
    }

    public void setMeta(meta meta) {
        Meta = meta;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRecentUser() {
        return recentUser;
    }

    public void setRecentUser(int recentUser) {
        this.recentUser = recentUser;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "GetRecentUser{" +
                "Meta=" + Meta +
                ", date=" + date +
                ", recentUser=" + recentUser +
                ", pageNum=" + pageNum +
                '}';
    }
}

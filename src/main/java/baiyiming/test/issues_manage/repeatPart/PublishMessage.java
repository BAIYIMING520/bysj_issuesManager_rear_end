package baiyiming.test.issues_manage.repeatPart;

import java.sql.Date;

public class PublishMessage {
    public String messageDes;
    public Date date1;
    public Date date2;
    public String type;
    public int userId;

    public String getMessageDes() {
        return messageDes;
    }

    public void setMessageDes(String messageDes) {
        this.messageDes = messageDes;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PublishMessage{" +
                "messageDes='" + messageDes + '\'' +
                ", date1=" + date1 +
                ", date2=" + date2 +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }
}

package baiyiming.test.issues_manage.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "message")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="messageId")
    private int messageId;
    @Column(nullable = false,name="date")
    private java.sql.Date date;
    @Column(nullable = false,name="messageDes")
    private String messageDes;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getMessageDes() {
        return messageDes;
    }

    public void setMessageDes(String messageDes) {
        this.messageDes = messageDes;
    }

    @Override
    public String toString() {
        return "message{" +
                "messageId=" + messageId +
                ", date=" + date +
                ", messageDes='" + messageDes + '\'' +
                '}';
    }
}

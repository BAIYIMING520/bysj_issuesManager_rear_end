package baiyiming.test.issues_manage.entity;

import javax.persistence.*;

@Entity
@Table(name = "usermessage")
public class usermessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "umId")
    private int umId;
    @Column(nullable = false,name = "userId")
    private int userId;
    @Column(nullable = false,name = "messageId")
    private int messageId;
    @Column(nullable = false,name = "status")// 这里不用bool 使用 0 / 1 表示
    private int status;

    public int getUmId() {
        return umId;
    }

    public void setUmId(int umId) {
        this.umId = umId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "usermessage{" +
                "umId=" + umId +
                ", userId=" + userId +
                ", messageId=" + messageId +
                ", status=" + status +
                '}';
    }
}

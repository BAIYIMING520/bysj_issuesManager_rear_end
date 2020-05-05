package baiyiming.test.issues_manage.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "description")
public class description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "decriptionId")
    private int decriptionId;
    @Column(nullable = false,name = "dataId")
    private int dataId;
    @Column(nullable = false,name = "userId")
    private int userId;
    @Lob
//    @Basic(fetch=FetchType.LAZY)
    @Column(nullable = false,name = "description")
    private String description;
    @Column(nullable = false,name = "date")
    private java.sql.Date date;
    @Column(nullable = false,name = "agree")
    private int agree;

    public int getDecriptionId() {
        return decriptionId;
    }

    public void setDecriptionId(int decriptionId) {
        this.decriptionId = decriptionId;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    @Override
    public String toString() {
        return "description{" +
                "decriptionId=" + decriptionId +
                ", dataId=" + dataId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", agree=" + agree +
                '}';
    }
}



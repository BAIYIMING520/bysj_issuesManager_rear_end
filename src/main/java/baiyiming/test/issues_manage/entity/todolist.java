package baiyiming.test.issues_manage.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "toDoList")
public class todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "toDoListId")
    private int toDoListId;
    @Lob
    @Column(nullable = false,name = "toDoListDes") //这里需要描述比较大的标签
    private String toDoListDes;
    @Column(nullable = false,name = "toDoListType") //这里写的是按照时间
    private String toDoListType;
    @Column(nullable = false,name = "userId")
    private int userId;
    @Column(nullable = false,name = "maxTime")
    private  java.sql.Date maxTime;

    public int getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(int toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getToDoListDes() {
        return toDoListDes;
    }

    public void setToDoListDes(String toDoListDes) {
        this.toDoListDes = toDoListDes;
    }

    public String getToDoListType() {
        return toDoListType;
    }

    public void setToDoListType(String toDoListType) {
        this.toDoListType = toDoListType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public String toString() {
        return "todolist{" +
                "toDoListId=" + toDoListId +
                ", toDoListDes='" + toDoListDes + '\'' +
                ", toDoListType='" + toDoListType + '\'' +
                ", userId=" + userId +
                ", maxTime=" + maxTime +
                '}';
    }
}

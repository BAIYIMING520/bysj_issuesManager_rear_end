package baiyiming.test.issues_manage.entity;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "userId")
    private int userId;
    @Column(nullable = false,name = "userName")
    private String username;
    @Column(nullable = false,name = "userPassword")
    private String userpassword;
    @Column(nullable = false,name = "authority")
    private String authority;
    @Column(nullable = false,name = "tablesId")
    private int tablesId;
    @Column(nullable = false,name = "recentLoginTime")
    private java.sql.Date recentLoginTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getRecentLoginTime() {
        return recentLoginTime;
    }

    public void setRecentLoginTime(Date recentLoginTime) {
        this.recentLoginTime = recentLoginTime;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", authority='" + authority + '\'' +
                ", tablesId=" + tablesId +
                ", recentLoginTime=" + recentLoginTime +
                '}';
    }
}

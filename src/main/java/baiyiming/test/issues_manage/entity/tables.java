package baiyiming.test.issues_manage.entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tables")
public class tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "tablesId")
    private int tablesId ;
    @Column(nullable = false,name ="tablesName")
    private String tablesName;
    @Column(nullable = false,name = "builder")
    private String builder;
    @Column(nullable = false,name = "date")
    private java.sql.Date date;

    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public String getTablesName() {
        return tablesName;
    }

    public void setTablesName(String tablesName) {
        this.tablesName = tablesName;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "table{" +
                "tableId=" + tablesId +
                ", tableName='" + tablesName + '\'' +
                ", builder='" + builder + '\'' +
                ", date=" + date +
                '}';
    }
}

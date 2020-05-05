package baiyiming.test.issues_manage.entity;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "data")
public class data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="dataId")
    private int dataId;
    @Column(nullable = false,name="type")
    private String type;
    @Lob
//    @Basic(fetch=FetchType.LAZY)
    @Column(nullable = false,name="title")
    private String title;
    @Lob
//    @Basic(fetch=FetchType.LAZY)
    @Column(nullable = false,name="body")
    private String body;
    @Column(nullable = true,name="assignee")
    private String assignee;
    @Column(nullable = true,name="reporter")
    private String reporter;
    @Column(nullable = false,name="priority")
    private String priority;
    @Column(nullable = false,name="status")
    private String status;
    @Column(nullable = true,name="resolution")
    private String resolution;
    @Column(nullable = false,name="created")
    private java.sql.Date created;
    @Column(nullable = false,name="updated")
    private java.sql.Date updated;
    @Column(nullable = false,name = "tablesId")
    private int tablesId ;
    @Column(nullable = false,name = "tagId")
    private int tagId ;


    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "data{" +
                "dataId=" + dataId +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", assignee='" + assignee + '\'' +
                ", reporter='" + reporter + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", resolution='" + resolution + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", tablesId=" + tablesId +
                ", tagId=" + tagId +
                '}';
    }
}

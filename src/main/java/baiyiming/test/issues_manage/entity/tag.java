package baiyiming.test.issues_manage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tag")
public class tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "")
    @JsonProperty("tagId")
    private int tagId;
    @Column(nullable = false,name = "tagName")
    @JsonProperty("tagName")
    private String tagName;
    @Lob
//    @Basic(fetch=FetchType.LAZY)
    @Column(nullable = false,name = "description")
    @JsonProperty("description")
    private String description;
    @Column(nullable = false,name = "color")
    @JsonProperty("color")
    private int color;
    @Column(nullable = false,name = "date")
    @JsonProperty("date")
    private java.sql.Date date;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", description='" + description + '\'' +
                ", color=" + color +
                ", date=" + date +
                '}';
    }
}




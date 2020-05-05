package baiyiming.test.issues_manage.repeatPart;

import baiyiming.test.issues_manage.entity.tag;


import java.util.Date;

public class getNewTag {
    public String date1;
    public Date date2;
    public String name;
    public int radioColor;
    public String content;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRadioColor() {
        return radioColor;
    }

    public void setRadioColor(int radioColor) {
        this.radioColor = radioColor;
    }

    public tag changeToNewTag(){
        tag temple= new tag();
        temple.setColor(this.radioColor);
        temple.setDescription(this.content);
        //这里牵扯到转换的问题 先测试前端返回数据
        temple.setTagName(this.name);
        //时间转换 然后写到数据
        temple.setDate(new java.sql.Date(this.date2.getTime()));
        //java.sql.Date
        return temple;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    @Override
    public String toString() {
        return "getNewTag{" +
                "date1='" + date1 + '\'' +
                ", date2=" + date2 +
                ", name='" + name + '\'' +
                ", radioColor=" + radioColor +
                ", content='" + content + '\'' +
                '}';
    }
}

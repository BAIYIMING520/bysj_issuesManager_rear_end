package baiyiming.test.issues_manage.repeatPart;

import java.lang.reflect.Field;

public class T2I {
    public int tablesId;
    public String Type;
    public String Priority;
    public String Status;
    public String title;
    public int getTablesId() {
        return tablesId;
    }

    public void setTablesId(int tablesId) {
        this.tablesId = tablesId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int[] Check_null(){
        int[] temp= {1,0,0,0,0};
        //这里使用反射机制来测试其中是参数是否是空str
        Field[] varibleList=this.getClass().getFields();
        int counter=0;
        try {
            for(Field f: varibleList)//这里长度和temp长度是相同的
            {
                if(f.get(this).toString().equals(""))
                {
                    temp[counter]=0;
                }
                else
                {
                    temp[counter]=1;
                }
                counter++;
            }
        }
        catch (Exception e){
            System.out.println("error : getFiled with error!");
        }
        return temp;
    }

    @Override
    public String toString() {
        return "T2I{" +
                "tablesId=" + tablesId +
                ", Type='" + Type + '\'' +
                ", Priority='" + Priority + '\'' +
                ", Status='" + Status + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

package baiyiming.test.issues_manage.TestClass;

public class TestJson {
    public int para1;
    public String para2;


    public int getPara1() {
        return para1;
    }

    public void setPara1(int para1) {
        this.para1 = para1;
    }

    public String getPara2() {
        return para2;
    }

    public void setPara2(String para2) {
        this.para2 = para2;
    }

    @Override
    public String toString() {
        return "TestJson{" +
                "para1=" + para1 +
                ", para2='" + para2 + '\'' +
                '}';
    }
}

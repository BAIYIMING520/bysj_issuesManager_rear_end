package baiyiming.test.issues_manage.TestClass;
import baiyiming.test.issues_manage.repeatPart.T2I;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.util.HashMap;

public class testCode {
    public String[] templedata1;
    public String[] templedata2;
    public HashMap<String,String> dataProperty=new HashMap<String,String>();
    public testCode(){
        this.templedata1=new String[]{"str2","str3","str1"};
        this.templedata2=new String[]{"Type","Priority","Status"};
    }
    public void TestFunc(){
        testCode testImp=new testCode();
        for (int i=0;i<testImp.templedata2.length;i++)
        {
            testImp.dataProperty.put(testImp.templedata2[i],testImp.templedata1[i]);//放入参数
        }

    }
    public void TestFunc2(){
        String tem=new String("{\"tablesId\":16,\"Type\":\"\",\"Priority\":\"\",\"Status\":\"\",\"title\":\"\"}");
        T2I temple = JSONObject.parseObject(tem,T2I.class);
        try {
//            Class c=Class.forName(T2I.class.getName());
//            Field[] templeDataImp=c.getFields();
//            for(Field f: templeDataImp)
//            {
//                System.out.println(f.getType().getSimpleName()+f.getName());
//            }
            Field[] variableOfT2I = temple.getClass().getFields();
            for(Field iter: variableOfT2I)
            {
                System.out.println(iter.get(temple).toString());
            }
        }
        catch (Exception e)
        {
            System.out.println(" error : cast class name to create class failed! ");
        }
    }
    public static void main(String[] args) {
        testCode test=new testCode();
        test.TestFunc2();
    }

}

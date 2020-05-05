package baiyiming.test.issues_manage;

import baiyiming.test.issues_manage.dto.GetUserList;
import baiyiming.test.issues_manage.dto.GetUserMessage;
import baiyiming.test.issues_manage.dto.totalAnalysis;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.repeatPart.KeyValuePair;
import baiyiming.test.issues_manage.repeatPart.dataUnit;
import baiyiming.test.issues_manage.service.GetAnalysisServiceImp;
import baiyiming.test.issues_manage.service.GetDateServicImp;
import baiyiming.test.issues_manage.service.SaveDateServicImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    GetDateServicImp GetDateService;
    @Autowired
    SaveDateServicImp SaveDateService;
    @Autowired
    GetAnalysisServiceImp GetAnalysisService;
    @Test
    public void TestUserList(){
        System.out.println("--------------------Test---------GetUserList--------------Start");
        GetUserList testTemple=this.GetDateService.GetUserListFunc();
        for(user iter:testTemple.getUserList()){
            System.out.println(iter);
        }
        System.out.println("--------------------Test---------GetUserList---------------End");
    }
    @Test
    public void TestMessage(){
        System.out.println("--------------------Test---------GetUserMessage--------------Start");
        GetUserMessage message=this.GetDateService.GetUserMessageFunc(1);
        for(List iter:message.getMessageList()){
            System.out.println(iter);
        }
        System.out.println("--------------------Test---------GetUserMessage--------------End");
    }
    @Test
    public void TestStatusChange(){
        System.out.println("--------------------Test---------savechange--------------Start");
        SaveDateService.setReadMessage(1);
        System.out.println("--------------------Test---------savechange--------------End");
    }
    @Test
    public void TestAnalysis(){
        totalAnalysis temp=GetAnalysisService.Gettotal("priority");

        ArrayList<String> TypeNames= temp.getTypeNames();
        ArrayList<dataUnit>DataList =temp.getDataList();

        for(int i=0;i<TypeNames.size();i++){
            System.out.println(TypeNames.get(i));
        }
        for(dataUnit iter:DataList){
            System.out.println(iter.getTablesId());
            System.out.println(iter.getTablesName());
            System.out.println(iter.getTotal());
            for(KeyValuePair iter2:iter.getKVarray())
            {
                System.out.println(iter2.getName());
                System.out.println(iter2.getValue());
            }
        }

    }//测试通过
}

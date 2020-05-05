package baiyiming.test.issues_manage;
import baiyiming.test.issues_manage.dto.GetPercentage;
import baiyiming.test.issues_manage.dto.GetRecentUser;
import baiyiming.test.issues_manage.dto.totalAnalysis;
import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.KeyValuePair;
import baiyiming.test.issues_manage.repeatPart.Percentage;
import baiyiming.test.issues_manage.repeatPart.dataUnit;
import baiyiming.test.issues_manage.repeatPart.meta;
import baiyiming.test.issues_manage.repository.*;
import baiyiming.test.issues_manage.service.GetDateServicImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoTest {
    @Autowired
    dataRepo dataRepoImp;
    @Autowired
    descriptionRepo descriptionRepoImp;
    @Autowired
    tablesRepo tablesRepoImp;
    @Autowired
    tagRepo tagRepoImp;
    @Autowired
    userRepo userRepoImp;
    @Autowired
    GetDateServicImp GetData;
    @Test
    public void TestRepoImp(){
        //首先测试data 数据仓库 之后就是测试api函数 这里需要设计api
//        ArrayList<description> mytest =descriptionRepoImp.findByDataIdAndUserId(1,1);
//        System.out.println(mytest.size()+mytest.toString());
//        ArrayList<data> mytest2=dataRepoImp.findByTablesIdAndTagIdAndType(10,2,Type.Improvement.getType());
//        int count=0;
//        for (data i : mytest2)
//        {
//            count++;
//            System.out.println(i.toString());
//        }
//        System.out.println("total:"+count);
       Pageable pageable= PageRequest.of(0,8, Sort.by(Sort.Direction.ASC,"dataId"));
       //这里测试多条件查询
       data test=new data();
       test.setTablesId(15);
       test.setType("Improvement");
       test.setPriority("Minor");
       test.setStatus("Resolved");
       test.setTitle("");
       Page<data> temple=dataRepoImp.findOption(test.getTablesId(),test.getType(),test.getPriority(),
               test.getStatus(),test.getTitle(),pageable);
       for(data iter:temple){
           System.out.println(iter.toString());
       }//测试成功 可以完成正常的多限制查询
    }
    //repo的测试通过 接下来就是api的使用 返回的是json字符串
    @Test
    public void TestSaveRepo()
    {
        tables temple=tablesRepoImp.findByTablesId(16);
        temple.setBuilder(temple.getBuilder()+"1");
        tablesRepoImp.save(temple);
    }
    @Test
    public void TestQuery_des_And_username()
    {
        Pageable pageable=PageRequest.of(0,8,Sort.by(Sort.Direction.DESC,"decriptionId"));
        Page<List> temple = this.descriptionRepoImp.findByfindByDataIdWithUserName(1,pageable);

        for(List iter:temple){
            System.out.println(iter.toString());
        }

//        Field[] FtempleList=temple.get(0).getClass().getFields();
//        for ( Field iter: FtempleList){
//            System.out.println(iter);
//        }
        //测试list是否可以不声明模板
//        ArrayList temple2= new ArrayList<>(10);
//        Integer a=20;
//        String t1=new String("123");
//        Object t2=new Object();
//        temple2.add(a);
//        temple2.add(t1);
//        temple2.add(t2);
//        for (Object iter:temple2){ //这类告诉我们虽然是obeject对象 依旧派生类的 field中的参数对象
//            Field[] templeList=iter.getClass().getFields();
//            for( Field iter2:templeList){
//                System.out.println(iter2.toString());
//            }
//        }
    }
    @Test
    public void TestQuery_complex_unachievePercentage(){
        Pageable pageable=PageRequest.of(0,4,Sort.Direction.DESC,"tablesId"); //这里绑定的
        ArrayList<List> temple = this.dataRepoImp.findPercentage();
        for(List iter:temple){
            System.out.println(iter.toString());
        }
    }
    @Test
    public void TestQuery_RecentUser(){
        GetRecentUser TestAns = GetData.GetRecentUserFunc(7);
        System.out.println(TestAns.toString());
    }
    @Test
    public void TestAnalysis(){
        ArrayList<List> data=this.dataRepoImp.findCountBytype(16);
        for(List iter:data){
            System.out.println(iter.toString());
        }
    }
    @Test
    public void TestTagAnalysis(){
        ArrayList<List>data =this.dataRepoImp.findCountBytag(16);
        for (List iter:data){
            System.out.println(iter.toString());
        }
    }
    @Test
    public void TestNameType(){
        totalAnalysis temple=new totalAnalysis();
        temple.setTypeNames(this.dataRepoImp.getNameDataByType());//测试使用type来完成
        temple.setMeta(new meta());
        temple.setDataList(new ArrayList<dataUnit>());
        ArrayList<List>tempNameArray=this.dataRepoImp.getTotalCountByTablesId();//返回tablesId | tablesName | num
        //在下一步中获得试用多次迭代来获取数据进行数据组装
        for(List iter:tempNameArray){
            dataUnit test=new dataUnit();
            Integer t_id = (Integer)(iter.get(0));//id都是int 但是数字都是bigint
            test.setTablesId(t_id);
            test.setTablesName((String)iter.get(1));
            t_id = ((BigInteger)iter.get(2)).intValue();//完成转换后计数
            test.setTotal(t_id);
            test.setKVarray(new ArrayList<KeyValuePair>());
            ArrayList<List> tempDateArray=this.dataRepoImp.getTableCountByType();//tablesId | type | count(*) 单元数据集合 用于改变集合参数
            SearchUnit(test.getKVarray(),"type",test.getTablesId(),tempDateArray);
            temple.getDataList().add(test);
        }
        //测试一下第一个的数据是否是对的
//
//        for(dataUnit iter: temple.getDataList()){
//            System.out.println("tablesId: "+iter.getTablesId());
//            System.out.println(("TablesName:"+iter.getTablesName()));
//            System.out.println("total: "+iter.getTotal());
//            for(KeyValuePair iter2:iter.getKVarray()){
//                System.out.println("array: "+iter2.toString());
//            }
//        }
    }
    public void SearchUnit(ArrayList<KeyValuePair> ArList,String type,int tablesId,ArrayList<List> tempDateArray){
        //type是筛选条件
        for(List iter:tempDateArray){
            Integer temp_id = (Integer)iter.get(0);//tablesId | type | count(*)
            if(temp_id==tablesId){
                KeyValuePair temple = new KeyValuePair();
                temple.setName((String) iter.get(1));
                temp_id = ((BigInteger) iter.get(2)).intValue();
                temple.setValue(temp_id);
                ArList.add(temple);
            }
        }
    }
    @Test
    public void TesttotalAnalysis(){

    }
}

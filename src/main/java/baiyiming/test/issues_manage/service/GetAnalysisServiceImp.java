package baiyiming.test.issues_manage.service;

import baiyiming.test.issues_manage.dto.totalAnalysis;
import baiyiming.test.issues_manage.repeatPart.KeyValuePair;
import baiyiming.test.issues_manage.repeatPart.dataUnit;
import baiyiming.test.issues_manage.repeatPart.meta;
import baiyiming.test.issues_manage.repeatPart.queryform;
import baiyiming.test.issues_manage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAnalysisServiceImp {
    @Autowired
    private dataRepo dataRepoImp;
    @Autowired
    private tablesRepo tablesRepoImp;
    @Autowired
    private tagRepo tagRepoImp;
    public ArrayList<KeyValuePair> GetAnalysisByDefault(queryform temple){
        //需要找一种方法返回不同的参数设定
        //Improvement     Sub-task      Bug       Task      New Feature
        ArrayList<List> data=new ArrayList<>();
        switch (temple.getSelectOption())
        {
            case "type":
                data=this.dataRepoImp.findCountBytype(temple.getTablesId());
                break;
            case "priority":
                data=this.dataRepoImp.findCountBypriority(temple.getTablesId());
                break;
            case "status":
                data=this.dataRepoImp.findCountBystatuse(temple.getTablesId());
                break;
            case "tag":
                data=this.dataRepoImp.findCountBytag(temple.getTablesId());
                break;
        }
        ArrayList<KeyValuePair> ans= new ArrayList<KeyValuePair>();
        for (List iter:data){
            KeyValuePair templeKV=new KeyValuePair();
            templeKV.setName((String)iter.get(0));
            Integer t = ((BigInteger) iter.get(1)).intValue();
            templeKV.setValue(t);
            ans.add(templeKV);
        }
        return ans;
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
    public totalAnalysis Gettotal(String type){
        //这里传入的参数是整个数据库中的使用的类型状态 比如是type

        //这里要获取所有的
        totalAnalysis temple=new totalAnalysis();
        temple.setMeta(new meta());
        ArrayList<List> tempDateArray=new ArrayList<List>();//tablesId | type | count(*) 单元数据集合 用于改变集合参数
        // type ---> priority ---> status
        if(type.equals("type")){
            temple.setTypeNames(this.dataRepoImp.getNameDataByType());//这里可以使用不同的type进行case语句
            tempDateArray=this.dataRepoImp.getTableCountByType();
        }else if(type.equals("priority")){
            temple.setTypeNames(this.dataRepoImp.getNameDataByPriority());//这里可以使用不同的type进行case语句
            tempDateArray=this.dataRepoImp.getTableCountByPriority();
        }else if(type.equals("status")){
            temple.setTypeNames(this.dataRepoImp.getNameDataByStatus());//这里可以使用不同的type进行case语句
            tempDateArray=this.dataRepoImp.getTableCountByStatus();
        }else if(type.equals("tag")){
            temple.setTypeNames(this.tagRepoImp.getall());
            tempDateArray=this.dataRepoImp.getTableCountByTagId();
        }
        if(temple.getTypeNames()==null){
            System.out.println("前端传入参数type类型不在范围内");
            return temple;
        }
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
            SearchUnit(test.getKVarray(),type,test.getTablesId(),tempDateArray);
            temple.getDataList().add(test);
        }
        return temple;
    }
}

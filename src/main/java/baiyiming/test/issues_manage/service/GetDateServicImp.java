package baiyiming.test.issues_manage.service;

import baiyiming.test.issues_manage.dto.*;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.repeatPart.T2I;
import baiyiming.test.issues_manage.repeatPart.meta;
import baiyiming.test.issues_manage.repeatPart.queryInfo;
import baiyiming.test.issues_manage.repository.*;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GetDateServicImp {
    @Autowired
    private dataRepo dataRepoImp;
    @Autowired
    private descriptionRepo descriptionRepoImp;
    @Autowired
    private tablesRepo tablesRepoImp;
    @Autowired
    private  tagRepo tagRepoImp;
    @Autowired
    private  userRepo  userRepoImp;
    @Autowired
    private usermessageRepo usermessageRepoImp;
    @Autowired
    private messageRepo messageRepoImp;
    //这里参数是指tableToIssue中的参数
    public GetTablesData GetTablesDatePara(queryInfo para){
        //这个函数直接返回dto转换成json组直接被读取 然后在这个 GetTablesDate 主要有2中类型数据 一个是data数据一个是 meta数据 用于获取状态
        GetTablesData tablesTemple=new GetTablesData();
        //这里需要使用返回page的参数
        //这里对前端的查询的数据分割
        String[] paraList=para.querypara.split(" ");
        Pageable pageable= PageRequest.of(para.pageIndex-1,para.pageSize,Sort.by(Sort.Direction.ASC,paraList[0]));
        if(paraList.length<2){//说明没有第二个参数
            tablesTemple.setTables(this.tablesRepoImp.findAll(pageable));
            //没有参数全返回
        }
        else {
            switch (paraList[0])
            {
                case "tablesName":
                    tablesTemple.setTables(this.tablesRepoImp.findByTablesName(pageable,paraList[1]));
                    break;
                case "builder":
                    tablesTemple.setTables(this.tablesRepoImp.findByBuilder(pageable,paraList[1]));
                    break;
                case "tablesId":
                    int temple=1;
                    int flag=0;
                    try {
                        temple=Integer.parseInt(paraList[1]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("tableid无法转换成int 属于非可以转换字符串类型");
                        flag=1;
                    }
                    if(flag==0)
                    {
                        tablesTemple.setTables(this.tablesRepoImp.findByTablesId(pageable,temple));
                    }else {
                        tablesTemple.setTables(this.tablesRepoImp.findAll(pageable));
                    }
                    break;
            }
        }
        meta metatemple=new meta();
        tablesTemple.setMeta(metatemple);
        return tablesTemple;
    }


    public GetTablesToIssues GetTablesToIssuesFunc(queryInfo para){
        GetTablesToIssues data_temple=new GetTablesToIssues();
        //前端的传输数据是一个string方式的json字符串 规定obj类
        //前端传入的参数是 1.Type 2.Priority 3.Status 4.name 使用json字符串来 进行query查询 如果有选择的情况下就来查询这里 建议使用使用分割一下
        //split分割以后 这里测试一下如果传入的某一个是空值是什么情况 默认参数是4
        try{
            T2I tableToissue=JSONObject.parseObject(para.getQuerypara(),T2I.class);//转换成功
            System.out.println(para.toString());
            int para_is_null=4;
            //测试其中的变量是否为空 tablesId Type Priority Status title
            int[] check=tableToissue.Check_null();//接受到了前端传来的参数验证
            for(int i :check) {
                if(i==1){
                    para_is_null--;
                }
            }//这里可以直接完成多参数查询 甚至可以使用多状态查询 可以设计自己想要的多条件查询参数 优化if else操作
            Pageable pageable= PageRequest.of(para.pageIndex-1,para.pageSize,Sort.by(Sort.Direction.ASC,"dataId"));
            data_temple.setDataArray(dataRepoImp.findOption(tableToissue.tablesId,tableToissue.Type,tableToissue.Priority,tableToissue.Status,tableToissue.title,pageable));
            data_temple.setMeta(new meta());
        }catch (JSONException e){
            JSONObject t =JSONObject.parseObject(para.getQuerypara());
        }
        catch (Exception e){
            System.out.println("error");
        }
        return data_temple;
    }

    public GetIssue GetIsssueFunc(int dataId ){
        GetIssue ans =new GetIssue();
        ans.setIssue(this.dataRepoImp.findByDataId(dataId));
        ans.setMeta(new meta());
        return ans;
    }

    public GetTag GetTagFunc(){
        GetTag ans=new GetTag();//这里的数据类型
        ans.setTagList(this.tagRepoImp.findAll());
        ans.setMeta(new meta());
        return ans;
    }

    public GetDes GetDesFunc(queryInfo para){
        GetDes ans=new GetDes();
        ans.setMeta(new meta());
        Pageable pageable= PageRequest.of(para.pageIndex-1,para.pageSize,Sort.by(Sort.Direction.DESC,"decriptionId"));
        ans.setDescriptionSet(this.descriptionRepoImp.findByDataId(pageable,Integer.parseInt(para.querypara)));
        return ans;
    }

    public GetUserNameAndDes GetUserNameAndDesFunc(queryInfo para){
        GetUserNameAndDes ans = new GetUserNameAndDes();
        ans.setMeta(new meta());
        System.out.println(para.toString());
        Pageable pageable=PageRequest.of(para.pageIndex-1,para.pageSize,Sort.by(Sort.Direction.DESC,"decriptionId"));
        ans.setuNameADes(this.descriptionRepoImp.findByfindByDataIdWithUserName(Integer.parseInt(para.querypara),pageable));
        Page<List> temple = this.descriptionRepoImp.findByfindByDataIdWithUserName(Integer.parseInt(para.querypara),pageable);;
        for(List iter:temple){
            System.out.println(iter.toString());
        }
        return ans;
    }
    public GetPercentage GetPercentageFunc(){
        GetPercentage ans=new GetPercentage();
        ans.setMeta(new meta());
        ans.setPecentage(this.dataRepoImp.findPercentage());
        return ans;
    }
    public GetRecentUser GetRecentUserFunc(int userId){
        GetRecentUser ans=new GetRecentUser();
        ans.setMeta(new meta());
        user userTemple = this.userRepoImp.findByUserId(userId);
        ans.setDate(userTemple.getRecentLoginTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-7);//返回一个星期前的时间参数
        Date time = calendar.getTime();
        java.sql.Date ansDate=new java.sql.Date(time.getTime());
        ans.setRecentUser(userRepoImp.findRecentUserNumber(ansDate));
        ans.setPageNum(tablesRepoImp.getDistinctWithTable());
        return ans;
    }
    public  GetTagsTables GetTagsTablesFunc(queryInfo para){
        GetTagsTables ans=new  GetTagsTables();
        String[] paraList=para.querypara.split(" ");
        Pageable pageable= PageRequest.of(para.pageIndex-1,para.pageSize,Sort.by(Sort.Direction.ASC,"tagId"));
        if(paraList.length<1){
            ans.setTags(this.tagRepoImp.findAllQuery(pageable));
        }else if(paraList.length == 1){
            if(paraList[0].equals(""))
            {
                ans.setTags(this.tagRepoImp.findAllQuery(pageable));
            }else {
                try {
                    int colorId= Integer.parseInt(paraList[0]);
                    ans.setTags(this.tagRepoImp.findByColor(pageable,colorId));
                }
                catch (Exception e){
                    ans.setTags(this.tagRepoImp.findByTagName(pageable,paraList[0]));
                }
            }
        }else {
            ans.setTags(this.tagRepoImp.findByTagNameAndColor(pageable,paraList[0],Integer.parseInt(paraList[1])));
        }
        ans.setMeta(new meta());
        return ans;
    }

    //-----------------Message---------------------GetUserList ---->   GetUserMessageFunc
    public GetUserList GetUserListFunc(){
        GetUserList temple=new GetUserList();
        temple.setMeta(new meta());
        temple.setUserList(this.userRepoImp.findAll());
        return  temple;
    }
    public GetUserMessage GetUserMessageFunc(int userId){
        //这里需要完成一次连表操作
        GetUserMessage temple=new GetUserMessage();
        temple.setMeta(new meta());
        temple.setMessageList(this.messageRepoImp.findAllUnreadMessage(userId));
        return temple;
    }
}

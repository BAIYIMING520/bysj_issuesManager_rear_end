package baiyiming.test.issues_manage.service;
import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.PublishMessage;
import baiyiming.test.issues_manage.repeatPart.getNewTag;
import baiyiming.test.issues_manage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service

public class SaveDateServicImp {
    @Autowired
    private dataRepo dataRepoImp;
    @Autowired
    private descriptionRepo descriptionRepoImp;
    @Autowired
    private tablesRepo tablesRepoImp;
    @Autowired
    private tagRepo tagRepoImp;
    @Autowired
    private userRepo userRepoImp;
    @Autowired
    private usermessageRepo usermessageRepoImp;
    @Autowired
    private messageRepo messageRepoImp;
    public void SaveTable(tables temple){
        this.tablesRepoImp.save(temple);
        System.out.println("修改"+temple.toString()+"成功！");
    }
    @Transactional
    public void DeleteTableById(@RequestParam("tablesId")int id){
        this.tablesRepoImp.deleteByTablesId(id);
        System.out.println("删除tablesid为"+id+"成功！");
    }
    @Transactional
    public void SaveDes(description temple){
        this.descriptionRepoImp.save(temple);
        System.out.println("保存新评论成功");
    }
    public void saveTagOfIssueFunc(int dataId,int tagId){
        data newtemple= this.dataRepoImp.findByDataId(dataId);
        newtemple.setTagId(tagId);
        this.dataRepoImp.save(newtemple);
        System.out.println("保存Id:"+newtemple.getDataId()+"的tagId为"+newtemple.getTagId()+"成功！");
    }
    public void saveTagFunc(getNewTag temp){
        this.tagRepoImp.save(temp.changeToNewTag());
        System.out.println("保存标签成功");
    }
    public void setReadMessage(int umId){
        usermessage temple=this.usermessageRepoImp.findByUmId(umId);
        temple.setStatus(0);
        this.usermessageRepoImp.save(temple);
        System.out.println("umId"+umId+"设置成功！");
    }
    public void publishNewMessage(PublishMessage temple){
        //首先判断是否是群发的消息 如果是就for循环到m u表中进行测试
        //否则就是定点给出一个表
        message MessageTemple=new message();
        MessageTemple.setDate(temple.date2);
        MessageTemple.setMessageDes(temple.messageDes);
        MessageTemple=this.messageRepoImp.save(MessageTemple);
        usermessage userMessageTemple=new usermessage();
        //if 判断是否是群发消息
        if(temple.type.equals("1")){//说明是群发消息
            //获取用户列表
            ArrayList<user>userList = this.userRepoImp.findAll();
            for(user iter:userList){
                userMessageTemple.setUserId(iter.getUserId());
                userMessageTemple.setStatus(1);
                userMessageTemple.setMessageId(MessageTemple.getMessageId());//
                this.usermessageRepoImp.save(userMessageTemple);
                userMessageTemple=new usermessage();//重置指针
            }
            System.out.println("生成系统消息成功");
        }else { //单发消息
            userMessageTemple.setMessageId(MessageTemple.getMessageId());
            userMessageTemple.setStatus(1);
            userMessageTemple.setUserId(temple.getUserId());
            this.usermessageRepoImp.save(userMessageTemple);
            //在所有的获取之后就可以完成保存
            System.out.println("生成用户消息成功");
        }
    }
}

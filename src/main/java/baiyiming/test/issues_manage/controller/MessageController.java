package baiyiming.test.issues_manage.controller;


import baiyiming.test.issues_manage.dto.GetUserList;
import baiyiming.test.issues_manage.dto.GetUserMessage;
import baiyiming.test.issues_manage.repeatPart.PublishMessage;
import baiyiming.test.issues_manage.service.GetDateServicImp;
import baiyiming.test.issues_manage.service.SaveDateServicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class MessageController {
    @Autowired
    GetDateServicImp GetDateService;
    @Autowired
    SaveDateServicImp SaveDateService;
    //这里需要完成几个controller接口 1 -> 获取当前所有的user -> 2获取消息发布 3->删除接口
    //获取所有的user名单
    @RequestMapping(value = "/getdata/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public GetUserList GetUserListFunc(){
        return GetDateService.GetUserListFunc();
    }

    @RequestMapping(value = "/getdata/getMessageList",method = RequestMethod.GET)
    @ResponseBody
    public GetUserMessage GetUserMessageFunc(@RequestParam(value = "userId")int userId){
        return GetDateService.GetUserMessageFunc(userId);
    }

    @RequestMapping(value = "/savedata/setUserMessageList",method = RequestMethod.GET)
    @ResponseBody
    public void setReadMessage(@RequestParam(value = "umId")int umId){
        SaveDateService.setReadMessage(umId);
    }

    @RequestMapping(value = "/savedata/PublishMessage",method = RequestMethod.POST)
    @ResponseBody
    public void publishMessage(@RequestBody PublishMessage temple ){
        System.out.println(temple);
        SaveDateService.publishNewMessage(temple);
    }
}

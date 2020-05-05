package baiyiming.test.issues_manage.controller;
import baiyiming.test.issues_manage.dto.*;
import baiyiming.test.issues_manage.repeatPart.queryInfo;
import baiyiming.test.issues_manage.service.GetDateServicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/api/getdata")
public class GetDataController {
    //这里需要autowired各种service
    @Autowired
    GetDateServicImp GetDateService;
    @RequestMapping(value = "/testSubPath",method = RequestMethod.GET)
    @ResponseBody
    public String SubResponse(){
        return "successful!";
    }
    //这里是用来返回tables的data
    @RequestMapping(value = "/gettables",method = RequestMethod.GET)
    @ResponseBody
    public GetTablesData GetTables(HttpServletRequest request){
        //这里需要对参数和分页设定
        queryInfo temple=new queryInfo() ;
        temple.setQuerypara(request.getParameter("querypara"));
        if(temple.getQuerypara().isEmpty())
            temple.setQuerypara("tablesId");
        temple.setPageIndex(Integer.parseInt(request.getParameter("pageIndex")));
        temple.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        //这里获取了参数后使用
        //这是一个sort函数根据list string（para2）来选择
        return GetDateService.GetTablesDatePara(temple) ;
    }


    @RequestMapping(value = "/tableToIssues",method = RequestMethod.POST)
    @ResponseBody
    public GetTablesToIssues GetIssuesFromTable(@RequestBody queryInfo para){
        return GetDateService.GetTablesToIssuesFunc(para);
    }

    @RequestMapping(value = "/Issues", method = RequestMethod.GET)
    @ResponseBody
    public GetIssue GetDataFunc(@RequestParam(value = "dataId",required = true) int dataId){
        return GetDateService.GetIsssueFunc(dataId);
    }
    @RequestMapping(value = "/Tags", method = RequestMethod.GET)
    @ResponseBody
    public GetTag GetTagFunc(){
        return GetDateService.GetTagFunc();
    }

    @RequestMapping(value = "/Des", method = RequestMethod.POST)
    @ResponseBody
    public GetDes GetDesFunc(@RequestBody queryInfo para)   {
        System.out.println(para.toString());
        return GetDateService.GetDesFunc(para);
    }

    @RequestMapping(value = "/DesAndUname", method = RequestMethod.POST)
    @ResponseBody
    public GetUserNameAndDes GetUserNameAndDesFunc(@RequestBody queryInfo para){
        System.out.println(para.toString());
        return GetDateService.GetUserNameAndDesFunc(para);
    }
    @RequestMapping(value = "/Percentage", method = RequestMethod.GET)
    @ResponseBody
    public GetPercentage GetPercentageFunc(){
        return GetDateService.GetPercentageFunc();
    }
    //这了准备最近的和这个用户的所有数据都给返回回来
    @RequestMapping(value = "/Recentuser", method = RequestMethod.GET)
    @ResponseBody
    public GetRecentUser GetRecentUserFunc(@RequestParam(value ="userId")int userId){
        return GetDateService.GetRecentUserFunc(userId);
    }
    @RequestMapping(value = "/tableTag",method = RequestMethod.POST)
    @ResponseBody
    public GetTagsTables GetTagsTablesFunc(@RequestBody queryInfo para){
        System.out.println(para.toString());
        return GetDateService.GetTagsTablesFunc(para);
    }
}

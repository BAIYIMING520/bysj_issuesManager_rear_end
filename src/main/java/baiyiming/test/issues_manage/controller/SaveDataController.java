package baiyiming.test.issues_manage.controller;
import baiyiming.test.issues_manage.entity.*;
import baiyiming.test.issues_manage.repeatPart.getNewDes;
import baiyiming.test.issues_manage.repeatPart.getNewTag;
import baiyiming.test.issues_manage.service.SaveDateServicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/api/savedata")
public class SaveDataController {
    @Autowired
    SaveDateServicImp SaveDateService;
    @RequestMapping(value = "/savetables",method = RequestMethod.POST)
    @ResponseBody
    public void SaveTables(@RequestParam("tablesId")int tablesId, @RequestParam("tablesName")String tablesName, @RequestParam("builder")String builder, @RequestParam("date")java.sql.Date date)
    {
        tables temple=new tables();
        temple.setTablesId(tablesId);
        temple.setBuilder(builder);
        temple.setDate(date);
        temple.setTablesName(tablesName);
        SaveDateService.SaveTable(temple);
    }
    @RequestMapping(value = "/deletetables",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteTables(@RequestParam("tablesId")int tablesId)
    {
        SaveDateService.DeleteTableById(tablesId);
    }

    @RequestMapping(value = "/saveNewDes",method = RequestMethod.POST)
    @ResponseBody
    public void getNewDesFunc(@RequestBody getNewDes temple){
        description Instance=new description();
        Instance.setDataId(temple.getDataId());
        Instance.setAgree(0);
        Calendar calendar = Calendar.getInstance();
        java.util.Date time1 = calendar.getTime();
        Date time=new Date(time1.getTime());
        Instance.setDate(time);
        Instance.setUserId(temple.getUserId());
        Instance.setDescription(temple.getDescription());
        SaveDateService.SaveDes(Instance);
    }
    @RequestMapping(value = "/saveTagOfIssue", method = RequestMethod.GET)
    @ResponseBody
    public void saveTagOfIssue(@RequestParam(value ="dataId")String dataId,@RequestParam(value = "tagId")String tagId){
        //这里存储后调用save
        int Int_dataId=Integer.parseInt(dataId);
        int Int_tagId=Integer.parseInt(tagId);
        SaveDateService.saveTagOfIssueFunc(Int_dataId,Int_tagId);
    }
    @RequestMapping(value = "/saveTag", method = RequestMethod.POST)
    @ResponseBody
    public void saveTag(@RequestBody getNewTag temple){
        //System.out.println(temple.toString());//测试能否发送数据
        SaveDateService.saveTagFunc(temple);
    }
    @RequestMapping(value = "/saveTable", method = RequestMethod.POST)
    @ResponseBody
    public String getTable(MultipartFile file, HttpServletRequest request){
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/Users/cauthy/Desktop/springboot/Fileupload";
        File dest = new File(filePath + fileName);
        try {
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
        }
        return "上传失败！";
    }
}

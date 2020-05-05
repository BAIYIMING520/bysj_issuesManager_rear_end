package baiyiming.test.issues_manage.controller;
import baiyiming.test.issues_manage.dto.*;
import baiyiming.test.issues_manage.repeatPart.*;
import baiyiming.test.issues_manage.service.GetAnalysisServiceImp;
import baiyiming.test.issues_manage.service.GetDateServicImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/api/getAnalysis")
public class getAnalysis {
    @Autowired
    GetDateServicImp GetDateService;
    @Autowired
    GetAnalysisServiceImp GetAnalysisService;
    @RequestMapping(value = "/getTableAnalysisBydefault",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<KeyValuePair> getTableAnalysisBydefault(@RequestBody queryform temple){
        return GetAnalysisService.GetAnalysisByDefault(temple);
    }
    @RequestMapping(value = "/getTotalAnalysis",method = RequestMethod.GET)
    @ResponseBody
    public totalAnalysis getTotalAnalysis(@RequestParam(value = "type") String type){
        return GetAnalysisService.Gettotal(type);
    }
}

package baiyiming.test.issues_manage.controller;
import baiyiming.test.issues_manage.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @Autowired
    userRepo myUsertest;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String testmycontroller(){
        return "juit测试";
    }
    //这里对端口进行测试 对数据库的user属性进行测试
    @RequestMapping(value = "/createDatainitial", method = RequestMethod.GET)
    @ResponseBody
    public Boolean testUserDatabases() throws Exception{
        return true;
    }
//    //找到几天的问题终于解决了 前端使用 如下 后端使用如下 就可以完成字符串传递 这种方式多写几个dto就可以完成数据
//    // let resp=this.$http({method: 'POST',url:'http://localhost:8090/jsonTest',headers:{'Content-Type':'application/json; charset=utf-8'},data:JSON.stringify(this.TestJson)})
//    @RequestMapping(value = "/jsonTest",method = RequestMethod.POST)
//    @ResponseBody
//    public void PrintJson(@RequestBody TestJson testObj){
//        System.out.println(testObj.toString());
//    }
}

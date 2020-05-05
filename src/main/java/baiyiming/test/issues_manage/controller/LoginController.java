package baiyiming.test.issues_manage.controller;

import baiyiming.test.issues_manage.dto.LoginCheck;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.service.userServiceImp;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;


@Controller
public class LoginController {
    @Autowired
    private userServiceImp userService;
    @RequestMapping(value = "/api/logincheck", method = RequestMethod.POST)//登陆数据库
    @ResponseBody
    public LoginCheck UserCheck(@RequestBody String logindata) throws UnknownHostException {
        //没有用户时候 这里知道客户端传入的参数是一个字符串 参数 使用json进行转换获得内部属性
        JSONObject LoginDataJson = JSONObject.parseObject(logindata);
        String username = new String(LoginDataJson.getString("username"));
        String password = new String(LoginDataJson.getString("password"));
        user templeuser= new user();
        //前端传入数据的时候已经对数据进行了数据检验 这里只需要做出后端端口进行数据查询
        templeuser.setUsername(username);
        templeuser.setUserpassword(password);
        templeuser.setAuthority("null");
        //这里调用查询给出一个返回logincheck值
        LoginCheck Status = new LoginCheck(userService.loginby_name_password(templeuser));//
        return Status;
    }
}

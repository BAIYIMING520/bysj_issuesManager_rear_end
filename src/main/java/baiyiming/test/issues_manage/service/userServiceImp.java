package baiyiming.test.issues_manage.service;

import baiyiming.test.issues_manage.dto.LoginCheck;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImp {
    @Autowired
    private  userRepo userRepoImp;
    public LoginCheck loginby_name_password(user userimp)
    {
        LoginCheck check=new LoginCheck();
        user usertemple= userRepoImp.findByUsername(userimp.getUsername());
        if(usertemple==null)
        {
            System.out.println("no this one");
            return check.GetLoginCheck(LoginCheck.NoUser,usertemple);
        }
        else if(userimp.getUserpassword().equals(userimp.getUserpassword()))
        {
            //这里拿到了username来计算token
            System.out.println("success");
            return check.GetLoginCheck(LoginCheck.Success,usertemple);
        }
        else
        {
            System.out.println("password is wrong");
            return check.GetLoginCheck(LoginCheck.PasswordError,usertemple);
        }
    }
}

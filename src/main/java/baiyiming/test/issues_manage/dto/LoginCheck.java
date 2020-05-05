package baiyiming.test.issues_manage.dto;
import baiyiming.test.issues_manage.entity.user;
import baiyiming.test.issues_manage.utils.JwtUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginCheck {
    public static  String NoUser  = "data base don't have this username or sth";
    public static String Success = "Success";
    public static String PasswordError = "PasswordError";
    public static int SInt=1;
    public static int NInt=2;
    public static int PInt=3;
    @JsonProperty("check")
    public String check;
    @JsonProperty("state")
    public int state;
    @JsonProperty("username")
    public String username;
    @JsonProperty("authority")
    public String authority;
    @JsonProperty("token")
    public String token;
    @JsonProperty("tablesId")
    public int tablesid;
    @JsonProperty("userId")
    public int userId;
    public LoginCheck()//初始化后调用一次改变状态函数
    {
        this.userId=-1;
        this.check=null;
        this.state=0;
        //开始传递的时候只专递了前两个
        this.token=null;
        this.authority=null;
        this.username=null;
        this.tablesid=-1;//初始化是reader的权限 没有权利修改表 除非是或得了root账号的权限 使用了0表权限 可以修改所有的表

    }
    public LoginCheck(LoginCheck para)
    {
        this.check=new String(para.check);
        this.state=para.state;
        this.setUserId(para.userId);
        if(para.token==null)
            this.token=null;
        else
            this.token=para.token;
        if(para.authority==null)
            this.authority=null;
        else
            this.authority=para.authority;
        if(para.username==null)
            this.username=null;
        else
            this.username=para.username;
    }
    public boolean check(String para)
    {
        if(this.check.equals(para))
            return true;
        else
            return false;
    }
    public  LoginCheck GetLoginCheck(String content,user templeuser)
    {
        //这里需要返回json
        if(content.equals(this.Success))
        {
            this.check=LoginCheck.Success;
            this.state=LoginCheck.SInt;
            this.authority=templeuser.getAuthority();
            this.username=templeuser.getUsername();
            this.tablesid=templeuser.getTablesId();
            this.setUserId(templeuser.getUserId());
            //这里给定了token用于验算
            this.setToken();
        }
        else if(content.equals(this.PasswordError))
        {
            this.check=LoginCheck.PasswordError;
            this.state=LoginCheck.PInt;
        }
        else
        {
            this.check=LoginCheck.NoUser;
            this.state=LoginCheck.NInt;
        }
        return this;
    }
    //只有在验证成功的状态下 才会在logincheck中放置自己的东西
    public void setToken()
    {
        this.token= JwtUtil.generateJsonToken(this);
        //这里调用settoken函数使用jwtUtil来给定token值
    }

    @Override
    public String toString() {
        return "LoginCheck{" +
                "check='" + check + '\'' +
                ", state=" + state +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                ", token='" + token + '\'' +
                ", tablesid=" + tablesid +
                ", userId=" + userId +
                '}';
    }

    public static String getNoUser() {
        return NoUser;
    }

    public static void setNoUser(String noUser) {
        NoUser = noUser;
    }

    public static String getSuccess() {
        return Success;
    }

    public static void setSuccess(String success) {
        Success = success;
    }

    public static String getPasswordError() {
        return PasswordError;
    }

    public static void setPasswordError(String passwordError) {
        PasswordError = passwordError;
    }

    public static int getSInt() {
        return SInt;
    }

    public static void setSInt(int SInt) {
        LoginCheck.SInt = SInt;
    }

    public static int getNInt() {
        return NInt;
    }

    public static void setNInt(int NInt) {
        LoginCheck.NInt = NInt;
    }

    public static int getPInt() {
        return PInt;
    }

    public static void setPInt(int PInt) {
        LoginCheck.PInt = PInt;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTablesid() {
        return tablesid;
    }

    public void setTablesid(int tablesid) {
        this.tablesid = tablesid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

package baiyiming.test.issues_manage.utils;
import baiyiming.test.issues_manage.dto.LoginCheck;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    //这个类用于生成token返回进行验证
    public static final String SUBJECT = "issuetest";
    public static final String SECRETKEY = "issue666";
    //这个秘钥必须要一段重复 一段不重复
    public static final long EXPIRE = 1000*60*60*24*7;//过期时间
    public static String generateJsonToken(LoginCheck loginser){
        //这里默认的传入参数是logincheck验证为正确情况下  username不为null
        if((loginser.username==null)||(loginser.authority==null)||(!loginser.check.equals(loginser.Success)))
            return null;
        else{
            String token= Jwts.builder()
                    .setSubject(SUBJECT)
                    .claim("username",loginser.username)
                    .claim("authority",loginser.authority)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                    .signWith(SignatureAlgorithm.HS256,SECRETKEY).compact();

            return token;
        }
    }
    public static Claims checkToken(String token)
    {
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRETKEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

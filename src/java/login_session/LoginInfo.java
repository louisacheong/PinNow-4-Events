package login_session;

import entity.User;
import javax.servlet.http.HttpSession;

public class LoginInfo {
    private static final String ATTR_NAME = "LoginInfo";
    
    public enum Method {
        WEBSITE,
        GOOGLE,
        FACEBOOK;
        
        public static Method parse(String method){
            if (method == null || method.equals("website"))
                return WEBSITE;
            if (method.equals("google"))
                return GOOGLE;
            if (method.equals("facebook"))
                return FACEBOOK;
            return WEBSITE;
        }
    };
    
    private final Method loginMethod;
    private final User user;
    
    public LoginInfo (Method loginMethod, User user){
        this.loginMethod=loginMethod;
        this.user=user;
    }
    
    public Method getLoginMethod(){
        return loginMethod;
    }
    
    public User getUser(){
        return user;
    }
    
    public static LoginInfo getLoginInfo(HttpSession session){
        if (session==null) return null;
        return (LoginInfo)session.getAttribute(ATTR_NAME);
    }
    
    public static void setLoginInfo(HttpSession session, LoginInfo info){
        if (session==null) return;
        session.setAttribute(ATTR_NAME,info);
    }
    
}

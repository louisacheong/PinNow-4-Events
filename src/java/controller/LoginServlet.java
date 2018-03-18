/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TrackLogin;
import entity.TrackLoginPK;
import entity.User;
//import login_session.LoginInfo;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import login_session.LoginInfo;
import session.TrackLoginFacade;
import session.UserFacade;


@WebServlet(
        name = "LoginServlet", 
        urlPatterns = {"/welcome"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacade UserFacade;
    @EJB
    private TrackLoginFacade TrackLoginFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession(); /*across whole session, i.e. user login*/
        ServletContext context = request.getServletContext(); /*across whole application*/
        String s_method = request.getParameter("method");
        String userName     = request.getParameter("username");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        LoginInfo.Method method = LoginInfo.Method.parse(s_method);
        session.setAttribute("user",email);
        if (s_method == null){
            session.setAttribute("method", "WEBSITE");
        } else {
            session.setAttribute("method", s_method);
        }
        Date lastLogin = new Date(); 
        session.setAttribute("loginDate", lastLogin);
        
        TrackLoginPK loginKey = new TrackLoginPK();
        loginKey.setEmail(email);
        loginKey.setLastLogin(lastLogin);
        TrackLogin loginEntry = new TrackLogin();
        loginEntry.setTrackLoginPK(loginKey);
        TrackLoginFacade.create(loginEntry);
        
        

        if (s_method == null){
            //s_method == null means login method is via website, authentication done based on email and password provided
            User user = UserFacade.authenticate(email, password);
            if (user != null){
                LoginInfo.setLoginInfo(session, new LoginInfo(method, user));
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error1", "Credentials provided are incorrect. Please make sure email and password are correct)");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }}else{
                //for GOOGLE or FACEBOOK login, only email can be authenticated
                User user = UserFacade.authenticate(email);
                if (user != null){
                    LoginInfo.setLoginInfo(session, new LoginInfo(method,user));
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("error1", "User does not exist in DB. Please try other authentication methods");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                }
        }
        }
}
        
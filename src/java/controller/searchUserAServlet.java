/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TrackLogin;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.TrackLoginFacade;
import session.UserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "searchUserAServlet", urlPatterns = {"/searchUserA"})
public class searchUserAServlet extends HttpServlet {

    @EJB
    private UserFacade UserFacade;
    @EJB
    private TrackLoginFacade TrackLoginFacade;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("searchtext");
        String searchText = search.trim();
        List<User> foundUser1 = UserFacade.findByUsername(searchText);
        Integer foundUser1count = foundUser1.size();
        List<User> foundUser2 = UserFacade.findByLastname(searchText);
        Integer foundUser2count = foundUser2.size();
        List<User> foundUser3 = UserFacade.findByFirstname(searchText);
        Integer foundUser3count = foundUser3.size();
        
        //Get session object
        HttpSession session = request.getSession(); 
        
        //Get interesting stats for admin page
        String email = (String)session.getAttribute("user");
        List<TrackLogin> result = TrackLoginFacade.LoginsPast2Weeks(email);
        Integer loginCount = result.size();
        request.setAttribute("loginCount",loginCount);
        List<TrackLogin> online = TrackLoginFacade.findByStillLoggedIn(Boolean.TRUE);
        Integer onlineCount = online.size();
        request.setAttribute("onlineUsersCount",onlineCount);
        List<User> totalusers = UserFacade.findAll();
        Integer regUsersCount = totalusers.size();
        request.setAttribute("regUsersCount",regUsersCount);
      
        if (foundUser1count >= foundUser2count && foundUser1count >=foundUser3count){
            request.setAttribute("foundUser",foundUser1);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin.jsp");
            rd.include(request, response);  
        }else if(foundUser2count > foundUser1count && foundUser2count > foundUser3count){
            request.setAttribute("foundUser",foundUser2);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin.jsp");
            rd.include(request, response);
        }else if(foundUser3count > foundUser1count && foundUser3count > foundUser2count){
            request.setAttribute("foundUser",foundUser3);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin.jsp");
            rd.include(request, response);
        }else{
            request.setAttribute("searcherror","No user is found");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/admin.jsp");
            rd.include(request, response);
        }
    }
}
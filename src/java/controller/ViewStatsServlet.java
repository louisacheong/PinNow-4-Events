/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TrackLogin;
import entity.TrackLoginPK;
import entity.User;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "ViewStatsServlet", urlPatterns = {"/viewStats"})
public class ViewStatsServlet extends HttpServlet {
    @EJB
    private UserFacade UserFacade;
    @EJB
    private TrackLoginFacade TrackLoginFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //requests for page redirect with user object
        HttpSession session = request.getSession(); 
        String email = (String) session.getAttribute("user");
        Date last_login = (Date) session.getAttribute("loginDate");
        User user = UserFacade.find(email);
        request.setAttribute("user", user);
        List<TrackLogin> result = TrackLoginFacade.LoginsPast2Weeks(email);
        Integer loginCount = result.size();
        request.setAttribute("loginCount",loginCount);
        user.setLoginCounter(loginCount);
        UserFacade.edit(user);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/viewStats.jsp");
        rd.forward(request,response);
    }

    
}

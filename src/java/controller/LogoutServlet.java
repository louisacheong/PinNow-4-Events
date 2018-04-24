/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.TrackLogin;
import entity.TrackLoginPK;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.TrackLoginFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/Logout"})
public class LogoutServlet extends HttpServlet {
    @EJB
    private TrackLoginFacade TrackLoginFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        Date lastLogin = (Date)session.getAttribute("loginDate");
        TrackLoginPK LoginKey = new TrackLoginPK();
        LoginKey.setEmail(email);
        LoginKey.setLastLogin(lastLogin);
        //sets still_logged_in field in TrackLogin entry to False
        TrackLogin LoginEntry = TrackLoginFacade.find(LoginKey);
        LoginEntry.setStillLoggedIn(true);
        System.out.println(LoginEntry.getStillLoggedIn());
        TrackLoginFacade.edit(LoginEntry);
        session.invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

   
}

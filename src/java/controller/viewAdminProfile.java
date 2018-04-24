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
@WebServlet(name = "viewAdminProfile", urlPatterns = {"/viewAdminProfile"})
public class viewAdminProfile extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //requests for page redirect with admin object
      
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.forward(request,response);
    }
 
}

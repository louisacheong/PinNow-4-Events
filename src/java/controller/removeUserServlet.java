/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.UserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "removeUserServlet", urlPatterns = {"/removeUser"})
public class removeUserServlet extends HttpServlet {
    @EJB private UserFacade UserFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("user");
        User user_tobe_removed = UserFacade.findByEmail(email);
        UserFacade.remove(user_tobe_removed);
        request.setAttribute("block_remove_info", email + " is removed from database");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
        rd.include(request,response);   
    }
}

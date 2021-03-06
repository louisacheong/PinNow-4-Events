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
@WebServlet(name = "promoteUserServlet", urlPatterns = {"/promoteUser"})
public class promoteUserServlet extends HttpServlet {
    @EJB private UserFacade UserFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("user");
        User user_tobe_promoted = UserFacade.findByEmail(email);
        user_tobe_promoted.setIsAdmin(true);
        UserFacade.edit(user_tobe_promoted);
        request.setAttribute("promote_demote_info", email + " is promoted to an admin");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
        rd.include(request,response);   
    }
}

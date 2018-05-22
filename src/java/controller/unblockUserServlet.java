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
@WebServlet(name = "unblockUserServlet", urlPatterns = {"/unblockUser"})
public class unblockUserServlet extends HttpServlet {
    @EJB private UserFacade UserFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("user");
        User user_tobe_unblocked = UserFacade.findByEmail(email);
        user_tobe_unblocked.setIsBlocked(false);
        UserFacade.edit(user_tobe_unblocked);
        
        //check if user is really unblocked
        User user_tobe_checked = UserFacade.findByEmail(email);
        if(user_tobe_checked.getIsBlocked()==false){
        request.setAttribute("block_remove_info", email + " is unblocked");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
        rd.include(request,response);   
        } else{
        request.setAttribute("block_remove_info", "There is a problem unblocking " + email + ". Please try again. ");    
        }}
}

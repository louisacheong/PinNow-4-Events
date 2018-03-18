/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "EditUserServlet", urlPatterns = {"/editUser"})
public class EditUserServlet extends HttpServlet {

    @EJB
    private UserFacade UserFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); /*across whole session, i.e. user login*/
        String email = (String) session.getAttribute("user");
        User user = UserFacade.find(email);
        request.setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/editUser.jsp");
        rd.forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        String userName = request.getParameter("username");//retrieve info from jsp pages by name
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String genderValue = request.getParameter("optionsRadios"); //will return value of checked boxes otherwise will return null
        String country = request.getParameter("country");
        if (password.equals(confirmPassword)){
            User user = UserFacade.find(email);
            user.setUsername(userName);
            user.setPassword(password);
            user.setFirstname(firstName);
            user.setLastname(lastName);
            if(genderValue.equals("2")){
                user.setGender(true);
            } else {
                user.setGender(false);
            }
            user.setCountry(country);
            UserFacade.edit(user);
            request.setAttribute("successEdit", "Edited " + email + ". Please login with new settings.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);  
        }
    }
}

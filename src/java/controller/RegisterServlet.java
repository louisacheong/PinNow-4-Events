/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import login_session.LoginInfo;
import session.UserFacade;

@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    @EJB
    private UserFacade UserFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email"); //retrieve info from jsp pages by name
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String genderValue = request.getParameter("optionsRadios"); //will return value of checked boxes otherwise will return null
        String country = request.getParameter("country");
        String[] selected_Topics = request.getParameterValues("topics") ;
        StringBuilder result = new StringBuilder();

        String error = null; //Initialise error as null
        if (selected_Topics.length < 3){
            request.setAttribute("selectTopicsError", "Error: Please choose at least 3 Topics!");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/index.jsp");
            rd.include(request,response);
        }else{
            for(int i=0; i< selected_Topics.length ;){
                session.setAttribute("selectedTopic"+ (i+1), selected_Topics[i]);
                result.append(selected_Topics[i]);
                if(++i < selected_Topics.length)
                    result.append(", ");
            }
            String select = result.toString();
        
            if (email == null || userName == null || firstName == null || lastName == null || selected_Topics.length == 0 ){ 
                //genderValue is mandatory but not included because it is by default "Male"/value="1
                error="Please fill in the mandatory fields";
            } else if (email.equals("") || userName.equals("") || firstName.equals("") || lastName.equals("")){
                error="Mandatory fields have to be filled";
            } else if (!password.equals(confirmPassword)){
                error="The password confirmation does not match password";
            } else  {
                try{
                    UserFacade.findByEmailAndUsername(email, userName);
                    }catch(Exception e){
                User user = new User();
                user.setEmail(email);
                user.setUsername(userName);
                user.setPassword(hash(password));
                user.setFirstname(firstName);
                user.setLastname(lastName);
                if(genderValue.equals("2")){
                    user.setGender(true);
                } else {
                    user.setGender(false);
                }
                user.setCountry(country);
                user.setSelectedtopics(select);
                try {
                    UserFacade.create(user);
                    LoginInfo.setLoginInfo(request.getSession(),
                    new LoginInfo(LoginInfo.Method.WEBSITE, user));
                    request.setAttribute("success","New user profile is created. Please login with your new credentials");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                } catch (Exception err){
                    request.setAttribute("error2", "Error creating profile - please try again with different email address/username");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request,response);
                }}
            }
        if (error != null){
            request.setAttribute("error2", error);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
            }
        }}
        
            
    
        
    private String hash(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        }catch (UnsupportedEncodingException ex){
            throw new RuntimeException("UTF-8 not supported");
        }catch (NoSuchAlgorithmException ex){
            throw new RuntimeException("SHA-256 not supported");
        }
        
   
    }

}

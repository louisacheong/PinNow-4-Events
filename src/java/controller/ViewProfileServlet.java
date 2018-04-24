/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.Pins;
import entity.PinsPK;
import entity.Topics;
import entity.TrackLogin;
import entity.TrackLoginPK;
import entity.User;
import entity.UserFollowsUser;
import java.io.IOException;
import java.io.PrintWriter;
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
import session.PinboardsFacade;
import session.PinsFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "ViewProfileServlet", urlPatterns = {"/viewProfile"})
public class ViewProfileServlet extends HttpServlet {
    @EJB private PinsFacade PinsFacade;
    @EJB private PinboardsFacade PinboardsFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        try
        {
            String selected_Topics[] = request.getParameterValues("topics") ;
            if (selected_Topics.length < 3){
                request.setAttribute("selectTopicsError", "Error: Please choose at least 3 Topics!");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
                rd.include(request,response);
            }else{
            for(int i=0; i< selected_Topics.length ; i++){
                session.setAttribute("selectedTopic"+ (i+1), selected_Topics[i]);
            }
            //include info on pins 
            List<Pins> pinlist = PinsFacade.findByUserEmail(email);
            session.setAttribute("pins", pinlist);
            
            //include info on boards
            List<Pinboards> pinboards = PinboardsFacade.findByUserEmail(email);
            session.setAttribute("boards", pinboards);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.forward(request,response);
        }}
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

       
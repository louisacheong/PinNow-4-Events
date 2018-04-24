/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import entity.Pins;
import entity.PinsPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "editPinServlet", urlPatterns = {"/editPin"})
public class editPinServlet extends HttpServlet {
    @EJB private PinsFacade PinsFacade;
    @EJB private PinboardsFacade PinboardsFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        String pinName = request.getParameter("pinName");
        String topicName = request.getParameter("topicName");
        PinsPK pinkeytmp = new PinsPK();
        pinkeytmp.setName(pinName);
        pinkeytmp.setUserEmail(email);
        pinkeytmp.setTopicsName(topicName);
        
        System.out.println(pinName + topicName + email);
        Pins pin = PinsFacade.find(pinkeytmp);
        
        request.setAttribute("pin",pin);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/editPin.jsp");
        rd.forward(request,response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        String pinName = request.getParameter("pinName");
        String topicName = request.getParameter("topicName");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        System.out.println("pinName " + pinName);
        System.out.println("topicName " + topicName);
        System.out.println("description " + description);
        System.out.println("location " + location);
        PinsPK pinkeytmp = new PinsPK();
        pinkeytmp.setName(pinName);
        pinkeytmp.setTopicsName(topicName);
        pinkeytmp.setUserEmail(email);
        Pins newpin = PinsFacade.find(pinkeytmp);
        newpin.setDescription(description);
        newpin.setLocation(location);
        Date updatetime = new Date();
        newpin.setLastPinned(updatetime);
        PinsFacade.edit(newpin);
        System.out.println("Code is executed up to here!");
        
        request.setAttribute("boardstatus","Edited Pin: " + pinName);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.forward(request,response);
        
    }

}

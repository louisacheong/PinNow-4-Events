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
 * This servlet is triggered when save button on pin is clicked.
 * User is directed to a search board/create board page where pin can be saved onto an existing board (found via search form) or a new board
 * 
 * @author louisacheong
 */
@WebServlet(name = "savePinServlet", urlPatterns = {"/savePin"})
public class savePinServlet extends HttpServlet {
    @EJB private PinsFacade PinsFacade;
    @EJB private PinboardsFacade PinboardsFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pinName = request.getParameter("pinName");
        String topicName = request.getParameter("topicName");
        String email = (String)session.getAttribute("user");
        PinsPK pinkeytmp = new PinsPK();
        System.out.println(pinName + topicName + email);
        pinkeytmp.setName(pinName);
        pinkeytmp.setTopicsName(topicName);
        pinkeytmp.setUserEmail(email);
        Pins pin = PinsFacade.find(pinkeytmp);
        System.out.println("pin from savepin " + pin);
        session.setAttribute("pin",pin);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/savePin.jsp");
        rd.forward(request,response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        Pins pin = (Pins)session.getAttribute("pin");
        System.out.println("pin from post method in savepin " + pin);
        String pinboardName = request.getParameter("boardname");
        String isPrivate = request.getParameter("isPrivate");
        PinsPK pinkey = pin.getPinsPK();
        String pinName = pinkey.getName();
       
        //Gather and set pinboard info
        PinboardsPK boardkey = new PinboardsPK();
        boardkey.setName(pinboardName);
        boardkey.setUserEmail(email);
        Pinboards newboard =  new Pinboards();
        newboard.setPinboardsPK(boardkey);
        Date currentTime = new Date();
        newboard.setCreateTime(currentTime);
        newboard.setLastUpdated(currentTime);
        if(isPrivate == null){
            newboard.setIsPrivate(false);
        }else{
            newboard.setIsPrivate(true);
        }
        
        //create pinboard
        PinboardsFacade.create(newboard);
        //link pin to pinboard
        pin.setPinboards(newboard);
        newboard.getPinsCollection().add(pin);
        PinsFacade.edit(pin);
        
        //include boards to be displayed
        List<Pinboards> boards = PinboardsFacade.findByUserEmail(email);
        session.setAttribute("boards", boards);
        session.setAttribute("board", newboard);
        
        request.setAttribute("boardstatus","Saved: " + pinName + " into " + pinboardName);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.forward(request,response);
        
    }

   
}

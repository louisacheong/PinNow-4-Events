/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import entity.Pins;
import java.io.IOException;
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
@WebServlet(name = "saveOnBoardServlet", urlPatterns = {"/saveOnBoard"})
public class saveOnBoardServlet extends HttpServlet {
    @EJB private PinboardsFacade PinboardsFacade;
    @EJB private PinsFacade PinsFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get session object
        HttpSession session = request.getSession(); 
        String boardName = request.getParameter("boardName");
        Pins pin = (Pins)session.getAttribute("pin");
       
        String email = (String)session.getAttribute("user");
        PinboardsPK boardkey = new PinboardsPK();
        boardkey.setName(boardName);
        boardkey.setUserEmail(email);
        Pinboards board = PinboardsFacade.find(boardkey);
        List<Pinboards> boards = PinboardsFacade.findByUserEmail(email);
       
        System.out.println("Pin0" + pin);
        List<Pins> pins = PinsFacade.findByUserEmail(email);
        System.out.println("Stoppoint1");
        //Send info on pins
        session.setAttribute("pins", pins);
        System.out.println("Stoppoint2");
        //Send info on boards
        session.setAttribute("boards", boards);
        System.out.println("Stoppoint3");
        System.out.println("Board" + board);
        System.out.println("Pin" + pin);
        pin.setPinboards(board);
        System.out.println("Stoppoint4");
        PinsFacade.edit(pin);
        System.out.println("Stoppoint5");
        request.setAttribute("boardstatus", "Saved Pin '" + pin.getPinsPK().getName() + "' on Board '" + boardkey.getName() + "'");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.forward(request,response);
    }
}

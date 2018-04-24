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
@WebServlet(name = "editBoardServlet", urlPatterns = {"/editBoard"})
public class editBoardServlet extends HttpServlet {
    
    @EJB private PinboardsFacade PinboardsFacade; 
    @EJB private PinsFacade PinsFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String boardName = request.getParameter("boardName");
        String email = (String)session.getAttribute("user");
        PinboardsPK boardkey = new PinboardsPK();
        boardkey.setName(boardName);
        boardkey.setUserEmail(email);
        Pinboards board = PinboardsFacade.find(boardkey);
        session.setAttribute("board",board);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/editBoard.jsp");
        rd.forward(request,response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String boardName = request.getParameter("boardName");
        String isPrivate = request.getParameter("isPrivate");
        String email = (String)session.getAttribute("user");
        Pinboards board = (Pinboards)session.getAttribute("board");
        System.out.println("boardName " + boardName);
        System.out.println("isPrivate " + isPrivate);
        System.out.println("email " + email);
        System.out.println("board " + board);
        
        //Gather and edit pinboard info
        PinboardsPK boardkey = new PinboardsPK();
        boardkey.setName(boardName);
        boardkey.setUserEmail(email);
        board.setPinboardsPK(boardkey);
        System.out.println("Checkpoint1");
        Date currentTime = new Date();
        board.setLastUpdated(currentTime);
        if(isPrivate == null){
            board.setIsPrivate(false);
        }else{
            board.setIsPrivate(true);
        }
        
        PinboardsFacade.edit(board);
        System.out.println("Checkpoint2");
        request.setAttribute("boardstatus", "Edited Board '"+ boardName + "'");
        
        //include info on pins and boards
        List<Pins> pins = PinsFacade.findByUserEmail(email);
        List<Pinboards> boards = PinboardsFacade.findByUserEmail(email);
        request.setAttribute("pins",pins);
        request.setAttribute("boards",boards);
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.forward(request,response);
        
        
    }

   
}

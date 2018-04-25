/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import java.io.IOException;
import java.util.*;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PinboardsFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "searchBoardServlet", urlPatterns = {"/searchBoard"})
public class searchBoardServlet extends HttpServlet {

    @EJB private PinboardsFacade PinboardsFacade;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get session object
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("user");
        String search = request.getParameter("searchtext");
        String searchText = search.trim();
        String[] foundkeywords = searchText.split(" ");
        List<Pinboards> boards = PinboardsFacade.findByUserEmail(email);
        
        //create List of boardnames in string for matching search
        String[] boardnames = new String[boards.size()];
        //create Set of foundBoards with unique pinboard elements for found boards
        Set<Pinboards> foundBoards = new HashSet<Pinboards>();
        //Populate List of boardnames
        for (int i=0; i<boards.size(); i++){
            Pinboards board = boards.get(i);
            PinboardsPK boardkey = board.getPinboardsPK();
            String boardname = boardkey.getName();
            boardnames[i] = boardname;
            for(String s:foundkeywords){
                boardnames[i] = boardnames[i].toLowerCase();
                s=s.toLowerCase();
                //comparison is case-insensitive
                if(boardnames[i].contains(s)){
                    String boardName = boardnames[i];
                    PinboardsPK findkey = new PinboardsPK();
                    findkey.setName(boardName);
                    findkey.setUserEmail(email);
                    Pinboards foundBoardsItem = PinboardsFacade.find(findkey);
                    foundBoards.add(foundBoardsItem);
                }}}
        if (foundBoards.size()>0){
            request.setAttribute("foundBoards", foundBoards);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/savePin.jsp");
            rd.include(request, response); 
        }else{
            request.setAttribute("searcherror", "Board does not exist for keyword(s) entered. Please create a new board");
            request.setAttribute("boardname",searchText);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/savePin.jsp");
            rd.include(request, response);
        }
    }
}
        
    

    
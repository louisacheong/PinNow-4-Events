/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import entity.User;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PinboardsFacade;
import session.UserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(
        name = "searchUserandBoardServlet", 
        urlPatterns = {"/searchUserandBoard"})
public class searchUserandBoardServlet extends HttpServlet {
    
    @EJB private UserFacade UserFacade;
    @EJB private PinboardsFacade PinboardsFacade;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String search = request.getParameter("searchtext");
        String searchText = search.trim();
        //Look for users
        List<User> foundUser1 = UserFacade.findByUsername(searchText);
        Integer foundUser1count = foundUser1.size();
        List<User> foundUser2 = UserFacade.findByLastname(searchText);
        Integer foundUser2count = foundUser2.size();
        List<User> foundUser3 = UserFacade.findByFirstname(searchText);
        Integer foundUser3count = foundUser3.size();
        
         //Look for boards in DB
        String[] foundkeywords = searchText.split(" ");
        List<Pinboards> boards = PinboardsFacade.findAll();
        
        //create List of boardnames in string for matching search
        String[] boardnames = new String[boards.size()];
        //create Set of foundBoards with unique pinboard elements for found boards
        Set<Pinboards> foundBoards = new HashSet<>();
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
                    List<Pinboards> foundBoardItems = PinboardsFacade.findByName(boardName);
                    for (int el=0; el<foundBoardItems.size(); el++){
                    foundBoards.add(foundBoardItems.get(el));
                }}}}
        if (foundBoards.size()>0){
            request.setAttribute("foundBoards", foundBoards);
            System.out.println("checkpoint1");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request, response);
        }else{
        if (foundUser1count >= foundUser2count && foundUser1count >=foundUser3count){
            request.setAttribute("foundUser",foundUser1);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            System.out.println("checkpoint2");
            rd.include(request, response);  
        }else if(foundUser2count > foundUser1count && foundUser2count > foundUser3count){
            request.setAttribute("foundUser",foundUser2);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            System.out.println("checkpoint3");
            rd.include(request, response);
        }else if(foundUser3count > foundUser1count && foundUser3count > foundUser2count){
            request.setAttribute("foundUser",foundUser3);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            System.out.println("checkpoint4");
            rd.include(request, response);
        }else {
            request.setAttribute("searcherror1","No user/board is found");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request, response);
        }
        }
    }
}



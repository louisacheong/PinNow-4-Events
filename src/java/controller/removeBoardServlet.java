/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "removeBoardServlet", urlPatterns = {"/removeBoard"})
public class removeBoardServlet extends HttpServlet {
    @EJB private PinboardsFacade PinboardsFacade;
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
        PinboardsFacade.remove(board);
        List<Pinboards> boards = PinboardsFacade.findByUserEmail(email);
        request.setAttribute("boards", boards);
        request.setAttribute("boardstatus", "Board " + boardName + " is removed successfully.");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.include(request,response);
       
    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.UserFollowsPinboard;
import entity.UserFollowsPinboardPK;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PinboardsFacade;
import session.UserFollowsPinboardFacade;


/**
 *
 * @author louisacheong
 */
@WebServlet(name = "followBoardServlet", urlPatterns = {"/followBoard"})
public class followBoardServlet extends HttpServlet {
    @EJB private UserFollowsPinboardFacade UserFollowsPinboardFacade;
    @EJB private PinboardsFacade PinboardsFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String follower = (String)session.getAttribute("user");
        String userEmail = request.getParameter("following");
        String boardBeingFollowed = request.getParameter("board");
        
        //Persists follower and following record in user_follows_pinboards Table
        Pinboards board = PinboardsFacade.findByUserEmailandName(userEmail, boardBeingFollowed);
        UserFollowsPinboardPK followKey = new UserFollowsPinboardPK();
        followKey.setUserEmail(follower);
        followKey.setPinboardsName(boardBeingFollowed);
        followKey.setPinboardsUserEmail(userEmail);
        UserFollowsPinboard followEntry = new UserFollowsPinboard();
        followEntry.setUserFollowsPinboardPK(followKey);
        followEntry.setIsPermitted(false);
        try{
            UserFollowsPinboardFacade.create(followEntry);
            //Sets status success for followUser
            request.setAttribute("followstatus","Follow board "+ boardBeingFollowed  + " request is sent to " + userEmail);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }catch(Exception e){
            //Sets status error for followUser
            request.setAttribute("followstatus","You are already following" + boardBeingFollowed);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserFollowsPinboard;
import entity.UserFollowsPinboardPK;
import entity.UserFollowsUser;
import entity.UserFollowsUserPK;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFollowsPinboardFacade;
import session.UserFollowsUserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "unfollowBoardServlet", urlPatterns = {"/unfollowBoard"})
public class unfollowBoardServlet extends HttpServlet {

    @EJB private UserFollowsPinboardFacade UserFollowsPinboardFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String follower = (String)session.getAttribute("user");
        String userEmail = request.getParameter("following");
        String boardBeingFollowed = request.getParameter("board");
        
        //Look for record entry for PK
        UserFollowsPinboardPK followKey = new UserFollowsPinboardPK();
        followKey.setPinboardsName(boardBeingFollowed);
        followKey.setPinboardsUserEmail(userEmail);
        followKey.setUserEmail(follower);
        UserFollowsPinboard followEntry = UserFollowsPinboardFacade.find(followKey);
        
        try{
            //Remove follower and following record in user_follow_pinboard Table
            UserFollowsPinboardFacade.remove(followEntry);
            //Sets status success for followUser
            request.setAttribute("followstatus","You are no longer following board " + boardBeingFollowed);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }catch(Exception e){
            //Sets status error for followUser
            request.setAttribute("followstatus","You cannot unfollow " + boardBeingFollowed + "because you are not a follower");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }
    }
}

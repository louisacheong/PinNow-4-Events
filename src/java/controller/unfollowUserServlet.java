/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserFollowsUser;
import entity.UserFollowsUserPK;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFollowsUserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "unfollowUserServlet", urlPatterns = {"/unfollowUser"})
public class unfollowUserServlet extends HttpServlet {

    @EJB
    private UserFollowsUserFacade UserFollowsUserFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String follower = (String)session.getAttribute("user");
        String personBeingFollowed = request.getParameter("following");
        
        //Look for record entry for PK
        UserFollowsUserPK followKey = new UserFollowsUserPK();
        followKey.setFollower(follower);
        followKey.setPersonBeingFollowed(personBeingFollowed);
        UserFollowsUser followEntry = UserFollowsUserFacade.findByPK(follower, personBeingFollowed);
        
        try{
            //Remove follower and following record in user_follows_user Table
            UserFollowsUserFacade.remove(followEntry);
            //Sets status success for followUser
            request.setAttribute("followstatus","You are no longer following " + personBeingFollowed);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }catch(Exception e){
            //Sets status error for followUser
            request.setAttribute("followstatus","You cannot unfollow " + personBeingFollowed + "because you are not a follower");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }
    }
}

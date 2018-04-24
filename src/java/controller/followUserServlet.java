/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import session.UserFollowsUserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "followUserServlet", urlPatterns = {"/followUser"})
public class followUserServlet extends HttpServlet {
    @EJB
    private UserFollowsUserFacade UserFollowsUserFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String follower = (String)session.getAttribute("user");
        String personBeingFollowed = request.getParameter("following");
        
        //Persists follower and following record in user_follows_user Table
        UserFollowsUserPK followKey = new UserFollowsUserPK();
        followKey.setFollower(follower);
        followKey.setPersonBeingFollowed(personBeingFollowed);
        UserFollowsUser followEntry = new UserFollowsUser();
        followEntry.setUserFollowsUserPK(followKey);
        followEntry.setUserFollowsUserPK(followKey);
        followEntry.setIsPermitted(false);//TO-DO: need to trigger a notification to the user being followed
        try{
            UserFollowsUserFacade.create(followEntry);
            //Sets status success for followUser
            request.setAttribute("followstatus","Follow request is sent to " + personBeingFollowed);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }catch(Exception e){
            //Sets status error for followUser
            request.setAttribute("followstatus","You are already following" + personBeingFollowed);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }
    }
}

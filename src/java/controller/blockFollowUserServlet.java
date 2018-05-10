/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Notification;
import entity.UserFollowsUser;
import entity.UserFollowsUserPK;
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
import session.NotificationFacade;
import session.UserFollowsUserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "blockFollowUserServlet", urlPatterns = {"/blockFollowUser"})
public class blockFollowUserServlet extends HttpServlet {
    @EJB private UserFollowsUserFacade UserFollowsUserFacade;
    @EJB private NotificationFacade NotificationFacade;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String follower = request.getParameter("follower");
        String beingFollowed = (String)session.getAttribute("user");
        String description = "follow user";
        Notification notificationentry = NotificationFacade.findByRow(follower, beingFollowed, description);
        UserFollowsUserPK UFUkey = new UserFollowsUserPK();
        UFUkey.setFollower(follower);
        UFUkey.setPersonBeingFollowed(beingFollowed);
        UserFollowsUser UFUentry = UserFollowsUserFacade.find(UFUkey);
        System.out.println(UFUentry.getIsPermitted());
        UFUentry.setIsPermitted(false);
        System.out.println(UFUentry.getIsPermitted());
        UserFollowsUserFacade.edit(UFUentry);
        //Notification will no longer be showed after this - removed from db
        NotificationFacade.remove(notificationentry);
        //check if there is any notification left
        List<Notification> followers = NotificationFacade.findByUserBeingFollowed(beingFollowed);
        if(!followers.isEmpty()){
            session.setAttribute("followers", followers);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }else{
            session.setAttribute("followers", null);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request,response);
        
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Notification;
import entity.UserFollowsPinboard;
import entity.UserFollowsPinboardPK;
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
import session.UserFollowsPinboardFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "allowFollowBoardServlet", urlPatterns = {"/allowFollowBoard"})
public class allowFollowBoardServlet extends HttpServlet {
    @EJB private UserFollowsPinboardFacade UserFollowsPinboardFacade;
    @EJB private NotificationFacade NotificationFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String follower = request.getParameter("follower");
        String beingFollowed = (String)session.getAttribute("user");
        String description = "follow pinboard";
        String pinboard_name = request.getParameter("pinboard");
        Notification notificationentry = NotificationFacade.findByPinboardsRow(follower, beingFollowed, pinboard_name, description);
        UserFollowsPinboardPK UFBkey = new UserFollowsPinboardPK();
        UFBkey.setUserEmail(follower);
        UFBkey.setPinboardsUserEmail(beingFollowed);
        UFBkey.setPinboardsName(pinboard_name);
        UserFollowsPinboard UFBentry = UserFollowsPinboardFacade.find(UFBkey);
        System.out.println(UFBentry.getIsPermitted());
        UFBentry.setIsPermitted(true);
        System.out.println(UFBentry.getIsPermitted());
        UserFollowsPinboardFacade.edit(UFBentry);
        
        //Notification will no longer be showed after this - removed from db
        NotificationFacade.remove(notificationentry);
        //check if there is any notification left
        List<Notification> pinboards = NotificationFacade.findByPinboardBeingFollowed(beingFollowed);
        if(!pinboards.isEmpty()){
            session.setAttribute("pinboards", pinboards);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request,response);
        }else{
            session.setAttribute("pinboards", null);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request,response);
        
        }
        
    }

    


}

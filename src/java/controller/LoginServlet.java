/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Notification;
import entity.TrackLogin;
import entity.TrackLoginPK;
import entity.User;
import entity.UserFollowsUser;
import entity.Topics;
import entity.Pinboards;
import entity.Pins;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import login_session.LoginInfo;
import session.NotificationFacade;
import session.PinboardsFacade;
import session.PinsFacade;
import session.TopicsFacade;
import session.TrackLoginFacade;
import session.UserFacade;
import session.UserFollowsUserFacade;


@WebServlet(
        name = "LoginServlet", 
        urlPatterns = {"/welcome"})
public class LoginServlet extends HttpServlet {

    @EJB private UserFacade UserFacade;
    @EJB private TrackLoginFacade TrackLoginFacade;
    @EJB private UserFollowsUserFacade UserFollowsUserFacade;
    @EJB private TopicsFacade TopicsFacade;
    @EJB private NotificationFacade NotificationFacade;
    @EJB private PinsFacade PinsFacade;
    @EJB private PinboardsFacade PinboardsFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String s_method = request.getParameter("method");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        LoginInfo.Method method = LoginInfo.Method.parse(s_method);
        //Get session object
        HttpSession session = request.getSession(); 
        //ServletContext ctxt = session.getServletContext();
        

        if (method==LoginInfo.Method.WEBSITE){
            //s_method == null means login method is via website, authentication done based on email and password provided
            User user = UserFacade.authenticate(email, password);
            
            if (user != null && user.getIsAdmin()== false && user.getIsBlocked()==false){
                //System.out.println(user);
                String userName = user.getUsername();
                LoginInfo.setLoginInfo(session, new LoginInfo(method,user));
                
                //Set session object with attributes user, method and loginDate
                session.setAttribute("user",email);
                session.setAttribute("userName", userName);
                session.setAttribute("method", method);
                Date lastLogin = new Date(); 
                session.setAttribute("loginDate", lastLogin);
                    
                //Insert last_login field into user row
                user.setLastLogin(lastLogin);
                UserFacade.edit(user);
        
                //Persists Login Data in track_login table
                TrackLoginPK loginKey = new TrackLoginPK();
                loginKey.setEmail(email);
                loginKey.setLastLogin(lastLogin);
                TrackLogin loginEntry = new TrackLogin();
                loginEntry.setTrackLoginPK(loginKey);
                loginEntry.setStillLoggedIn(true);
                TrackLoginFacade.create(loginEntry);
                System.out.println("t.TrackLoginPK.lastLogin" + lastLogin);
                
                
                //Get interesting stats for welcome page
                List<Notification> followers = NotificationFacade.findByUserBeingFollowed(email);
                if(!followers.isEmpty()){
                    session.setAttribute("followers", followers);
                }
                List<Notification> pinboards = NotificationFacade.findByPinboardBeingFollowed(email);
                if(!pinboards.isEmpty()){
                    session.setAttribute("pinboards", pinboards);
                }
                
                System.out.println(followers);
                List<TrackLogin> login = TrackLoginFacade.LoginsPast2Weeks(email);
                Integer loginCount = login.size();
                session.setAttribute("loginCount",loginCount);
                List<UserFollowsUser> numFollower = UserFollowsUserFacade.findByPersonBeingFollowedandisPermitted(email, Boolean.TRUE);
                Integer followerCount = numFollower.size();
                session.setAttribute("followerCount",followerCount);
                List<UserFollowsUser> numFollowed = UserFollowsUserFacade.findByFollowerandisPermitted(email, Boolean.TRUE);
                Integer followedCount = numFollowed.size();
                session.setAttribute("followedCount", followedCount);
                List<Topics> createdTopics = TopicsFacade.findAll();
                session.setAttribute("topic", createdTopics);
                String topicsinstring = user.getSelectedtopics();
                String[] selected_Topics = topicsinstring.split(",");
                List<Pins> selPins = new ArrayList<Pins>();
                //display trending pins based on selected topics during registration
                for(int i=0; i< selected_Topics.length ; i++){
                    session.setAttribute("selectedTopic"+ (i+1), selected_Topics[i]);
                    System.out.println(selected_Topics[i]);
                    List<Pins> selTopicPins = PinsFacade.findByTopicsName(selected_Topics[i]);
                    for (Pins pins: selTopicPins){
                    selPins.add(i,pins);
                    }
                    session.setAttribute("selPins", selPins);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
                rd.forward(request, response);
            } else if (user !=null && user.getIsAdmin()== true && user.getIsBlocked()== false) {
                String userName = user.getUsername();
                LoginInfo.setLoginInfo(session, new LoginInfo(method,user));
                //Set session object with attributes user, method and loginDate
                session.setAttribute("user",email);
                session.setAttribute("method", method);
                session.setAttribute("userName", userName);
                Date lastLogin = new Date(); 
                session.setAttribute("loginDate", lastLogin);
                    
                //Insert last_login field into user row
                user.setLastLogin(lastLogin);
                UserFacade.edit(user);
        
                //Persists Login Data in track_login table
                TrackLoginPK loginKey = new TrackLoginPK();
                loginKey.setEmail(email);
                loginKey.setLastLogin(lastLogin);
                TrackLogin loginEntry = new TrackLogin();
                loginEntry.setTrackLoginPK(loginKey);
                loginEntry.setStillLoggedIn(true);
                TrackLoginFacade.create(loginEntry);
                
                //Get interesting stats for admin page
                
                List<TrackLogin> login = TrackLoginFacade.LoginsPast2Weeks(email);
                Integer loginCount = login.size();
                session.setAttribute("loginCount",loginCount);
                List<TrackLogin> online = TrackLoginFacade.findByStillLoggedIn(Boolean.TRUE);
                Integer onlineCount = online.size();
                session.setAttribute("onlineUsersCount",onlineCount);
                List<User> totalusers = UserFacade.findAll();
                Integer regUsersCount = totalusers.size();
                session.setAttribute("regUsersCount",regUsersCount);
                List<UserFollowsUser> numFollower = UserFollowsUserFacade.findByPersonBeingFollowedandisPermitted(email, Boolean.TRUE);
                Integer followerCount = numFollower.size();
                session.setAttribute("followerCount",followerCount);
                List<UserFollowsUser> numFollowed = UserFollowsUserFacade.findByFollowerandisPermitted(email, Boolean.TRUE);
                Integer followedCount = numFollowed.size();
                session.setAttribute("followedCount", followedCount);
                List<Topics> createdTopics = TopicsFacade.findAll();
                Integer createdTopicsCount = createdTopics.size();
                session.setAttribute("topic", createdTopics);
                System.out.println(createdTopicsCount);
                session.setAttribute("createdTopicsCount", createdTopicsCount);
                List<Pins> usedPins = PinsFacade.findAll();
                Integer usedPinsCount = usedPins.size();
                Integer AvgPin = usedPinsCount/regUsersCount;
                session.setAttribute("usedPinsCount",usedPinsCount);
                session.setAttribute("AvgPin", AvgPin);
                List<Pinboards> usedBoards = PinboardsFacade.findAll();
                Integer usedBoardsCount = usedBoards.size();
                Integer AvgBoard = usedBoardsCount/regUsersCount;
                session.setAttribute("usedBoardsCount",usedBoardsCount);
                session.setAttribute("AvgBoard", AvgBoard);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
                rd.forward(request, response);
            } else if(user.getIsBlocked()==true){
                request.setAttribute("error1", "You are blocked. Please contact your administrator.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }else {
                request.setAttribute("error1", "Credentials provided are incorrect. Please make sure email and password are correct");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
            
        } else if(method==LoginInfo.Method.GOOGLE) {
            //for GOOGLE or FACEBOOK login, only email can be authenticated
            User user = UserFacade.find(email);
            if (user != null && user.getIsAdmin()== false && user.getIsBlocked()== false){
                //System.out.println(user);
                //System.out.println(s_method);
                String userName = user.getUsername();
                LoginInfo.setLoginInfo(session, new LoginInfo(method,user));
                
                //Set session object with attributes user, method and loginDate
                session.setAttribute("user",email);
                session.setAttribute("method", s_method);
                session.setAttribute("userName", userName);
                Date lastLogin = new Date(); 
                session.setAttribute("loginDate", lastLogin);
                    
                //Insert last_login field into user row
                user.setLastLogin(lastLogin);
                UserFacade.edit(user);
        
                //Persists Login Data in track_login table
                TrackLoginPK loginKey = new TrackLoginPK();
                loginKey.setEmail(email);
                loginKey.setLastLogin(lastLogin);
                TrackLogin loginEntry = new TrackLogin();
                loginEntry.setTrackLoginPK(loginKey);
                TrackLoginFacade.create(loginEntry);
                //Get interesting stats for welcome page
                
                List<Notification> followers = NotificationFacade.findByUserBeingFollowed(email);
                if(!followers.isEmpty()){
                    session.setAttribute("followers", followers);
                }
                List<Notification> pinboards = NotificationFacade.findByPinboardBeingFollowed(email);
                if(!pinboards.isEmpty()){
                    session.setAttribute("pinboards", pinboards);
                }
                   
                List<TrackLogin> login = TrackLoginFacade.LoginsPast2Weeks(email);
                Integer loginCount = login.size();
                session.setAttribute("loginCount",loginCount);
                List<UserFollowsUser> numFollower = UserFollowsUserFacade.findByPersonBeingFollowedandisPermitted(email, Boolean.TRUE);
                Integer followerCount = numFollower.size();
                session.setAttribute("followerCount",followerCount);
                List<UserFollowsUser> numFollowed = UserFollowsUserFacade.findByFollowerandisPermitted(email, Boolean.TRUE);
                Integer followedCount = numFollowed.size();
                session.setAttribute("followedCount", followedCount);
                List<Topics> createdTopics = TopicsFacade.findAll();
                session.setAttribute("topic", createdTopics);
                String topicsinstring = user.getSelectedtopics();
                String[] selected_Topics = topicsinstring.split(",");
                List<Pins> selPins = new ArrayList<Pins>();
                
                //display trending pins based on selected topics during registration
                for(int i=0; i< selected_Topics.length ; i++){
                    session.setAttribute("selectedTopic"+ (i+1), selected_Topics[i]);
                    System.out.println(selected_Topics[i]);
                    List<Pins> selTopicPins = PinsFacade.findByTopicsName(selected_Topics[i]);
                    for (Pins pins: selTopicPins){
                    selPins.add(i,pins);
                    }
                    session.setAttribute("selPins", selPins);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/welcome.jsp");
                rd.forward(request, response);
            } else if (user != null && user.getIsAdmin()==true && user.getIsBlocked()==false){
                String userName = user.getUsername();
                LoginInfo.setLoginInfo(session, new LoginInfo(method,user));
                //Set session object with attributes user, method and loginDate
                session.setAttribute("user",email);
                session.setAttribute("method", method);
                session.setAttribute("userName", userName);
                Date lastLogin = new Date(); 
                session.setAttribute("loginDate", lastLogin);
                    
                //Insert last_login field into user row
                user.setLastLogin(lastLogin);
                UserFacade.edit(user);
        
                //Persists Login Data in track_login table
                TrackLoginPK loginKey = new TrackLoginPK();
                loginKey.setEmail(email);
                loginKey.setLastLogin(lastLogin);
                TrackLogin loginEntry = new TrackLogin();
                loginEntry.setTrackLoginPK(loginKey);
                TrackLoginFacade.create(loginEntry);
                
                //Get interesting stats for admin page
                List<TrackLogin> result = TrackLoginFacade.LoginsPast2Weeks(email);
                Integer loginCount = result.size();
                session.setAttribute("loginCount",loginCount);
                List<TrackLogin> online = TrackLoginFacade.findByStillLoggedIn(Boolean.TRUE);
                Integer onlineCount = online.size();
                session.setAttribute("onlineUsersCount",onlineCount);
                List<User> totalusers = UserFacade.findAll();
                Integer regUsersCount = totalusers.size();
                session.setAttribute("regUsersCount",regUsersCount);
                List<UserFollowsUser> numFollower = UserFollowsUserFacade.findByPersonBeingFollowedandisPermitted(email,Boolean.TRUE);
                Integer followerCount = numFollower.size();
                session.setAttribute("followerCount",followerCount);
                List<UserFollowsUser> numFollowed = UserFollowsUserFacade.findByFollowerandisPermitted(email, Boolean.TRUE);
                Integer followedCount = numFollowed.size();
                session.setAttribute("followedCount", followedCount);
                List<Topics> createdTopics = TopicsFacade.findAll();
                session.setAttribute("topic", createdTopics);
                List<Pins> usedPins = PinsFacade.findAll();
                Integer usedPinsCount = usedPins.size();
                Integer AvgPin = usedPinsCount/regUsersCount;
                session.setAttribute("usedPinsCount",usedPinsCount);
                session.setAttribute("AvgPin", AvgPin);
                List<Pinboards> usedBoards = PinboardsFacade.findAll();
                Integer usedBoardsCount = usedBoards.size();
                Integer AvgBoard = usedBoardsCount/regUsersCount;
                session.setAttribute("usedBoardsCount",usedBoardsCount);
                session.setAttribute("AvgBoard", AvgBoard);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
                rd.forward(request, response);
            } else if(user.getIsBlocked()==true){
                request.setAttribute("error1", "You are blocked. Please contact your administrator.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }else {
                request.setAttribute("error1", "Credentials provided are incorrect. Please try other means of authentication");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
        }
    }
    
   
}

        
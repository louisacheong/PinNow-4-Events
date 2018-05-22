/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pinboards;
import entity.PinboardsPK;
import entity.Topics;
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
import session.TopicsFacade;
import session.UserFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "searchTopicsServlet", urlPatterns = {"/searchTopics"})
public class searchTopicsServlet extends HttpServlet {
    
    @EJB private UserFacade UserFacade;
    @EJB private PinboardsFacade PinboardsFacade;
    @EJB private TopicsFacade TopicsFacade;
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String search = request.getParameter("searchtext");
        String searchText = search.trim();
        String[] foundkeywords = searchText.split(" ");
        List<Topics> topics = TopicsFacade.findAll();
        //create List of topics in string for matching search
        String[] topicnames = new String[topics.size()];
        //create Set of foundTopics with unique topic names
        Set<Topics> foundTopics = new HashSet<>();
        //Populate List of topics
        for (int i=0; i<topics.size(); i++){
            Topics topic = topics.get(i);
            String topicname = topic.getName();
            topicnames[i] = topicname;
            for(String s:foundkeywords){
                topicnames[i] = topicnames[i].toLowerCase();
                s=s.toLowerCase();
                //comparison is case-insensitive
                if(topicnames[i].contains(s)){
                    String topicName = topicnames[i];
                    Topics foundTopicItems = TopicsFacade.findByName(topicName);
                    foundTopics.add(foundTopicItems);
                    }}}
        if (foundTopics.size()>0){
            request.setAttribute("foundTopics", foundTopics);
            System.out.println("checkpoint1");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/welcome.jsp");
            rd.include(request, response);
        }else{
            request.setAttribute("searcherror1","No topic matching your search text is found");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/welcome.jsp");
            rd.include(request, response);
        }
        }
}




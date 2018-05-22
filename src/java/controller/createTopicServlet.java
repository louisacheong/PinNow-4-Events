/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import entity.Topics;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PinsFacade;
import session.TopicsFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "createTopicServlet", urlPatterns = {"/createTopic"})
public class createTopicServlet extends HttpServlet {

    @EJB private TopicsFacade TopicsFacade;
    @EJB private PinsFacade PinsFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String newtopic = request.getParameter("newtopic");
       
       
        try{
            TopicsFacade.findByName(newtopic);
        }catch(Exception e){
            Topics topic = new Topics();
            Date createTime = new Date();
            topic.setName(newtopic);
            topic.setCreateTime(createTime);
            try{
                TopicsFacade.create(topic);
                request.setAttribute("newTopicStatus", "New Topic '" + newtopic + " is created" );
                List<Topics> createdTopics = TopicsFacade.findAll();
                Integer createdTopicsCount = createdTopics.size();
                session.setAttribute("topic", createdTopics);
                session.setAttribute("createdTopicsCount", createdTopicsCount);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
                rd.include(request, response);
            }catch(Exception err){
                request.setAttribute("newTopicStatus", "Error in creating '" + newtopic);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
                rd.include(request, response);
            }
            request.setAttribute("newTopicStatus", "Topic '" + newtopic + "' already exists!" );
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
            rd.include(request, response);
        }
        
}}

  



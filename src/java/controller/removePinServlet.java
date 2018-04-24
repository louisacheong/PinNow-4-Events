/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pins;
import entity.PinsPK;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "removePinServlet", urlPatterns = {"/removePin"})
public class removePinServlet extends HttpServlet {
    @EJB private PinsFacade PinsFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String email =(String)session.getAttribute("user");
        String pinName = request.getParameter("pinName");
        String topicName = request.getParameter("topicName");
        PinsPK pinkeytmp = new PinsPK();
        pinkeytmp.setName(pinName);
        pinkeytmp.setTopicsName(topicName);
        pinkeytmp.setUserEmail(email);
        Pins pin = PinsFacade.find(pinkeytmp);
        PinsFacade.remove(pin);
        request.setAttribute("boardstatus","Removed: " + pinName + " successfully");
        
        //delete file from upload folder
        Path path = FileSystems.getDefault().getPath("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/applications/", pinName);
        System.out.println("Path" + path);
        Files.deleteIfExists(path);
       
        //include info on pins 
        List<Pins> pinlist = PinsFacade.findByUserEmail(email);
        session.setAttribute("pins", pinlist);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
        rd.include(request,response);
        
    }

}

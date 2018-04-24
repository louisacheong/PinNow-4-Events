/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pins;
import entity.PinsPK;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PinsFacade;
import session.TopicsFacade;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "uploadContentAServlet", urlPatterns = {"/uploadContentA"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*3) 
public class uploadContentAServlet extends HttpServlet {

    @EJB private PinsFacade PinsFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String topicname = request.getParameter("topic");
        Part imageFile = request.getPart("imageFile");
        String filename = imageFile.getSubmittedFileName();
        String path = "/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/applications/";

        
        File directory = new File(path);
        //auto-generate unique filename to prevent users from overwriting existing files which happen to have same names
        File file= File.createTempFile(filename,".jpg", directory);
        String pinName = file.getName();
        System.out.println(pinName);
        
        try(InputStream input = imageFile.getInputStream()){
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            PinsPK newpinkey = new PinsPK();
            newpinkey.setTopicsName(topicname);
            newpinkey.setName(pinName);
            System.out.println(pinName);
            System.out.println(topicname);
            Pins newpinentry = new Pins();
            newpinentry.setPinsPK(newpinkey);
            Date current = new Date();
            newpinentry.setCreateTime(current);
            newpinentry.setLastPinned(current);
            PinsFacade.create(newpinentry);
            request.setAttribute("newContentStatus", "File is successfully uploaded!");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
            rd.include(request, response);
        } catch (Exception e){
            request.setAttribute("newContentStatus", "Error uploading file, please try again later");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin.jsp");
            rd.include(request, response);
            
        }
        
   
    }
}
        
       
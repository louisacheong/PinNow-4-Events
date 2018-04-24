/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Pins;
import entity.PinsPK;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import session.PinsFacade;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "uploadContentServlet", urlPatterns = {"/uploadContent"})
@MultipartConfig(location="/tmp", maxFileSize=16177215) //File Size 16MB
public class uploadContentServlet extends HttpServlet {
    @EJB private PinsFacade PinsFacade;
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String topicname = request.getParameter("topic");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        Part imageFile = request.getPart("imageFile");
        String filename = removeExtension(imageFile.getSubmittedFileName());
        String path = "/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/applications/";

        
        File directory = new File(path);
        //auto-generate unique filename to prevent users from overwriting existing files which happen to have same names
        File file= File.createTempFile(filename,".jpg", directory);
        String pinName = file.getName();
        System.out.println(pinName);
    
        
        try(InputStream input = imageFile.getInputStream()){
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            //FileInputStream fis = new FileInputStream(file);
            //int fileLength = (int) file.length();
            //byte[] data = new byte[fileLength];
            //fis.read(data, 0, fileLength);
            //fis.close();
            
            //System.out.println(data.toString());
            PinsPK newpinkey = new PinsPK();
            newpinkey.setTopicsName(topicname);
            newpinkey.setName(pinName);
            newpinkey.setUserEmail((String)session.getAttribute("user"));
            System.out.println(pinName);
            System.out.println(topicname);
            Pins newpinentry = new Pins();
            newpinentry.setPinsPK(newpinkey);
            Date current = new Date();
            newpinentry.setCreateTime(current);
            newpinentry.setLastPinned(current);
            newpinentry.setLocation(location);
            newpinentry.setDescription(description);
            PinsFacade.create(newpinentry);
            request.setAttribute("boardstatus", "File is successfully uploaded!");
            
            //include info on pins 
            List<Pins> pinlist = PinsFacade.findByUserEmail((String)session.getAttribute("user"));
            session.setAttribute("pins", pinlist);
            session.setAttribute("pin", newpinentry);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request, response);
        } catch (Exception e){
            request.setAttribute("newContentStatus", "Error uploading file, please try again later");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/profile.jsp");
            rd.include(request, response);
            
        }
        
   
    }

    private String removeExtension(String FileName) {
        if(FileName.indexOf(".")>0){
            return FileName.substring(0,FileName.lastIndexOf("."));
        }else{
            return FileName;
        }
    }
}
        
       
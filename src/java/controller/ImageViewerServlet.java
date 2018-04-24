/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author louisacheong
 */
@WebServlet(name = "ImageViewerServlet", urlPatterns = {"/images"})
public class ImageViewerServlet extends HttpServlet {

    private String pathToImage;
    public void init() throws ServletException{
        //Define path outside web container
        this.pathToImage="/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/applications/";
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requiredImage = request.getParameter("pinName");
        System.out.println("requiredImage" + requiredImage);
        if(requiredImage == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        File image = new File(pathToImage, requiredImage);
        if(!image.exists()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        System.out.println("getServletContext()" + getServletContext());
        String contentType = getServletContext().getMimeType(image.getName());
        if(contentType == null || !contentType.startsWith("image")){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));

        Files.copy(image.toPath(), response.getOutputStream());
    }

}

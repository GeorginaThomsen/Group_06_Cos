/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletControl;

import domain.Controller;
import domain.POE;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Georgina:
 */
@WebServlet(name = "SavePOEServlet", urlPatterns = {"/SavePOEServlet"})
@MultipartConfig
public class SavePOEServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sessionObj = request.getSession(true);
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if (con == null) {
            con = new Controller();
            sessionObj.setAttribute("Controller", con);
        }
        try {
            Part part = request.getPart("file");
            String partnerID = request.getParameter("partnerID");
            int project = Integer.parseInt(request.getParameter("project"));
            String type = part.getHeader("content-type");
            InputStream data = part.getInputStream();

            POE poe = new POE(project, type, data);
            request.setAttribute("partnerID", partnerID);
            request.setAttribute("message",
                    "Upload has been done successfully!");

            con.savePOE(poe);
        } catch (SQLException ex) {

            Logger.getLogger(SavePOEServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
        dispatcher.forward(request, response);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletControl;

import domain.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Georgina:
 */
@WebServlet(name = "GetPOEServlet", urlPatterns = {"/GetPOEServlet"})
@MultipartConfig
public class GetPOEServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession sessionObj = request.getSession(true);
            Controller con = (Controller) sessionObj.getAttribute("Controller");
            if (con == null) {
                con = new Controller();
                sessionObj.setAttribute("Controller", con);
            }
            int projectID = Integer.parseInt(request.getParameter("projectID"));
            con.getPOE(projectID, response);

        } catch (SQLException ex) {
            Logger.getLogger(GetPOEServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletControl;

import domain.Controller;
import domain.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ben
 */
@WebServlet(name = "ShowAllProjectsServlet", urlPatterns = {"/ShowAllProjectsServlet"})
public class ShowAllProjectsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionObj = request.getSession();
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if (con == null) {
            con = new Controller();
            sessionObj.setAttribute("Controller", con);

        }
        readAllProjects(request, response, con);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void readAllProjects(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {

        try {
            ArrayList<Project> projects = con.readAllProjects();

            request.setAttribute("projects", projects);

            RequestDispatcher dispatcher = request.getRequestDispatcher("DellViewAllProjects.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();//getWriter returns a PrintWriter object, that can send character tect to the client
            out.println("<h2>" + e + "</h2><hr>");
            out.print("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");

        }

    }
}

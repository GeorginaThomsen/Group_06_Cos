/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletControl;

import domain.Controller;
import domain.Project;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yagizaydinaksar
 */
@WebServlet(name = "ReadProjectServlet", urlPatterns = {"/ReadProjectServlet"})
public class ReadProjectServlet extends HttpServlet {

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
        {
        //-- Establish or reestablish application context
            HttpSession sessionObj = request.getSession();
            Controller con = (Controller) sessionObj.getAttribute("Controller");
            if (con == null)
            {
                // Session starts
                con = new Controller();
                sessionObj.setAttribute("Controller", con);
            } else
            {
                con = (Controller) sessionObj.getAttribute("Controller");
            }
            
            String command = request.getParameter("command");
             switch (command)
            {
                case "ReadProjectID":
                    getProject(request, response, con);
                    break;
                case "ReadPartnerID":
                    getProject2(request, response, con);
                    break;
                                 
            }
            }
    }
    
    private void getProject(HttpServletRequest request, HttpServletResponse response, Controller con) throws ServletException, IOException
    {
        // get input
        int pno = Integer.parseInt(request.getParameter("ReadProjectID"));

        // do work and get data to output
        Project project = con.getProject(pno);
        request.setAttribute("Project", project);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReadProjectView.jsp");
        dispatcher.forward(request, response);
    }

      private void getProject2(HttpServletRequest request, HttpServletResponse response, Controller con) throws ServletException, IOException
    {
        // get input
        int pno = Integer.parseInt(request.getParameter("ReadPartnerID"));

        // do work and get data to output
        Project project = con.getProject(pno);
        request.setAttribute("Project", project);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReadProjectView.jsp");
        dispatcher.forward(request, response);
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

}

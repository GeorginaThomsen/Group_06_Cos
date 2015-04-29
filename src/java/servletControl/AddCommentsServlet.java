/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletControl;

import domain.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "AddCommentsServlet", urlPatterns = {"/AddCommentsServlet"})
public class AddCommentsServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        HttpSession sessionObj = request.getSession();
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if (con == null) {
            con = new Controller();
            sessionObj.setAttribute("Controller", con);

        }

        String command = request.getParameter("command");
        switch (command) {
            case "addComments":
                addComments(request, response, con);
                break;

            case "getComments":
                getComments(request, response, con);
                break;
            case "addFinanceComments":
                addComments(request, response, con);
                break;

            case "getFinanceComments":
                getComments(request, response, con);
                break;

        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCommentsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCommentsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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


    private void addComments(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {

        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
           
            String comments = request.getParameter("newComments");
            if (!checkForComments(pro, con)) {
                con.insertComments(pro, comments);

            } else {
                con.upDateComments(pro, comments);
                String projectID = Integer.toString(pro);
                String comment = "Your Comments have been added to Project No: " + projectID;
                request.setAttribute("projectID", projectID);
                request.setAttribute("comment", comment);
                request.setAttribute("comments", comments);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");
                dispatcher.forward(request, response);

            }

            String projectID = Integer.toString(pro);
            String comment = "Your Comments have been added to Project No: " + projectID;
                request.setAttribute("comments", comments);
            request.setAttribute("comment", comment);
            request.setAttribute("projectID", projectID);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");

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
    private void addFinanceComments(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {

        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
           
            String comments = request.getParameter("newComments");
            if (!checkForComments(pro, con)) {
                con.insertComments(pro, comments);

            } else {
                con.upDateComments(pro, comments);
                String projectID = Integer.toString(pro);
                String comment = "Your Comments have been added to Project No: " + projectID;
                request.setAttribute("projectID", projectID);
                request.setAttribute("comment", comment);
                request.setAttribute("comments", comments);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");
                dispatcher.forward(request, response);

            }

            String projectID = Integer.toString(pro);
            String comment = "Your Comments have been added to Project No: " + projectID;
                request.setAttribute("comments", comments);
            request.setAttribute("comment", comment);
            request.setAttribute("projectID", projectID);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");

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

    private boolean checkForComments(int projectID, Controller con) throws SQLException {
        return con.checkForComments(projectID);
    }

    private void getComments(HttpServletRequest request, HttpServletResponse response, Controller con) throws SQLException, IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String projectID = Integer.toString(pro);

            String comments = con.getComments(pro);
            String comment = "Your Comments have been added to Project No: " + projectID;
            request.setAttribute("comment", comment);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");

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
    private void getFinanceComments(HttpServletRequest request, HttpServletResponse response, Controller con) throws SQLException, IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String projectID = Integer.toString(pro);

            String comments = con.getComments(pro);
            String comment = "Your Comments have been added to Project No: " + projectID;
            request.setAttribute("comment", comment);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmComments.jsp");

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

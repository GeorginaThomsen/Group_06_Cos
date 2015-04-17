package servletControl;

import datasource.ProjectMapper;
import domain.Controller;
import domain.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Georgina Thomsen
 */
@WebServlet(name = "RequestProjectServlet", urlPatterns = {"/RequestProjectServlet"})
public class RequestProjectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
            {
        
        HttpSession sessionObj = request.getSession(true);
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if(con == null){
            con = new Controller();
            sessionObj.setAttribute("Controller", con);
        } 
        insertProject(request, response, con);
        
    }
        private void insertProject(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException{
        
        
        try{ 
        //Get the info from the RequestProject form:
        //int id = Integer.parseInt(request.getParameter("ProjectID"));
        String act = request.getParameter("ActivityDescription");
        String com = request.getParameter("Comments");
        Float cost = Float.parseFloat(request.getParameter("Cost"));
        String mdf = request.getParameter("MDFBudget");
        String eQ = request.getParameter("ExecutionQuarter");
        String end = request.getParameter("StartDate");
        String start = request.getParameter("EndDate");
        String obj = request.getParameter("ObjAndResult");
        String pOE = request.getParameter("RequiredPOE");

        Project project = con.insertProject(act, com, cost, mdf, eQ, end, start, obj, pOE);
        
        //Forwards to view:
        request.setAttribute("RPV", project);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RequestProjectView.jsp");
        
            dispatcher.forward(request, response);
        } catch(Exception e){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();//getWriter returns a PrintWriter object, that can send character tect to the client
            out.println("<h2>" + e + "</h2><hr>");
            out.print("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
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

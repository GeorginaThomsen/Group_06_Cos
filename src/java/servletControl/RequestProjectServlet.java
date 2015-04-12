package servletControl;

import domain.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy");//Change at a later time to mm dd yyyy

        //Get the info from the RequestProject form:
        int id = Integer.parseInt(request.getParameter("ProjectID"));
        String act = request.getParameter("ActivityDescription");
        String com = request.getParameter("Comments");
        Float cost = Float.parseFloat(request.getParameter("Cost"));
        String mdf = request.getParameter("MDFBudget");
        String eQ = request.getParameter("ExecutionQuarter");
        Date end = null;//Initialize
        Date start = null;
        //Added a try catch because of the Date format
        try {
            end = parserSDF.parse(request.getParameter("StartDate"));
            start = parserSDF.parse(request.getParameter("EndDate"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        String obj = request.getParameter("ObjAndResult");
        String pOE = request.getParameter("RequiredPOE");

        // Makes a new Project object:
        Project p = new Project(id, act, com, cost, mdf, eQ, end, start, obj, pOE);
//        System.out.println(p);
//-----------------------------
       

        //---------------------------
        //Forwards to view:
        request.setAttribute("RPV", p);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RequestProjectView.jsp");
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

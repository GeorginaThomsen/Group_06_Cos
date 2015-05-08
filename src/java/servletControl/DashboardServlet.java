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
@WebServlet(name = "DashboardServlet", urlPatterns = {"/DashboardServlet"})
public class DashboardServlet extends HttpServlet {

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
        String command = request.getParameter("command");
        switch (command) {

            case "viewComments":
                viewComments(request, response, con);
                break;
            case "readAllPartnerProjects":
                readAllPartnerProjects(request, response, con);
                break;
            case "requestProject":
                requestProject(request, response, con);
                break;
            case "editProject":
                editProject(request, response, con);
                break;
            case "updateAct":
                updateAct(request, response, con);
                break;
            case "updateCom":
                updateCom(request, response, con);
                break;
            case "updateCost":
                updateCost(request, response, con);
                break;
            case "updatePoe":
                updatePoe(request, response, con);
                break;
            case "updateObj":
                updateObj(request, response, con);
                break;
            case "SavePOE":
                SavePOE(request, response, con);
                break;
        }
//        readAllPartnerProjects(request, response, con );

    }

    private void readAllPartnerProjects(HttpServletRequest request, HttpServletResponse response, Controller con) throws ServletException, IOException {

        try {
            int partnerID = Integer.parseInt(request.getParameter("partnerID"));
            String username = request.getParameter("username");
            ArrayList<Project> projects = con.getAllPartnerProjects(partnerID);

            request.setAttribute("username", username);
            request.setAttribute("partnerID", partnerID);
            request.setAttribute("projects", projects);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerViewAllProjects.jsp");
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

    private void viewComments(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("project"));
            Project project = con.getCompleteProject(pro);
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");

            String comments = con.getComments(pro);

                        request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("partnerID", partnerID);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerViewComments.jsp");
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

    private void editProject(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            Project project = con.getCompleteProject(pro);
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");

            String comments = con.getComments(pro);

                        request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("partnerID", partnerID);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void updateAct(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String act = request.getParameter("newAct");
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");

            String column = "activitydescription";
            con.editProject(pro, column, act);
            Project project = con.getCompleteProject(pro);
            String comments = con.getComments(pro);

                        request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("partnerID", partnerID);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void updateCom(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String com = request.getParameter("newComments");
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");


            String column = "comments";
            con.editProject(pro, column, com);
            Project project = con.getCompleteProject(pro);
            String comments = con.getComments(pro);

            request.setAttribute("partnerID", partnerID);
            request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void updateCost(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            float cos = Float.parseFloat(request.getParameter("newCost"));
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");


            String column = "cost";
            con.editCost(pro, column, cos);
            Project project = con.getCompleteProject(pro);
            String comments = con.getComments(pro);

            request.setAttribute("partnerID", partnerID);
            request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void updatePoe(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");


            String poe = request.getParameter("newPOE");
            String column = "poe";
            con.editProject(pro, column, poe);
            Project project = con.getCompleteProject(pro);
            String comments = con.getComments(pro);

            request.setAttribute("partnerID", partnerID);
            request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void updateObj(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int pro = Integer.parseInt(request.getParameter("projectID"));
            String partnerID = request.getParameter("partnerID");
                        String username = request.getParameter("username");


            String obj = request.getParameter("newObj");
            String column = "objandresult";
            con.editProject(pro, column, obj);
            Project project = con.getCompleteProject(pro);
            String comments = con.getComments(pro);

            request.setAttribute("partnerID", partnerID);
            request.setAttribute("username", username);

            request.setAttribute("project", project);
            request.setAttribute("comments", comments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEditProject.jsp");
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

    private void requestProject(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int partnerID = Integer.parseInt(request.getParameter("partnerID"));
            String username = request.getParameter("username");

            request.setAttribute("username", username);
            request.setAttribute("partnerID", partnerID);
            RequestDispatcher dispatcher = request.getRequestDispatcher("RequestProject.jsp");
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

    //Georgina:
    private void SavePOE(HttpServletRequest request, HttpServletResponse response, Controller con) throws IOException {
        try {
            int partnerID = Integer.parseInt(request.getParameter("partnerID"));
            String project = request.getParameter("project");

            String username = request.getParameter("username");
//            int pro = Integer.parseInt(request.getParameter("projectID"));

            request.setAttribute("project", project);
            request.setAttribute("username", username);
            request.setAttribute("partnerID", partnerID);
//            request.setAttribute("projectID", pro);

            RequestDispatcher dispatcher = request.getRequestDispatcher("SavePOE.jsp");
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

<%-- 
    Document   : PartnerViewAllProjects
    Created on : Apr 13, 2015, 3:38:23 PM
    Author     : Ben
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Projects</title>
    </head>
    <body>
        <form action="DashboardServlet" method="post">
            <h1>View All Projects</h1>

            Projects For Partner :<%= request.getAttribute("username")%>
            <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">

            <!-- <%= request.getAttribute("partnerID")%> -->

            <h2>Project Details</h2>
            <%
                ArrayList<Project> projects = (ArrayList<Project>) request.getAttribute("projects");
            %>



            <table border="1" style="width:100%">
                <table >

                    <tr>
                        <th>Select</th>
                        <th> Activity Description  </th>     
                        <th> Comments  </th> 
                        <th> Cost  </th> 
                        <th> MDF Budget  </th> 
                        <th> Execution Quarter  </th> 
                        <th> Start Date  </th> 
                        <th> End Date  </th> 
                        <th> Objective & Result  </th> 
                        <th>Required POE  </th> 

                    </tr>
                    <%
                        for (int i = 0; i < projects.size(); i++) {
                    %>
                    <!--       <%= projects.get(i).getProjectID()%> -->
                    <tr>
                        <td><input type="radio" name="project" value="<%= projects.get(i).getProjectID()%>"></td>
                        <td><%= projects.get(i).getActivityDescription()%></td>
                        <td><%= projects.get(i).getComments()%></td>
                        <td><%= projects.get(i).getCost()%></td>
                        <td><%= projects.get(i).getMDFBudget()%></td>
                        <td><%= projects.get(i).getExecutionQuarter()%></td>
                        <td><%= projects.get(i).getStartDate()%></td>
                        <td><%= projects.get(i).getEndDate()%></td>
                        <td><%= projects.get(i).getObjAndResult()%></td>
                        <td><%= projects.get(i).getRequiredPOE()%></td>
                    </tr>

                    <%}%>
                </table><br><br>

                <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                <button type="submit" name="command" value="viewComments">View Comments</button><br><br>
                <button type="submit" name="command" value="requestProject">Request New Project</button><br><br>
                <button type="submit" name="command" value="SavePOE">Upload POE</button><br><br>


                </form>
                </body>
                </html>

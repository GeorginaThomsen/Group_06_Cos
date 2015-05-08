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
        <title>View All Projects | Partner MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="bottomcontainer">
                <div class="logowrap"><img src="images/logo2.png"></div>    
                <nav>
                    <ul>
                        <li><form action="DashboardServlet" method="post">  
                                <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
                                <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
                                <button type="submit" name="command" value="readAllPartnerProjects">My Projects</button>
                            </form> 

                        </li> 
                        <li>
                            <form action="DashboardServlet" method="post">
                                <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                                <button type="submit" name="command" value="requestProject">Request New Project</button>
                            </form> 
                        </li>

                    </ul> 
                </nav>
            </div>
        </header>

        <div class="container">

            <form action="DashboardServlet" method="post">
                <h1>My Projects</h1>
                <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" >
                <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">

                <!-- <%= request.getAttribute("partnerID")%> -->

                <%
                    ArrayList<Project> projects = (ArrayList<Project>) request.getAttribute("projects");
                %>



                <table border="1" style="width:100%">
                    <table >

                        <tr>
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
                            <td><%= projects.get(i).getActivityDescription()%></td>
                            <td><%= projects.get(i).getComments()%></td>
                            <td><%= projects.get(i).getCost()%></td>
                            <td><%= projects.get(i).getMDFBudget()%></td>
                            <td><%= projects.get(i).getExecutionQuarter()%></td>
                            <td><%= projects.get(i).getStartDate()%></td>
                            <td><%= projects.get(i).getEndDate()%></td>
                            <td><%= projects.get(i).getObjAndResult()%></td>
                            <td><%= projects.get(i).getRequiredPOE()%></td>
                            <td><input type="radio" name="project" value="<%= projects.get(i).getProjectID()%>" required></td>
                        </tr>

                        <%}%>
                    </table>

                    <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                    <button type="submit" name="command" value="viewComments">View Comments</button>
                    <button type="submit" name="command" value="SavePOE">Upload POE</button><br/>

            </form>
        </div>
    </body>
</html>

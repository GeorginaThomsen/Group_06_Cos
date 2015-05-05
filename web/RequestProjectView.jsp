<%-- 
    Document   : RequestProjectView
    Created on : 09-04-2015, 11:10:27
    Author     : Georgina
--%>
<%-- BCE? Should jsp go through the controller or is that just normal java classes?--%>
<%@page import="domain.Project" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partner MDF Tool</title>
    </head>
    <body>
        <form action="DashboardServlet" method="post">
               <input type="hidden" name="username" value="<%= request.getAttribute("username")%>"><br>
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"><br>
        <h1>New Project Created By:<%= request.getAttribute("username")%></h1>
        <br>
        <% Project newproject = (Project) request.getAttribute("RPV");%>
        <% if (newproject != null) {%>

        <%--Project id:               <%= newproject.getProjectID() %><br>--%>
        Activity Description:     <%= newproject.getActivityDescription()%><br>
        Comments: <%= newproject.getComments()%><br>
        Cost: <%= newproject.getCost()%><br>
        MDF Budget: <%= newproject.getMDFBudget()%><br>
        Execution Quarter: <%= newproject.getExecutionQuarter()%><br>
        Start Date: <%= newproject.getStartDate()%><br>
        End Date: <%= newproject.getEndDate()%><br>
        Objective & Result: <%= newproject.getObjAndResult()%><br>
        Required POE: <%= newproject.getRequiredPOE()%><br>
        <%--Status: <%= newproject.getStatus() %>--%>


        <% }%>
        <br>
        <%--
        Have to display the info from RequestProject
        --%>
                            <button type="submit" name="command" value="readAllPartnerProjects">View All Projects</button><br><br>
        </form>

    </body>
</html>

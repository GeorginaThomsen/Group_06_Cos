<%-- 
    Document   : ReadProjectView
    Created on : Apr 10, 2015, 9:28:18 AM
    Author     : yagizaydinaksar
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Project</title>
    </head>

    <h1>Read Project</h1>

    <% Project p = (Project) request.getAttribute("project");%>
    <%  if (p != null) {%>
    <h2>Project</h2>
    Project ID:     <%= p.getProjectID()%><br>
    Activity Description:     <%= p.getActivityDescription()%><br>
    Comments: <%= p.getComments()%><br>
    Cost: <%= p.getCost()%><br>
    MDF Budget: <%= p.getMDFBudget()%><br>
    Execution Quarter: <%= p.getExecutionQuarter()%><br>
    Start Date: <%= p.getStartDate()%><br>
    End Date: <%= p.getEndDate()%><br>
    Objective & Result: <%= p.getObjAndResult()%><br>
    Required POE: <%= p.getRequiredPOE()%><br>
    <% }%>
    <br>
    <%--
    Have to display the info from ReadProject
    --%>

</html>

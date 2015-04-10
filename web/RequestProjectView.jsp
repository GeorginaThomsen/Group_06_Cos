<%-- 
    Document   : RequestProjectView
    Created on : 09-04-2015, 11:10:27
    Author     : Cookie
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
       <h1>Request Project</h1>
       <br>
        <% Project newproject = (Project) request.getAttribute("RPV");%>
        <% if(newproject != null){    %>
        
        Activity Description:     <%= newproject.getActivityDescription()  %><br>
        Comments: <%= newproject.getComments() %><br>
        Cost: <%= newproject.getCost() %><br>
        MDF Budget: <%= newproject.getMDFBudget() %><br>
        Execution Quarter: <%= newproject.getExecutionQuarter() %><br>
        Start Date: <%= newproject.getStartDate() %><br>
        End Date: <%= newproject.getEndDate() %><br>
        Objective & Result: <%= newproject.getObjAndResult() %><br>
        Required POE: <%= newproject.getRequiredPOE() %><br>
        
         <% } %>
         <br>
        <%--
        Have to display the info from RequestProject
        --%>
    </body>
</html>

<%-- 
    Document   : ViewPOE
    Created on : 04-05-2015, 09:50:49
    Author     : Georgina:
--%>

<%@page import="domain.POE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MDF Tool</title>
    </head>
    <body>
        <h1>POE</h1>
        <form action="GetPOEServlet" method="post">
            Project ID: <input type="text" name="projectID" value="<%= request.getParameter("project")%>"><br><br>
            <button> View POE </button>
            <% POE newPOE = (POE) request.getAttribute("POE");%>
        <% if (newPOE != null) {%>
        POE:    <%=newPOE.getData()%><br>
        <% }%>
        <img src="POE" alt="image">
            
        </form><br><br>
        <form action="ShowAllProjectsServlet" method="post">                      
                       <button name="DellLogInButton" value="">Back To All Projects</button>
                        </form>
    </body>
</html>

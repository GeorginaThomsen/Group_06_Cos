<%-- 
    Document   : SavePOE
    Created on : 30-04-2015, 17:09:12
    Author     : Georgina:
--%>

<%@page import="domain.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MDF Tool</title>
    </head>
    <body>
        <h1>Upload POE</h1>
        <form action="SavePOEServlet" method="post" enctype="multipart/form-data" >
            
            
            
            <input type="hidden" name="username" value="<%= request.getAttribute("username")%>"><br>
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"><br>

            ProjectID: <input type="text" name="project" value="<%= request.getAttribute("project")%>"><br><br>
            <input type="file" name="file"  ><%--Add multiple="multiple" if I have time --%>
            <input type="hidden" name="command" value="SavePOE">

            <button> submit POE </button>
        </form>
    </body>
</html>

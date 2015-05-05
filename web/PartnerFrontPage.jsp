<%-- 
    Document   : PartnerFrontPage
    Created on : 09-04-2015, 19:11:50
    Author     : Georgina Thomsen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partner MDF Tool</title>
    </head>
    <body>
        <h1>Partner Front Page</h1>
        <form action="DashboardServlet" method="post">
            
        Welcome: <input type="text" name="username" value="<%= request.getAttribute("username")%>" readonly>
         <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
            <button type="submit" name="command" value="readAllPartnerProjects">View All Projects</button><br><br>
        </form>
    </body>
</html>


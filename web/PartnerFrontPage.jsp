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
            
         Enter Partner Number:<input type="text" name="PartnerNo"  ><br><br>

            <button type="submit" name="command" value="readAllPartnerProjects">Partner log-in</button><br><br>
        </form>
    </body>
</html>


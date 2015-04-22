<%-- 
    Document   : DellFrontPage
    Created on : 09-04-2015, 19:08:57
    Author     : Georgina Thomsen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dell MDF Tool</title>
    </head>
    <body>
        <h1>See All Projects</h1>
        <form action="ShowAllProjectsServlet" method="post">                      
            <button name="DellLogInButton" value="">Dell log-in</button>
        </form><br><br>
         <h1>See Pending Projects</h1>
        <form action="MarketingServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

            <button name="DellLogInButton" value="">Get Pending Projects</button>
        </form>
    
    </body>
</html>

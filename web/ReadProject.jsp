<%-- 
    Document   : ReadProject
    Created on : Apr 10, 2015, 9:16:46 AM
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
    <body>
        <h1>Read Project</h1>
        <form action="ReadProjectServlet" method="post">
            Project id:  <input type="text" name="ReadProjectID">
            <input type="hidden" name="command" value="ReadProjectID">
            <button name="ReadProjectIDButton" value="" >Find Project</button>
        </form><br/>
        <form action="ReadProjectServlet" method="post">
            Partner id:  <input type="text" name="ReadPartnerID">
            <input type="hidden" name="command" value="ReadPartnerID">
            <button name="ReadPartnerIDButton" value="" >Find Project</button>
        </form>
    </body>
</html>

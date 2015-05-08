<%-- 
    Document   : GetPOE
    Created on : 30-04-2015, 17:08:49
    Author     : Georgina
--%>

<%@page import="domain.POE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>View POE</h1>

        <form action="GetPOEServlet" method="post" >
            Project ID: <input type="text" name="projectID"><br><br>
            <button> View POE </button>

        </form>

    </body>
</html>

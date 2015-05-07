<%-- 
    Document   : MarketingConfirmComments
    Created on : Apr 27, 2015, 8:56:56 AM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Comments JSP</title>
    </head>
    <body>
        <h1>Confirm Comments</h1>
        <form action="AddCommentsServlet" method="post">
            Message: <%= request.getAttribute("comment")%><br><br>
            <input type="hidden" name="projectID" value="<%= request.getAttribute("projectID")%>">  
              
        
             Comments: <%= request.getAttribute("comments")%><br><br>
            <button name="command" value="getComments" >See Complete Comments</button><br><br>
           
        </form>
                     <form action="ShowAllProjectsServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

            <button type="submit" name="command" value="">Back To Pending Projects</button>
        </form><br><br>
    </body>
</html>

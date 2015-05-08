<%-- 
    Document   : FinanceConfirmComments
    Created on : Apr 29, 2015, 9:19:59 AM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comments | Dell MDF Tool</title>
    </head>
    <body>
        <h1>Finance Confirm Comments</h1>
         <form action="AddCommentsServlet" method="post">
             
            Message: <%= request.getAttribute("comment")%><br><br>
            <input type="hidden" name="projectID" value="<%= request.getAttribute("projectID")%>">  
              
        
             Comments: <%= request.getAttribute("comments")%><br><br>
            <button name="command" value="getFinanceComments" >See Complete Comments</button><br><br>
           
        </form>
                     <form action="FinanceInputServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

            <button name="DellLogInButton" value="">Back To Pending Projects</button>
        </form><br><br>
    </body>
</html>

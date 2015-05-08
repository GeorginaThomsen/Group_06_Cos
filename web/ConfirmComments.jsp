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
        <title>Confirm Comments | Dell MDF Tool</title>
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="bottomcontainer">
                <div class="logowrap"><img src="images/logo2.png"></div>    
                <nav>
                    <ul>
                        <li> <form action="AddCommentsServlet" method="post">
                                <input type="hidden" name="projectID" value="<%= request.getAttribute("projectID")%>">  
                                <button name="command" value="getComments" >See Complete Comments</button>
                            </form>
                        </li> 
                        <li><form action="ShowAllProjectsServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

                                <button type="submit" name="command" value="">Back To Pending Projects</button>
                            </form> 
                        </li>

                    </ul> 
                </nav>
            </div>
        </header>
        <div class="container">
            <h1>Comments</h1>
            <form action="AddCommentsServlet" method="post">
                <%= request.getAttribute("comment")%><br><br>
                <input type="hidden" name="projectID" value="<%= request.getAttribute("projectID")%>"> <br/>


                Comments:<br/><br/> <%= request.getAttribute("comments")%><br><br>

            </form>
        </div><br><br>
    </body>
</html>

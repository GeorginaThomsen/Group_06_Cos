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
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                   <li><form action="DashboardServlet" method="post">  
                       <input type="hidden" name="username" value="<%= request.getAttribute("username")%>" readonly>
                       <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>">
                       <button type="submit" name="command" value="readAllPartnerProjects">My Projects</button>
                       
                   </li> 
                   <li>
                       <input type="hidden" name="partner" value="<%= request.getAttribute("partner")%>">
                       <button type="submit" name="command" value="requestProject">Request New Project</button>
                       </form> 
                   </li>
                   
                </ul> 
            </nav>
            </div>
        </header>
            
            <div class="container">
        <h1>Upload POE</h1>
        <form action="SavePOEServlet" method="post" enctype="multipart/form-data" >
            
            
            
            <input type="hidden" name="username" value="<%= request.getAttribute("username")%>"><br>
            <input type="hidden" name="partnerID" value="<%= request.getAttribute("partnerID")%>"><br>

            ProjectID: <input type="text" name="project" value="<%= request.getAttribute("project")%>"><br><br>
            <input type="file" name="file"  ><%--Add multiple="multiple" if I have time --%>
            <input type="hidden" name="command" value="SavePOE">
            <br/><br/><br/>
            <button> Submit POE </button>
        </form>
            </div>
    </body>
</html>

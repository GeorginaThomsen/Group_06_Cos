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
          <h1> Home </h1>  Welcome to Dell MDF Tool Project! <br/><br/> 
            This project is created by Team Dell-icious: Georgina Thomsen, Ben Jones, Adam Palludan, Peter Szkudlarek and Yağız Aydın Aksar
           
         
        
            </div>
    </body>
</html>


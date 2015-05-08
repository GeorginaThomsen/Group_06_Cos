<%-- 
    Document   : FinanceFrontPage
    Created on : May 5, 2015, 11:26:16 PM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Finance Front Page</title>
    </head>
    <body>
       <header>
            <div class="bottomcontainer">
            <div class="logowrap"><img src="images/logo2.png"></div>    
            <nav>
                <ul>
                   <li><form action="ShowAllProjectsServlet" method="post">                      
                       <button name="DellLogInButton" value="">All Projects</button>
                        </form>
                   </li> 
                   
                   <li><form action="FinanceInputServlet" method="get">
                       <button name="DellLogInButton" value="">Finance Pending Projects</button>
                       <input type="hidden" name="command" value="getPendingProjects">
                       </form>
                        </li>
                </ul> 
            </nav>
            </div>
        </header>
        
             <div class="container">
                 <h1> Home </h1>  Welcome to Dell MDF Tool<br/><br/> 
                 This project is created by Team Dell-icious: Peter Szkudlarek, Adam Palludan, Georgina Thomsen, Yağız Aydın Aksar, Ben Jones
                 <br/><br/><br/> <div class="homephoto"><img src ="images/group.jpg" width="500px"/></div>
             </div>
           
    </body>
</html>

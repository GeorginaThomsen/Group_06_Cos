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
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Home | Dell MDF Tool</title>
    </head>
    <body>
        <div class="container">
         <div class="menuwrap">
                <nav>
                    <ul>
                        <li> <img src="images/logo2.png"> </li>
                        
                        <li>  <form action="ShowAllProjectsServlet" method="post">                      
                              <button name="DellLogInButton" value="">All Projects</button>
                              </form>
                        </li>
                        <li> <form action="MarketingServlet" method="post"> 
                                <input type="hidden" name="command" value="getPendingProjects">

            <button name="DellLogInButton" value="">Marketing Pending Projects</button>
        </form>
                        </li>
                        <li> <form action="FinanceInputServlet" method="get">
             <button name="DellLogInButton" value="">Finance Pending Projects</button>
              <input type="hidden" name="command" value="getPendingProjects">
         </form> </li>
                     </ul>
                </nav>           
            </div>
            <div class="contentwrap">
                <header><h1>Home</h1></header>
            
            </div>
           </div>
    </body>
</html>
